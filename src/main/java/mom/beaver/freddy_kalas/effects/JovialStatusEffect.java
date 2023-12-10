package mom.beaver.freddy_kalas.effects;

import mom.beaver.freddy_kalas.FreddyKalas;
import mom.beaver.freddy_kalas.registry.RegisterSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;


public class JovialStatusEffect extends StatusEffect {
    public JovialStatusEffect() {
        super(
                StatusEffectCategory.BENEFICIAL,
                0xf8bb44
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if (amplifier != FreddyKalas.SAVED_AMPLIFIER || FreddyKalas.JOVIAL_TICKS_PLAYED > 3580 || FreddyKalas.JOVIAL_TICKS_PLAYED <= 0) {
                MinecraftClient.getInstance().getSoundManager().stopSounds(RegisterSounds.JOVIAL_SONG_ID, SoundCategory.MASTER);
                playJovial((PlayerEntity) entity, amplifier);
                FreddyKalas.JOVIAL_TICKS_PLAYED = 2;
                FreddyKalas.SAVED_AMPLIFIER = amplifier;
            }
            FreddyKalas.JOVIAL_TICKS_PLAYED++;
        }
    }

    private static void playJovial(PlayerEntity entity, int amplifier) {
        if ( amplifier == -128) {
            (entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.38F, 0.75f);
        } else if ( amplifier == -127 ) {
            (entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.34F, 0.88f);
        } else {
            (entity).playSound(RegisterSounds.JOVIAL_SONG_EVENT, SoundCategory.MASTER, 0.3F, (float) (amplifier  * 0.2f) + 1);
        }
    }
}
