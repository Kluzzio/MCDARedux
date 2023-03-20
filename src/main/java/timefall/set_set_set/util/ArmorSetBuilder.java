package timefall.set_set_set.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import timefall.set_set_set.SetSetSet;
import timefall.set_set_set.stsol.ArmorSet;

import java.util.Arrays;
import java.util.LinkedList;

public class ArmorSetBuilder {
    // List of sets
    private final LinkedList<ArmorSet> armorSets = new LinkedList<>();

    // Way to add sets
    public ArmorSetBuilder addArmorSets(ArmorSet... armorSet) {
        armorSets.addAll(Arrays.stream(armorSet).toList());
        return this;
    }

    // Build
    public ItemGroup build(Identifier identifier, Text displayName) {
        for (ArmorSet armorSet : armorSets) {
            armorSet.registerArmorItemValues();
        }
        if (armorSets.isEmpty()) {
            SetSetSet.LOGGER.error("You fucked up!");
            throw new IllegalArgumentException("You need to pass in a valid ArmorSet");
        }
        return FabricItemGroup.builder(identifier).displayName(displayName)
                .icon(() -> new ItemStack(armorSets.get(0).getArmorValues().stream().toList().get(0)))
                .entries((enabledFeatures, entries, operatorEnabled) -> {
                        for (ArmorSet armorSet: armorSets)
                            for (Item armorItem : armorSet.getArmorValues())
                                entries.add(armorItem);
                        }).build();
    }
}
