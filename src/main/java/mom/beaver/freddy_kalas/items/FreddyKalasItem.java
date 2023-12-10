package mom.beaver.freddy_kalas.items;

import mom.beaver.freddy_kalas.registry.RegisterSounds;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;

public class FreddyKalasItem extends Item {

    public FreddyKalasItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        world.playSound(null, BlockPos.ofFloored(playerEntity.getPos()), RegisterSounds.FREDDY_KALAS_QUOTE_EVENT, SoundCategory.PLAYERS, 0.7F, 1.0F);

        playerEntity.getItemCooldownManager().set(this, 20);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
