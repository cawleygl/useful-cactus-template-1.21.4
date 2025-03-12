package bluesteel42.usefulcactus.item;

import bluesteel42.usefulcactus.UsefulCactus;
import bluesteel42.usefulcactus.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CACTUS_PAD = registerFoodItem("cactus_pad", 1, 0.3F);
    public static final Item COOKED_CACTUS_PAD = registerFoodItem("cooked_cactus_pad", 4, 0.3F);
    public static final Item CACTUS_SALAD = registerStew("cactus_salad", 6);

    public static final Item CHOLLA_SIGN = registerSignItem("cholla_sign");
    public static final Item CHOLLA_HANGING_SIGN = registerHangingSignItem("cholla_hanging_sign");

    public static Item registerSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        final Item item = new SignItem(
                ModBlocks.CHOLLA_STANDING_SIGN,
                ModBlocks.CHOLLA_WALL_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        final Item item = new HangingSignItem(
                ModBlocks.CHOLLA_HANGING_SIGN,
                ModBlocks.CHOLLA_WALL_HANGING_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerFoodItem(String path, int nutrition, float saturation) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        final Item item = new Item(new Item.Settings().registryKey(registryKey).food(new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build()));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);

    }

    public static Item registerStew(String path, int nutrition) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        final Item item = new Item(new Item.Settings().maxCount(1).registryKey(registryKey).food(new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(0.6F)
                .build()).useRemainder(Items.BOWL));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);

    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.DRIED_KELP, ModItems.COOKED_CACTUS_PAD);
                    itemGroup.addAfter(Items.DRIED_KELP, ModItems.CACTUS_PAD);
                    itemGroup.addAfter(Items.RABBIT_STEW, ModItems.CACTUS_SALAD);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_HANGING_SIGN, ModItems.CHOLLA_HANGING_SIGN);
                    itemGroup.addAfter(Items.BAMBOO_HANGING_SIGN, ModItems.CHOLLA_SIGN);
                });

    }
}
