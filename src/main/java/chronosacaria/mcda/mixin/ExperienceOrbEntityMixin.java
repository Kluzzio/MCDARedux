package chronosacaria.mcda.mixin;

import chronosacaria.mcda.enchants.EnchantID;
import chronosacaria.mcda.registry.EnchantsRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static chronosacaria.mcda.config.McdaConfig.config;
import static chronosacaria.mcda.enchants.EnchantID.*;

@Mixin(ExperienceOrbEntity.class)
public abstract class ExperienceOrbEntityMixin extends Entity {

    @Shadow private int amount;

    public ExperienceOrbEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onPlayerCollision", at = @At("HEAD"))
    public void applyBagOfSouls(PlayerEntity playerEntity, CallbackInfo ci){
        if (!config.enableEnchantment.get(BAG_OF_SOULS))
            return;

        if (!world.isClient){
            int bagOfSoulsLevel = EnchantmentHelper.getEquipmentLevel(EnchantsRegistry.enchants.get(EnchantID.BAG_OF_SOULS), playerEntity);

            if (bagOfSoulsLevel > 0) {
                this.amount = this.amount * (1 + (bagOfSoulsLevel / 3));
                this.remove();
            }
        }
    }
}
