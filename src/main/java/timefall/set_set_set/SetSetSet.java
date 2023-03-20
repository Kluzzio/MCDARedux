package timefall.set_set_set;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timefall.set_set_set.stsol.Sets;
import timefall.set_set_set.util.SetContribution;


public class SetSetSet implements ModInitializer {
    public static final String MOD_ID = "set_set_set";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier ID(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        Sets.init();

        ServerEntityEvents.EQUIPMENT_CHANGE.register((livingEntity, equipmentSlot, previousStack, currentStack) ->
                SetContribution.setArmorSetContribution(livingEntity));

    }
}