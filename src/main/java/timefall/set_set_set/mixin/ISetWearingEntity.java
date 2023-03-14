package timefall.set_set_set.mixin;

import net.minecraft.item.ItemStack;
import timefall.set_set_set.stsol.ArmorSet;

import java.util.HashMap;

public interface ISetWearingEntity {

    HashMap<ArmorSet, Integer> getArmorSetContribution();

    void setArmorSetContribution(Iterable<ItemStack> armorItems);
}
