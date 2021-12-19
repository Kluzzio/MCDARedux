package chronosacaria.mcda.mixin;

import chronosacaria.mcda.api.McdaEnchantmentHelper;
import chronosacaria.mcda.enchants.EnchantID;
import chronosacaria.mcda.registry.EnchantsRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Random;

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
            int bagOfSoulsLevel =
                    McdaEnchantmentHelper.getBagOfSoulsLevel(EnchantsRegistry.enchants.get(EnchantID.BAG_OF_SOULS),
                    playerEntity);
            int bagOfSoulsCount = 0;

            ItemStack helmetStack = playerEntity.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chestStack = playerEntity.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack legsStack = playerEntity.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack feetStack = playerEntity.getEquippedStack(EquipmentSlot.FEET);

            if (bagOfSoulsLevel > 0) {
                if (EnchantmentHelper.getLevel(EnchantsRegistry.enchants.get(BAG_OF_SOULS), helmetStack) > 0) {
                    bagOfSoulsCount ++;
                }
                if (EnchantmentHelper.getLevel(EnchantsRegistry.enchants.get(BAG_OF_SOULS), chestStack) > 0) {
                    bagOfSoulsCount ++;
                }
                if (EnchantmentHelper.getLevel(EnchantsRegistry.enchants.get(BAG_OF_SOULS), legsStack) > 0) {
                    bagOfSoulsCount ++;
                }
                if (EnchantmentHelper.getLevel(EnchantsRegistry.enchants.get(BAG_OF_SOULS), feetStack) > 0) {
                    bagOfSoulsCount ++;
                }

                // Thank you, Amph
                this.amount = (this.amount * (1 + (bagOfSoulsLevel / 12)) + Math.round(((bagOfSoulsLevel % 12)/12.0f) * this.amount)) * bagOfSoulsCount;
                this.remove(RemovalReason.KILLED);
            }
        }
    }
}
