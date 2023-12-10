package mom.beaver.freddy_kalas;

import mom.beaver.freddy_kalas.registry.subRegisters.RegisterOnClientTick;
import mom.beaver.freddy_kalas.registry.subRegisters.RegisterOnWorldJoin;
import mom.beaver.freddy_kalas.registry.subRegisters.RegisterOnWorldLeave;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FreddyKalasClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RegisterOnClientTick.register();
        RegisterOnWorldJoin.register();
        RegisterOnWorldLeave.register();
    }
}
