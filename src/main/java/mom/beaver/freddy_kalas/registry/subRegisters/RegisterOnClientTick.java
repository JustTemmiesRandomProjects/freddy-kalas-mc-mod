package mom.beaver.freddy_kalas.registry.subRegisters;

import mom.beaver.freddy_kalas.FreddyKalas;
import mom.beaver.freddy_kalas.registry.RegisterSounds;
import mom.beaver.freddy_kalas.registry.RegisterStatusEffects;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;

import java.util.UUID;


public class RegisterOnClientTick {

    public static void register() {
        ClientTickEvents.START_CLIENT_TICK.register((client) -> {
            UUID uuid = client.getSession().getUuidOrNull();
            if (uuid != null && client.world != null) {
                PlayerEntity player = client.world.getPlayerByUuid(uuid);
                if ( player == null ) {
                    return;
                }

                StatusEffectInstance effectInstance = player.getStatusEffect(RegisterStatusEffects.JOVIAL);

                if (effectInstance == null) {
                    MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                    FreddyKalas.JOVIAL_TICKS_PLAYED = -1;
                }
            }
        });
    }
}
