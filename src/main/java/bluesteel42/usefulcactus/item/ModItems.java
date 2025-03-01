package bluesteel42.usefulcactus.item;

import bluesteel42.usefulcactus.UsefulCactus;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CACTUS_PAD = registerFoodItem("cactus_pad", 1, 0.3F);
    public static final Item COOKED_CACTUS_PAD = registerFoodItem("cooked_cactus_pad", 4, 0.3F);
    public static final Item CACTUS_SALAD = registerStew("cactus_salad", 6);

    public static Item registerFoodItem(String path, int nutrition, float saturation) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        final Item item = new Item(new Item.Settings().registryKey(registryKey).food(new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build()));
        // Register the item.
        return Registry.register(Registries.ITEM, registryKey.getValue(), item);

    }

    public static Item registerStew(String path, int nutrition) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        final Item item = new Item(new Item.Settings().maxCount(1).registryKey(registryKey).food(new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(0.6F)
                .build()).useRemainder(Items.BOWL));
        // Register the item.
        return Registry.register(Registries.ITEM, registryKey.getValue(), item);

    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.DRIED_KELP, ModItems.COOKED_CACTUS_PAD);
                    itemGroup.addAfter(Items.DRIED_KELP, ModItems.CACTUS_PAD);
                    itemGroup.addAfter(Items.RABBIT_STEW, ModItems.CACTUS_SALAD);
                });
    }
}
