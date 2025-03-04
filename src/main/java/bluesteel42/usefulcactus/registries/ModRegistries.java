package bluesteel42.usefulcactus.registries;

import bluesteel42.usefulcactus.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import bluesteel42.usefulcactus.block.ModBlocks;

public class ModRegistries {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.CACTUS_LOG, ModBlocks.STRIPPED_CACTUS_LOG);
        StrippableBlockRegistry.register(ModBlocks.CACTUS_WOOD, ModBlocks.STRIPPED_CACTUS_WOOD);
    }

    public static void registerCompostables() {
        // Add the cactus items to the composting registry with a 30% chance of increasing the composter's level.
        CompostingChanceRegistry.INSTANCE.add(ModItems.CACTUS_PAD, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.COOKED_CACTUS_PAD, 0.5F);
    }
}
