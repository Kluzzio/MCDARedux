package timefall.set_set_set.stsol;

import net.minecraft.item.ItemStack;

import java.util.HashMap;

public interface ISetWearingEntity {

    HashMap<ArmorSet, Integer> getArmorSetContribution();

    void setArmorSetContribution(Iterable<ItemStack> armorItems);
}
