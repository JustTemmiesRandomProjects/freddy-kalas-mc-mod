package mom.beaver.freddy_kalas;

import mom.beaver.freddy_kalas.registry.subRegisters.RegisterOnServerTick;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class FreddyKalasServer implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        RegisterOnServerTick.register();
    }
}
