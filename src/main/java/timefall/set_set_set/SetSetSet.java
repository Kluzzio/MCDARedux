package timefall.set_set_set;

import timefall.set_set_set.stsol.Sets;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SetSetSet implements ModInitializer {
    public static final String MOD_ID = "set_set_set";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier ID(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        Sets.init();

        //OnEquipCallback.EVENT.register
    }
}