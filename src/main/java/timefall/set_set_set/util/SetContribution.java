package timefall.set_set_set.util;

import net.minecraft.entity.LivingEntity;
import timefall.set_set_set.mixin.ISetWearingEntity;
import timefall.set_set_set.stsol.ArmorSet;

import java.util.HashMap;

public class SetContribution {

    public static HashMap<ArmorSet, Integer> getArmorSetContribution(LivingEntity entity) {
        return ((ISetWearingEntity) entity).getArmorSetContribution();
    }

    public static void setArmorSetContribution(LivingEntity entity) {
        ((ISetWearingEntity) entity).setArmorSetContribution(entity.getArmorItems());
    }
}