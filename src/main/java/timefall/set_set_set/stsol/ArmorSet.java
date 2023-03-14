package timefall.set_set_set.stsol;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import timefall.set_set_set.util.SetSetsOfNonSets;

import java.util.Collection;
import java.util.EnumMap;

public class ArmorSet extends EquipmentSet {
    private final ArmorMaterial armorMaterial;
    protected final EnumMap<EquipmentSlot, ArmorItem> armor = new EnumMap<>(EquipmentSlot.class);

    private EquipmentSlot[] slots;

    private final ItemGroup group;

    public ArmorSet(Identifier identifier, ArmorMaterial armorMaterial, EquipmentSlot... slots) {
        this(identifier, armorMaterial, ItemGroups.COMBAT, slots);
    }

    public ArmorSet(Identifier identifier, ArmorMaterial armorMaterial, ItemGroup group, EquipmentSlot... slots) {
        super(identifier);
        this.armorMaterial = armorMaterial;
        this.group = group;
        this.slots = slots;
    }

    public ArmorSet withArmor() {
        return this.withArmor(EquipSlots.FULL.getSlots());
    }

    public ArmorSet withArmor(EquipmentSlot... slots) {
        this.slots = slots;
        this.createArmor(this.group);
        return this;
    }

    public void createArmor(ItemGroup group) {
        registerArmorItemValues();
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
            for (Item item : getArmorValues())
                entries.add(item);
        });
    }

    public void registerArmorItemValues() {
        for (EquipmentSlot slot : this.slots) {
            ArmorItem armorItem = registerArmorItem(new Identifier(this.getNamespace(), this.getName() + "_" + EquipmentSet.getSlotName(slot)),
                    new ArmorItem(this.armorMaterial, slot, new Item.Settings()));
            armor.put(slot, armorItem);
            SetSetsOfNonSets.setArmorSet(armorItem, this);
        }
    }


    public ArmorSet withArmor(Item... items) {
        for (Item item : items)
            if (item instanceof ArmorItem armorItem) {
                armor.put(armorItem.getSlotType(), armorItem);
                SetSetsOfNonSets.setArmorSet(armorItem, this);
            }
        return this;
    }

    public ArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    public Collection<ArmorItem> getArmorValues() {
        return armor.values();
    }

    public Collection<EquipmentSlot> getArmorSlots() {
        return armor.keySet();
    }

    public ArmorItem getHelmet() {
        return armor.get(EquipmentSlot.HEAD);
    }

    public ArmorItem getChestplate() {
        return armor.get(EquipmentSlot.CHEST);
    }

    public ArmorItem getLeggings() {
        return armor.get(EquipmentSlot.LEGS);
    }

    public ArmorItem getBoots() {
        return armor.get(EquipmentSlot.FEET);
    }

    private String getNamespace() {
        return this.getIdentifier().getNamespace();
    }

    private String getName() {
        return this.getIdentifier().getPath();
    }

    private static ArmorItem registerArmorItem(Identifier id, ArmorItem item) {
        return Registry.register(Registries.ITEM, id, item);
    }
}
