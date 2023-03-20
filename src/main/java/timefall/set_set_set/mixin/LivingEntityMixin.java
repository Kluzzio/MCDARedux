package timefall.set_set_set.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import timefall.set_set_set.client.EquipChangePacket;
import timefall.set_set_set.stsol.ArmorSet;
import timefall.set_set_set.stsol.EquipmentSet;
import timefall.set_set_set.stsol.ISetWearingEntity;
import timefall.set_set_set.util.SetSetsOfNonSets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements ISetWearingEntity {
    @Unique
    HashMap<ArmorSet, Integer> armorSetContributionMap = new HashMap<>();

    @Unique
    HashMap<ArmorSet, Integer> armorSetTrinketContributionMap = new HashMap<>();

    @Override
    public HashMap<ArmorSet, Integer> getArmorSetContribution() {
        return this.armorSetContributionMap;
    }

    @Override
    public void setArmorSetContribution(Iterable<ItemStack> armorItems) {
        this.armorSetContributionMap.clear();
        armorItems.forEach(itemStack -> {
            if (itemStack.getItem() instanceof ArmorItem armorPiece) {
                ArmorSet set = SetSetsOfNonSets.getArmorSet(armorPiece);
                this.armorSetContributionMap.put(set, this.armorSetContributionMap.getOrDefault(set, 0) + 1);
            }
        });
        //noinspection ConstantConditions
        if ((Object) this instanceof ServerPlayerEntity serverPlayer) {
            ServerPlayNetworking.send(serverPlayer, EquipChangePacket.EQUIP_PACKET, PacketByteBufs.empty());
        }
    }

    @Override
    public HashMap<ArmorSet, Integer> getArmorSetTrinketContribution() {
        return this.armorSetTrinketContributionMap;
    }

    @Override
    public void setArmorSetContribution(List<Pair<SlotReference, ItemStack>> trinketPairs) {
        this.armorSetTrinketContributionMap.clear();
        trinketPairs.forEach(slotReferenceItemStackPair -> {
            ItemStack stack = slotReferenceItemStackPair.getRight();
            if (stack.getItem() instanceof TrinketItem trinketItem) {
                ArmorSet set = SetSetsOfNonSets.getArmorSet(trinketItem);
                this.armorSetTrinketContributionMap.put(set, this.armorSetTrinketContributionMap.getOrDefault(set, 0) + 1);
            }
        });
    }
}
