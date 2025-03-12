package bluesteel42.usefulcactus.block;

import bluesteel42.usefulcactus.UsefulCactus;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block DRIED_CHOLLA = registerBlock(
            "dried_cholla",
            DriedChollaBlock::new,
            Blocks.createLogSettings(MapColor.DARK_GREEN, MapColor.STONE_GRAY, BlockSoundGroup.BAMBOO_WOOD)
    );

    public static final Block CHOLLA_BLOCK = registerBlock(
            "cholla_block",
            PillarBlock::new,
            Blocks.createLogSettings(MapColor.DARK_GREEN, MapColor.STONE_GRAY, BlockSoundGroup.BAMBOO_WOOD)
    );

    public static final Block STRIPPED_CHOLLA_BLOCK = registerBlock(
            "stripped_cholla_block",
            PillarBlock::new,
            Blocks.createLogSettings(MapColor.DARK_GREEN, MapColor.DARK_GREEN, BlockSoundGroup.BAMBOO_WOOD)
    );

    public static final Block CHOLLA_PLANKS = registerBlock(
            "cholla_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable()
    );

    public static final Block CHOLLA_MOSAIC = registerBlock(
            "cholla_mosaic",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable()
    );

    public static final Block CHOLLA_STAIRS = registerBlock(
            "cholla_stairs",
            settings -> new StairsBlock(CHOLLA_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(CHOLLA_PLANKS)
    );

    public static final Block CHOLLA_MOSAIC_STAIRS = registerBlock(
            "cholla_mosaic_stairs",
            settings -> new StairsBlock(CHOLLA_MOSAIC.getDefaultState(), settings),
            AbstractBlock.Settings.copy(CHOLLA_MOSAIC)
    );

    public static final Block CHOLLA_SLAB = registerBlock(
            "cholla_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable()
    );

    public static final Block CHOLLA_MOSAIC_SLAB = registerBlock(
            "cholla_mosaic_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable()
    );

    public static final Block CHOLLA_BUTTON = registerBlock(
            "cholla_button",
            settings -> new ButtonBlock(BlockSetType.BAMBOO, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CHOLLA_PRESSURE_PLATE = registerBlock(
            "cholla_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CHOLLA_FENCE = registerBlock(
            "cholla_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable()
    );

    public static final Block CHOLLA_FENCE_GATE = registerBlock(
            "cholla_fence_gate",
            settings -> new FenceGateBlock(WoodType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()
    );

    public static final Block CHOLLA_DOOR = registerNonOpaqueBlock(
            "cholla_door",
            settings -> new DoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block CHOLLA_TRAPDOOR = registerNonOpaqueBlock(
            "cholla_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );

    public static final Identifier CHOLLA_SIGN_TEXTURE = Identifier.of(UsefulCactus.MOD_ID, "entity/signs/cholla");
    public static final Identifier CHOLLA_HANGING_SIGN_TEXTURE = Identifier.of(UsefulCactus.MOD_ID, "entity/signs/hanging/cholla");
    public static final Identifier CHOLLA_HANGING_GUI_SIGN_TEXTURE = Identifier.of(UsefulCactus.MOD_ID, "textures/gui/hanging_signs/cholla");

    public static final Block CHOLLA_STANDING_SIGN = registerBlockWithoutItem(
            "cholla_standing_sign",
            settings -> new TerraformSignBlock(CHOLLA_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN)
                    .mapColor(MapColor.DARK_GREEN)
    );

    public static final Block CHOLLA_WALL_SIGN = registerBlockWithoutItem(
            "cholla_wall_sign",
            settings -> new TerraformWallSignBlock(CHOLLA_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(MapColor.DARK_GREEN).lootTable(CHOLLA_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(CHOLLA_STANDING_SIGN.getTranslationKey())
    );

    public static final Block CHOLLA_HANGING_SIGN = registerBlockWithoutItem(
            "cholla_hanging_sign",
            settings -> new TerraformHangingSignBlock(CHOLLA_HANGING_SIGN_TEXTURE, CHOLLA_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN)
                    .mapColor(MapColor.DARK_GREEN)
    );

    public static final Block CHOLLA_WALL_HANGING_SIGN = registerBlockWithoutItem(
            "cholla_hanging_wall_sign",
            settings -> new TerraformWallHangingSignBlock(CHOLLA_HANGING_SIGN_TEXTURE, CHOLLA_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(MapColor.DARK_GREEN).lootTable(CHOLLA_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(CHOLLA_HANGING_SIGN.getTranslationKey())
    );

    public static final BlockFamily CHOLLA_SIGN_FAMILY = BlockFamilies.register(ModBlocks.CHOLLA_PLANKS)
            .sign(ModBlocks.CHOLLA_STANDING_SIGN, ModBlocks.CHOLLA_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily CHOLLA_HANGING_SIGN_FAMILY = BlockFamilies.register(ModBlocks.STRIPPED_CHOLLA_BLOCK)
            .sign(ModBlocks.CHOLLA_HANGING_SIGN, ModBlocks.CHOLLA_WALL_HANGING_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

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

    private static Block registerBlockWithoutItem(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(UsefulCactus.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        return Blocks.register(registryKey, factory, settings);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_MOSAIC_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_MOSAIC_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_MOSAIC);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.STRIPPED_CHOLLA_BLOCK);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ModBlocks.CHOLLA_BLOCK);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.CACTUS, ModBlocks.DRIED_CHOLLA);
                });

    }
}
