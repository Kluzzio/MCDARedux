package timefall.set_set_set.stsol;

import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import timefall.set_set_set.SetSetSet;
import timefall.set_set_set.registry.ArmorSetRegistry;
import timefall.set_set_set.util.SetSetsOfNonSets;

public class Sets {

    @SuppressWarnings("unused")
    public static final ArmorSet DEFAULT_ARMOR_SET = registerWithoutArmor(SetSetSet.ID("default_armor_set"), ArmorMaterials.TURTLE);
    public static final ArmorSet GRIM_ARMOR = registerWithArmor(SetSetSet.ID("grim_armor"), ItemGroups.FOOD_AND_DRINK, ArmorSetMaterials.GRIM_ARMOR);
    public static final ArmorSet LEATHER_ARMOR = register(new ArmorSet(new Identifier("leather"), ArmorMaterials.LEATHER).withArmor(Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS));
    public static final ArmorSet IRON_ARMOR = register(
            new ArmorSet(new Identifier("iron"), ArmorMaterials.IRON)
                    .withArmor(Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS)
                    .setEffectToolTips(1, "I've had")
                    .setEffectToolTips(2, "the time of my life")
                    .setEffectToolTips(4, "and I've never felt this way before")
    );

    public static final ArmorSet CHAIN_ARMOR = register(new ArmorSet(new Identifier("chainmail"), ArmorMaterials.CHAIN).withArmor(Items.CHAINMAIL_HELMET, Items.CHAINMAIL_CHESTPLATE, Items.CHAINMAIL_LEGGINGS, Items.CHAINMAIL_BOOTS));
    public static final ArmorSet GOLD_ARMOR = register(new ArmorSet(new Identifier("gold"), ArmorMaterials.GOLD).withArmor(Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS));
    public static final ArmorSet DIAMOND_ARMOR = register(new ArmorSet(new Identifier("diamond"), ArmorMaterials.DIAMOND).withArmor(Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS));
    public static final ArmorSet TURTLE_ARMOR = register(new ArmorSet(new Identifier("turtle"), ArmorMaterials.TURTLE).withArmor(Items.TURTLE_HELMET));
    public static final ArmorSet NETHERITE_ARMOR = register(new ArmorSet(new Identifier("netherite"), ArmorMaterials.NETHERITE).withArmor(Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS));

    public static void init() {
        System.out.println(ArmorSetRegistry.ARMOR_SET.get(new Identifier(((ArmorItem) Items.CHAINMAIL_BOOTS).getMaterial().getName())) == CHAIN_ARMOR);

        ArmorSet set =
                SetSetsOfNonSets.getArmorSet(
                        SetSetsOfNonSets.getArmorSet(
                                SetSetsOfNonSets.getArmorSet(
                                        SetSetsOfNonSets.getArmorSet(
                                                GRIM_ARMOR.getHelmet()
                                        ).getChestplate()
                                ).getLeggings()
                        ).getBoots()
                );



        System.out.println(set == CHAIN_ARMOR);

        System.out.println(set.getIdentifier());

        ArmorSetRegistry.ARMOR_SET.get(SetSetSet.ID("grim_armor")).getArmorValues();

        // {{S},{E},{T}}
    }

    public static ArmorSet register(ArmorSet set) {
        return Registry.register(ArmorSetRegistry.ARMOR_SET, set.getIdentifier(), set);
    }

    public static ArmorSet registerWithoutArmor(Identifier id, ArmorMaterial armorMaterial) {
        return register(new ArmorSet(id, armorMaterial));
    }

    public static ArmorSet registerWithArmor(Identifier id, ArmorMaterial armorMaterial) {
        return register(new ArmorSet(id, armorMaterial).withArmor());
    }

    public static ArmorSet registerWithArmor(Identifier id, ItemGroup itemGroup, ArmorMaterial armorMaterial) {
        return register(new ArmorSet(id, armorMaterial, itemGroup).withArmor());
    }

    /* What do we need? */
    /* Implement config with this structure
    *   Create a way to get the set from items. If the item doesn't have a set, get its material instead
    */
}