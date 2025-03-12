package bluesteel42.usefulcactus.datagen;

import bluesteel42.usefulcactus.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHOLLA_BLOCK);
        addDrop(ModBlocks.STRIPPED_CHOLLA_BLOCK);
        addDrop(ModBlocks.DRIED_CHOLLA);

        addDrop(ModBlocks.CHOLLA_PLANKS);
        addDrop(ModBlocks.CHOLLA_MOSAIC);
        addDrop(ModBlocks.CHOLLA_STAIRS);
        addDrop(ModBlocks.CHOLLA_MOSAIC_STAIRS);
        addDrop(ModBlocks.CHOLLA_BUTTON);
        addDrop(ModBlocks.CHOLLA_FENCE_GATE);
        addDrop(ModBlocks.CHOLLA_FENCE);
        addDrop(ModBlocks.CHOLLA_PRESSURE_PLATE);
        addDrop(ModBlocks.CHOLLA_TRAPDOOR);
        addDrop(ModBlocks.CHOLLA_DOOR, doorDrops(ModBlocks.CHOLLA_DOOR));
        addDrop(ModBlocks.CHOLLA_SLAB, slabDrops(ModBlocks.CHOLLA_SLAB));
        addDrop(ModBlocks.CHOLLA_MOSAIC_SLAB, slabDrops(ModBlocks.CHOLLA_MOSAIC_SLAB));

        addDrop(ModBlocks.CHOLLA_STANDING_SIGN);
        addDrop(ModBlocks.CHOLLA_WALL_SIGN);
        addDrop(ModBlocks.CHOLLA_HANGING_SIGN);
        addDrop(ModBlocks.CHOLLA_WALL_HANGING_SIGN);

    }
}
