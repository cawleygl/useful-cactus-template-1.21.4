package bluesteel42.usefulcactus.block;

import bluesteel42.usefulcactus.UsefulCactus;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block CACTUS_WOOD = registerBlock("cactus_wood",
            PillarBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );

    public static final Block CACTUS_LOG = registerBlock("cactus_log",
            PillarBlock::new,
            Blocks.createLogSettings(MapColor.PALE_GREEN, MapColor.GREEN, BlockSoundGroup.WOOD)
    );

    public static final Block STRIPPED_CACTUS_WOOD = registerBlock("stripped_cactus_wood",
            PillarBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );

    public static final Block STRIPPED_CACTUS_LOG = registerBlock("stripped_cactus_log",
            PillarBlock::new,
            Blocks.createLogSettings(MapColor.PALE_GREEN, MapColor.PALE_GREEN, BlockSoundGroup.WOOD)
    );

    public static final Block CACTUS_PLANKS = registerBlock(
            "cactus_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );

    public static final Block CACTUS_STAIRS = registerBlock(
            "cactus_stairs",
            settings -> new StairsBlock(CACTUS_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(CACTUS_PLANKS)
    );

    public static final Block CACTUS_SLAB = registerBlock(
            "cactus_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(CACTUS_PLANKS)
    );

    public static final Block CACTUS_BUTTON = registerBlock(
            "cactus_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(2.0F)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CACTUS_PRESSURE_PLATE = registerBlock(
            "cactus_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(2.0F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CACTUS_FENCE = registerBlock(
            "cactus_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );

    public static final Block CACTUS_FENCE_GATE = registerBlock(
            "cactus_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .burnable()
    );

    public static final Block CACTUS_DOOR = registerNonOpaqueBlock(
            "cactus_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CACTUS_TRAPDOOR = registerNonOpaqueBlock(
            "cactus_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );

    private static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(UsefulCactus.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);

        return block;

    }

    private static Block registerNonOpaqueBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(UsefulCactus.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);

        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());

        Items.register(block);

        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.STRIPPED_CACTUS_WOOD);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.STRIPPED_CACTUS_LOG);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_WOOD);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CACTUS_LOG);
                });
    }
}
