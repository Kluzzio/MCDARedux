package timefall.set_set_set.stsol;

import net.minecraft.entity.LivingEntity;

import java.util.HashMap;

public class SetContribution {

    public static HashMap<ArmorSet, Integer> getArmorSetContribution(LivingEntity entity) {
        return ((ISetWearingEntity) entity).getArmorSetContribution();
    }

    public static void setArmorSetContribution(LivingEntity entity) {
        ((ISetWearingEntity) entity).setArmorSetContribution(entity.getArmorItems());
    }
}