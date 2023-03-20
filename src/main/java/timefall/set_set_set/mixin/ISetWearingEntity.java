package timefall.set_set_set.mixin;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import timefall.set_set_set.stsol.ArmorSet;

import java.util.HashMap;
import java.util.List;

public interface ISetWearingEntity {

    HashMap<ArmorSet, Integer> getArmorSetContribution();

    void setArmorSetContribution(Iterable<ItemStack> armorItems);

    HashMap<ArmorSet, Integer> getArmorSetTrinketContribution();

    void setArmorSetContribution(List<Pair<SlotReference, ItemStack>> trinketPairs);
}
