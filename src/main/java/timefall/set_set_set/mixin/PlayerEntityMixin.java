package timefall.set_set_set.mixin;

import timefall.set_set_set.stsol.Sets;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Collection;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void tickArmorEffect(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        // Testing stuffs

        Collection<Item> armorItems = new ArrayList<>();
        player.getArmorItems().forEach(itemStack -> armorItems.add(itemStack.getItem()));
        Collection<Item> setItems = new ArrayList<>(Sets.GRIM_ARMOR.getArmorValues());
        if (armorItems.equals(setItems)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100));
        }
    }
}
