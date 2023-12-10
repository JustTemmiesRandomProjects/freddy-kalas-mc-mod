package mom.beaver.freddy_kalas.registry.subRegisters;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;


public class RegisterOnServerTick {

    public static int jovial_corruptithar_counter = 0;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register((server) -> {
            if (server != null) {
                // increase the global corruptithar counter
                jovial_corruptithar_counter ++;
            }
        });
    }
}
