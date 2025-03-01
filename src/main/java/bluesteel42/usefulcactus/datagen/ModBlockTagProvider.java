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
    }
}
