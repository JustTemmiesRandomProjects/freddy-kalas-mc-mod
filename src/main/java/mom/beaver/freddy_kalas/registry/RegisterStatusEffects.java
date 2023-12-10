package mom.beaver.freddy_kalas.registry;

import mom.beaver.freddy_kalas.FreddyKalas;
import mom.beaver.freddy_kalas.effects.JovialStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterStatusEffects {
    public static final StatusEffect JOVIAL = new JovialStatusEffect();

    public static void register() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(FreddyKalas.MOD_ID, "jovial"), JOVIAL);
    }
}
