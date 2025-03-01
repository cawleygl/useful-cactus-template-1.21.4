package bluesteel42.usefulcactus.datagen;

import bluesteel42.usefulcactus.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CACTUS_LOG);
        addDrop(ModBlocks.CACTUS_WOOD);
        addDrop(ModBlocks.STRIPPED_CACTUS_LOG);
        addDrop(ModBlocks.STRIPPED_CACTUS_WOOD);

        addDrop(ModBlocks.CACTUS_PLANKS);
        addDrop(ModBlocks.CACTUS_STAIRS);
        addDrop(ModBlocks.CACTUS_BUTTON);
        addDrop(ModBlocks.CACTUS_FENCE_GATE);
        addDrop(ModBlocks.CACTUS_FENCE);
        addDrop(ModBlocks.CACTUS_PRESSURE_PLATE);
        addDrop(ModBlocks.CACTUS_TRAPDOOR);
        addDrop(ModBlocks.CACTUS_DOOR, doorDrops(ModBlocks.CACTUS_DOOR));
        addDrop(ModBlocks.CACTUS_SLAB, slabDrops(ModBlocks.CACTUS_SLAB));
    }
}
