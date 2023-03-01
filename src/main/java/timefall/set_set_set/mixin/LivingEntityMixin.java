package timefall.set_set_set.mixin;

import net.minecraft.item.ArmorItem;
import org.spongepowered.asm.mixin.Unique;
import timefall.set_set_set.SetSetSet;
import timefall.set_set_set.stsol.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements ISetWearingEntity {

    private static Map<EquipmentSlot, EquipmentSet> setSlots;

    @Inject(method = "onEquipStack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;emitGameEvent(Lnet/minecraft/world/event/GameEvent;)V"))
    public void onEquip(EquipmentSlot slot, ItemStack oldStack, ItemStack newStack, CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        livingEntity.getEquippedStack(slot);

        for (Item armorItem : ArmorSetRegistry.ARMOR_SET.get(SetSetSet.ID("grim_armor")).getArmorValues())
            livingEntity.dropItem(armorItem);
    }

    @Unique
    HashMap<ArmorSet, Integer> armorSetContributionMap = new HashMap<>();

    @Override
    public HashMap<ArmorSet, Integer> getArmorSetContribution() {
        return this.armorSetContributionMap;
    }

    @Override
    public void setArmorSetContribution(Iterable<ItemStack> armorItems) {
        this.armorSetContributionMap.forEach((armorSet, integer) -> this.armorSetContributionMap.remove(armorSet));
        armorItems.forEach(itemStack -> {
            ArmorSet set = SetSetsOfNonSets.getArmorSet((ArmorItem) itemStack.getItem());
            this.armorSetContributionMap.put(set, this.armorSetContributionMap.getOrDefault(set, 0) + 1);
        });
    }
}
