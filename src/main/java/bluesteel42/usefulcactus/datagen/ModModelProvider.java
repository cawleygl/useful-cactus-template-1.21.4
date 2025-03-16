package bluesteel42.usefulcactus.datagen;

import bluesteel42.usefulcactus.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool chollaPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHOLLA_PLANKS);
        chollaPlankPool.stairs(ModBlocks.CHOLLA_STAIRS);
        chollaPlankPool.slab(ModBlocks.CHOLLA_SLAB);
        chollaPlankPool.button(ModBlocks.CHOLLA_BUTTON);
        chollaPlankPool.pressurePlate(ModBlocks.CHOLLA_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CHOLLA_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.CHOLLA_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool chollaMosaicPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHOLLA_MOSAIC);
        chollaMosaicPool.stairs(ModBlocks.CHOLLA_MOSAIC_STAIRS);
        chollaMosaicPool.slab(ModBlocks.CHOLLA_MOSAIC_SLAB);

        // Signs Textures
        chollaPlankPool.family(ModBlocks.CHOLLA_SIGN_FAMILY);
        chollaPlankPool.family(ModBlocks.CHOLLA_HANGING_SIGN_FAMILY);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
