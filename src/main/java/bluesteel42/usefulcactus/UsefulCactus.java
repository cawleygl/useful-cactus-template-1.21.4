package bluesteel42.usefulcactus;

import bluesteel42.usefulcactus.entity.ModBoats;
import bluesteel42.usefulcactus.item.ModItems;
import bluesteel42.usefulcactus.block.ModBlocks;
import bluesteel42.usefulcactus.registries.ModRegistries;
import bluesteel42.usefulcactus.util.ModTags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsefulCactus implements ModInitializer {
	public static final String MOD_ID = "useful-cactus";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();
		ModItems.initialize();
		ModBoats.initialize();
		ModRegistries.registerStrippables();
		ModRegistries.registerCompostables();

		// Set Dried Cholla and Cholla Blocks as a fuel
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModBlocks.DRIED_CHOLLA, 50);
			builder.add(ModTags.Items.CHOLLA_BLOCKS, 300);

			builder.add(ModBlocks.CHOLLA_MOSAIC, 300);
			builder.add(ModBlocks.CHOLLA_MOSAIC_SLAB, 150);
			builder.add(ModBlocks.CHOLLA_MOSAIC_STAIRS, 300);
		});

		LOGGER.info("Hello Fabric world!");
	}
}