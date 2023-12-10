package mom.beaver.freddy_kalas.registry;

import mom.beaver.freddy_kalas.FreddyKalas;
import mom.beaver.freddy_kalas.items.EvilFreddyKalasItem;
import mom.beaver.freddy_kalas.items.FreddyKalasItem;
import mom.beaver.freddy_kalas.items.blocks.FreddyKalasCorruptithar;
import mom.beaver.freddy_kalas.items.blocks.blockEntities.FreddyKalasCorruptitharEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class RegisterItems {

    public static final Item FREDDY_KALAS_ITEM = new FreddyKalasItem(new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item EVIL_FREDDY_KALAS_ITEM = new EvilFreddyKalasItem(new FabricItemSettings().rarity(Rarity.EPIC).fireproof());

    public static final FreddyKalasCorruptithar FREDDY_KALAS_CORRUPTITHAR = new FreddyKalasCorruptithar(FabricBlockSettings.create().strength(3.5f));

    public static final BlockEntityType<FreddyKalasCorruptitharEntity> FREDDY_KALAS_CORRUPTITHAR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(FreddyKalas.MOD_ID, "freddy_kalas_corruptithar_entity"),
            FabricBlockEntityTypeBuilder.create(FreddyKalasCorruptitharEntity::new, FREDDY_KALAS_CORRUPTITHAR).build()
    );

    public static Map<String, Item> block_items = new HashMap<>();

    public static void register() {
        Item[] freddy_group_entries = {
                registerItem("freddy_kalas_item", FREDDY_KALAS_ITEM),
                registerItem("evil_freddy_kalas_item", EVIL_FREDDY_KALAS_ITEM),
                registerItemAndBlock("freddy_kalas_corruptithar", FREDDY_KALAS_CORRUPTITHAR, new FabricItemSettings().rarity(Rarity.EPIC))
        };

        Registry.register(Registries.ITEM_GROUP, new Identifier(FreddyKalas.MOD_ID, "freddy_group"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(FREDDY_KALAS_CORRUPTITHAR))
                        .displayName(Text.translatable("Freddy Kalas"))
                        .entries((context, entries) -> {
                            for (Item item : freddy_group_entries) {
                                entries.add(item);
                            }
                        }).build()
        );
    }

    private static Item registerItem(String ID, Item item) {
        Registry.register(Registries.ITEM, new Identifier(FreddyKalas.MOD_ID, ID), item);
        return item;
    }

    private static Block registerBlock(String ID, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(FreddyKalas.MOD_ID, ID), block);
        return block;
    }

    private static Item registerItemAndBlock(String ID, Block block, FabricItemSettings itemSettings) {
        Item item = new BlockItem(block, itemSettings);
        block_items.put(ID, item);
        Registry.register(Registries.BLOCK, new Identifier(FreddyKalas.MOD_ID, ID), block);
        Registry.register(Registries.ITEM, new Identifier(FreddyKalas.MOD_ID, ID), item);
        return item;
    }
}