package mom.beaver.freddy_kalas.items;

import mom.beaver.freddy_kalas.registry.RegisterSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EvilFreddyKalasItem extends Item {

    public EvilFreddyKalasItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        world.playSound(null, BlockPos.ofFloored(playerEntity.getPos()), RegisterSounds.EVIL_FREDDY_KALAS_QUOTE_EVENT, SoundCategory.PLAYERS, 0.7F, 0.6F);

        playerEntity.getItemCooldownManager().set(this, 80);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
