package bluesteel42.usefulcactus.registries;

import bluesteel42.usefulcactus.item.ModItems;
import bluesteel42.usefulcactus.util.ModTags;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import bluesteel42.usefulcactus.block.ModBlocks;

public class ModRegistries {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.CHOLLA_BLOCK, ModBlocks.STRIPPED_CHOLLA_BLOCK);
    }

    public static void registerCompostables() {
        // Add the cactus items to the composting registry with a 30% chance of increasing the composter's level.
        CompostingChanceRegistry.INSTANCE.add(ModItems.CACTUS_PAD, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.COOKED_CACTUS_PAD, 0.5F);
    }

    public static void registerFlammables() {
        // Add blocks to flammable registry
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_MOSAIC, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_MOSAIC_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_MOSAIC_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHOLLA_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHOLLA_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIED_CHOLLA, 60, 60);
    }

    public static void registerFuels() {
        // Set Dried Cholla and Cholla Blocks as a fuel
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModBlocks.DRIED_CHOLLA, 50);
            builder.add(ModTags.Items.CHOLLA_BLOCKS, 300);

            builder.add(ModBlocks.CHOLLA_MOSAIC, 300);
            builder.add(ModBlocks.CHOLLA_MOSAIC_SLAB, 150);
            builder.add(ModBlocks.CHOLLA_MOSAIC_STAIRS, 300);
        });
    }
}
