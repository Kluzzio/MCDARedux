package timefall.set_set_set.registry;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import timefall.set_set_set.SetSetSet;
import timefall.set_set_set.stsol.ArmorSet;

public class ArmorSetRegistry {

    public static final RegistryKey<Registry<ArmorSet>> ARMOR_SET_KEY = RegistryKey.ofRegistry(new Identifier("armor_set"));

    public static final DefaultedRegistry<ArmorSet> ARMOR_SET = FabricRegistryBuilder.createDefaulted(ARMOR_SET_KEY, SetSetSet.ID("default_armor_set")).buildAndRegister();
}
