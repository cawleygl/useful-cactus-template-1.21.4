package bluesteel42.usefulcactus.datagen;

import bluesteel42.usefulcactus.block.ModBlocks;
import bluesteel42.usefulcactus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.CHOLLA_BLOCKS)
                .add(ModBlocks.CHOLLA_BLOCK)
                .add(ModBlocks.STRIPPED_CHOLLA_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).addTag(ModTags.Blocks.CHOLLA_BLOCKS);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.DRIED_CHOLLA);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.CHOLLA_MOSAIC);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.CHOLLA_MOSAIC_STAIRS);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.CHOLLA_MOSAIC_SLAB);

        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.CHOLLA_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.CHOLLA_STAIRS);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.CHOLLA_MOSAIC_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.CHOLLA_SLAB);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.CHOLLA_MOSAIC_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.CHOLLA_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.CHOLLA_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.CHOLLA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CHOLLA_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.CHOLLA_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.CHOLLA_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(ModBlocks.CHOLLA_STANDING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(ModBlocks.CHOLLA_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.CHOLLA_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.CHOLLA_WALL_HANGING_SIGN);
    }
}
