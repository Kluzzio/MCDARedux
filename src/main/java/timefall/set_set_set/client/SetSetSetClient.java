package timefall.set_set_set.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import timefall.set_set_set.util.SetContribution;

@Environment(EnvType.CLIENT)
public class SetSetSetClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(EquipChangePacket.EQUIP_PACKET, ((client, handler, buf, responseSender) ->
                client.execute(() -> {
                    if (client.player != null)
                        SetContribution.setArmorSetContribution(client.player);
                })
        ));
    }
}
