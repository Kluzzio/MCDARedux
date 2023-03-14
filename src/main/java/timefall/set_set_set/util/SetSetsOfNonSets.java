package timefall.set_set_set.util;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import timefall.set_set_set.mixin.IArmorWithSet;
import timefall.set_set_set.stsol.ArmorSet;

public class SetSetsOfNonSets {

    /**
     * <p>For use internally to set the Armor Set of an Armor Item immediately after its creation.<br/>
     * See {@link ArmorSet#registerArmorItemValues()} or {@link ArmorSet#withArmor(Item...)} for usage.</p>
     *
     * <p>It is not good practice to overwrite the given set of an item. Items can <em>only</em> be a part of a single set.</p>
     *
     * @param armorItem Armor item that has a set (usually a helmet, chestplate, leggings, or boots)
     * @param set The armor set that the armor item belongs to
     */
    public static void setArmorSet(ArmorItem armorItem, ArmorSet set) {
        ((IArmorWithSet) armorItem).setSet_set_set_armor_set(set);
    }

    public static ArmorSet getArmorSet(ArmorItem armorItem) {
        return ((IArmorWithSet) armorItem).getSet_set_set_armor_set();
    }
}
