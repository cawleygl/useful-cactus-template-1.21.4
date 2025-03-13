package bluesteel42.usefulcactus.datagen;

import bluesteel42.usefulcactus.block.ModBlocks;
import bluesteel42.usefulcactus.entity.ModBoats;
import bluesteel42.usefulcactus.item.ModItems;
import bluesteel42.usefulcactus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.BAMBOO_BLOCKS)
                .add(ModBlocks.CHOLLA_BLOCK.asItem())
                .add(ModBlocks.STRIPPED_CHOLLA_BLOCK.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.CHOLLA_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.CHOLLA_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.STAIRS).add(ModBlocks.CHOLLA_MOSAIC_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.CHOLLA_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.SLABS).add(ModBlocks.CHOLLA_MOSAIC_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.CHOLLA_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.CHOLLA_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.CHOLLA_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.CHOLLA_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.CHOLLA_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.CHOLLA_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS).add(ModItems.CHOLLA_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(ModItems.CHOLLA_HANGING_SIGN);

        getOrCreateTagBuilder(ItemTags.BOATS).add(ModBoats.CHOLLA_RAFT.asItem());
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModBoats.CHOLLA_CHEST_RAFT.asItem());
    }
}
