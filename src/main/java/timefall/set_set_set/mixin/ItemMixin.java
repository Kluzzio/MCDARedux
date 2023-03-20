package timefall.set_set_set.mixin;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import timefall.set_set_set.stsol.ArmorSet;
import timefall.set_set_set.util.SetContribution;
import timefall.set_set_set.util.SetSetsOfNonSets;

import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    public void set_set_set$addTooltipInfo(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        // Only continue if f3 + h has been toggled to avoid clutter
        if (!context.isAdvanced()) return;

        Item item = stack.getItem();
        ArmorSet armorSet;
        if (item instanceof ArmorItem armorItem)
            if ((armorSet = SetSetsOfNonSets.getArmorSet(armorItem)) != null)
                displaySetTooltip(tooltip, armorSet);
        if (item instanceof TrinketItem trinketItem)
            if ((armorSet = SetSetsOfNonSets.getArmorSet(trinketItem)) != null)
                displaySetTooltip(tooltip, armorSet);
    }

    private static void displaySetTooltip(List<Text> tooltip, ArmorSet armorSet) {
        if (MinecraftClient.getInstance().player != null) {
            int contribution = SetContribution.getArmorSetContribution(MinecraftClient.getInstance().player).getOrDefault(armorSet, 0);
            for (int value : armorSet.getEffectTooltip().keySet()) {
                tooltip.add(Text.literal("(" + value + "/" + armorSet.getMaxContribution() + "): ")
                        .append(armorSet.getTooltipFromContribution(value))
                        .formatted(value <= contribution ? Formatting.ITALIC : Formatting.GRAY));
            }
        }
    }
}
