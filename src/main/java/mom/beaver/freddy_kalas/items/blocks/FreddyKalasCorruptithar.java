package mom.beaver.freddy_kalas.items.blocks;

import mom.beaver.freddy_kalas.items.blocks.blockEntities.FreddyKalasCorruptitharEntity;
import mom.beaver.freddy_kalas.registry.RegisterItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FreddyKalasCorruptithar extends BlockWithEntity {
    public FreddyKalasCorruptithar(Settings settings) {
        super (settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FreddyKalasCorruptitharEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState blockState, BlockEntityType<T> type) {
        return checkType(type, RegisterItems.FREDDY_KALAS_CORRUPTITHAR_ENTITY, (world1, pos, state1, be) -> FreddyKalasCorruptitharEntity.tick(world1, pos, state1, be));
    }
}
