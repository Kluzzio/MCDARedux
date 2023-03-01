package timefall.set_set_set.stsol;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EquipmentSet {

    private final Identifier identifier;

    public EquipmentSet(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public static String getSlotName(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> "helmet";
            case CHEST -> "chestplate";
            case LEGS -> "leggings";
            case FEET -> "boots";
            case MAINHAND -> "mainhand";
            case OFFHAND -> "offhand";
        };
    }
}
