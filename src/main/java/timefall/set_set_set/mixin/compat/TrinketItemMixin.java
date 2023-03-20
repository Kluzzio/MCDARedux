package timefall.set_set_set.mixin.compat;

import dev.emi.trinkets.api.TrinketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import timefall.set_set_set.stsol.ArmorSet;
import timefall.set_set_set.stsol.ITrinketWithSet;

@Mixin(TrinketItem.class)
public class TrinketItemMixin implements ITrinketWithSet {

    @Unique
    private ArmorSet set_set_set_trinket_set;

    @Override
    public void setSet_set_set_trinket_set(ArmorSet set_set_set_armor_set) {
        this.set_set_set_trinket_set = set_set_set_armor_set;
    }

    @Override
    public ArmorSet getSet_set_set_trinket_set() {
        return this.set_set_set_trinket_set;
    }

}
