package timefall.set_set_set.mixin;

import timefall.set_set_set.stsol.ArmorSet;
import net.minecraft.item.ArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ArmorItem.class)
public class ArmorItemMixin implements IArmorWithSet {

    @Unique
    private ArmorSet set_set_set_armor_set;

    @Override
    public void setSet_set_set_armor_set(ArmorSet set_set_set_armor_set) {
        this.set_set_set_armor_set = set_set_set_armor_set;
    }

    @Override
    public ArmorSet getSet_set_set_armor_set() {
        return this.set_set_set_armor_set;
    }
}
