package bluesteel42.usefulcactus.datagen;

import bluesteel42.usefulcactus.block.ModBlocks;
import bluesteel42.usefulcactus.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.CACTUS_LOG).log(ModBlocks.CACTUS_LOG).wood(ModBlocks.CACTUS_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CACTUS_LOG).log(ModBlocks.STRIPPED_CACTUS_LOG).wood(ModBlocks.STRIPPED_CACTUS_WOOD);

        BlockStateModelGenerator.BlockTexturePool cactusPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CACTUS_PLANKS);
        cactusPlankPool.stairs(ModBlocks.CACTUS_STAIRS);
        cactusPlankPool.slab(ModBlocks.CACTUS_SLAB);
        cactusPlankPool.button(ModBlocks.CACTUS_BUTTON);
        cactusPlankPool.fence(ModBlocks.CACTUS_FENCE);
        cactusPlankPool.fenceGate(ModBlocks.CACTUS_FENCE_GATE);
        cactusPlankPool.pressurePlate(ModBlocks.CACTUS_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CACTUS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CACTUS_TRAPDOOR);
        // Signs Textures
        cactusPlankPool.family(ModBlocks.CACTUS_SIGN_FAMILY);
        cactusPlankPool.family(ModBlocks.CACTUS_HANGING_SIGN_FAMILY);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
