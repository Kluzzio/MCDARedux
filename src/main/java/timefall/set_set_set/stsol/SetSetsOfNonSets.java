package timefall.set_set_set.stsol;

import net.minecraft.item.ArmorItem;

public class SetSetsOfNonSets {

    public static void setArmorSet(ArmorItem armorItem, ArmorSet set) {
        ((IArmorWithSet) armorItem).setSet_set_set_armor_set(set);
    }

    public static ArmorSet getArmorSet(ArmorItem armorItem) {
        return ((IArmorWithSet) armorItem).getSet_set_set_armor_set();
    }
}
