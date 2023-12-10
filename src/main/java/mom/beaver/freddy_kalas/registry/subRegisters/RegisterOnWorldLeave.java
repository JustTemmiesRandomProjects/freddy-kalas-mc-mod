package mom.beaver.freddy_kalas.registry.subRegisters;

import mom.beaver.freddy_kalas.FreddyKalas;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class RegisterOnWorldLeave {
    public static void register() {
        // reset the jovial ticks played counter to 0 whenever leaving a server
        ClientPlayConnectionEvents.DISCONNECT.register(((handler, client) -> {
            FreddyKalas.LOGGER.info("Disconnecting from server...");
            client.execute(() -> {
                FreddyKalas.JOVIAL_TICKS_PLAYED = 0;
            });
        }));
    }
}
