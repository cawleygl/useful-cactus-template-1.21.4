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
                    .strength(2.0F, 3.0F)
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
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );

    public static final Block CACTUS_BUTTON = registerBlock(
            "cactus_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
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
                    .strength(0.5F)
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
                    .strength(2.0F, 3.0F)
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
                    .strength(2.0F, 3.0F)
                    .burnable()
    );

    public static final Block CACTUS_DOOR = registerNonOpaqueBlock(
            "cactus_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
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
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );

    public static final Identifier CACTUS_SIGN_TEXTURE = Identifier.of(UsefulCactus.MOD_ID, "entity/signs/cactus");
    public static final Identifier CACTUS_HANGING_SIGN_TEXTURE = Identifier.of(UsefulCactus.MOD_ID, "entity/signs/hanging/cactus");
    public static final Identifier CACTUS_HANGING_GUI_SIGN_TEXTURE = Identifier.of(UsefulCactus.MOD_ID, "textures/gui/hanging_signs/cactus");

    public static final Block CACTUS_STANDING_SIGN = registerBlockWithoutItem(
            "cactus_standing_sign",
            settings -> new TerraformSignBlock(CACTUS_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .mapColor(MapColor.PALE_GREEN)
    );

    public static final Block CACTUS_WALL_SIGN = registerBlockWithoutItem(
            "cactus_wall_sign",
            settings -> new TerraformWallSignBlock(CACTUS_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapColor.PALE_GREEN).lootTable(CACTUS_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(CACTUS_STANDING_SIGN.getTranslationKey())
    );

    public static final Block CACTUS_HANGING_SIGN = registerBlockWithoutItem(
            "cactus_hanging_sign",
            settings -> new TerraformHangingSignBlock(CACTUS_HANGING_SIGN_TEXTURE, CACTUS_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                    .mapColor(MapColor.PALE_GREEN)
    );

    public static final Block CACTUS_WALL_HANGING_SIGN = registerBlockWithoutItem(
            "cactus_hanging_wall_sign",
            settings -> new TerraformWallHangingSignBlock(CACTUS_HANGING_SIGN_TEXTURE, CACTUS_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.PALE_GREEN).lootTable(CACTUS_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(CACTUS_HANGING_SIGN.getTranslationKey())
    );

    public static final BlockFamily CACTUS_SIGN_FAMILY = BlockFamilies.register(ModBlocks.CACTUS_PLANKS)
            .sign(ModBlocks.CACTUS_STANDING_SIGN, ModBlocks.CACTUS_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily CACTUS_HANGING_SIGN_FAMILY = BlockFamilies.register(ModBlocks.STRIPPED_CACTUS_LOG)
            .sign(ModBlocks.CACTUS_HANGING_SIGN, ModBlocks.CACTUS_WALL_HANGING_SIGN)
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
