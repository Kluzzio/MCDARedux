package timefall.set_set_set.stsol;

import net.minecraft.entity.EquipmentSlot;

public enum EquipSlots {
    FULL(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET),
    NO_HEAD(EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET),
    NO_CHEST(EquipmentSlot.HEAD, EquipmentSlot.LEGS, EquipmentSlot.FEET),
    NO_LEGS(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.FEET),
    NO_FEET(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS);

    private final EquipmentSlot[] slots;

    EquipSlots(EquipmentSlot... slots) {
        this.slots = slots;
    }

    public EquipmentSlot[] getSlots() {
        return this.slots;
    }
}
