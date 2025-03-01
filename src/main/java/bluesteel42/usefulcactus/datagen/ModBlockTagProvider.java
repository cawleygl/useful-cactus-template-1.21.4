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
        getOrCreateTagBuilder(ModTags.Blocks.CACTUS_LOGS)
                .add(ModBlocks.CACTUS_LOG)
                .add(ModBlocks.CACTUS_WOOD)
                .add(ModBlocks.STRIPPED_CACTUS_LOG)
                .add(ModBlocks.STRIPPED_CACTUS_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addOptionalTag(ModTags.Blocks.CACTUS_LOGS);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.CACTUS_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.CACTUS_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.CACTUS_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.CACTUS_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.CACTUS_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.CACTUS_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CACTUS_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.CACTUS_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.CACTUS_PRESSURE_PLATE);
    }
}
