package mom.beaver.freddy_kalas.registry.subRegisters;

import mom.beaver.freddy_kalas.FreddyKalas;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class RegisterOnWorldJoin {
    public static void register() {
        ClientPlayConnectionEvents.JOIN.register((handler, packetSender, client) -> {
            FreddyKalas.LOGGER.info("Connecting from server...");
        });
    }
}
