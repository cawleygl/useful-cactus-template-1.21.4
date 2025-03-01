package bluesteel42.usefulcactus;

import bluesteel42.usefulcactus.item.ModItems;
import bluesteel42.usefulcactus.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
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
		ModItems.initialize();
		ModBlocks.initialize();

		// Add the cactus items to the composting registry with a 30% chance of increasing the composter's level.
		CompostingChanceRegistry.INSTANCE.add(ModItems.CACTUS_PAD, 0.3F);
		CompostingChanceRegistry.INSTANCE.add(ModItems.COOKED_CACTUS_PAD, 0.5F);

		LOGGER.info("Hello Fabric world!");
	}
}