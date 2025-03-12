package bluesteel42.usefulcactus.entity;

import bluesteel42.usefulcactus.UsefulCactus;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier CHOLLA_RAFTS_ID = Identifier.of(UsefulCactus.MOD_ID, "cholla");

    public static final Item CHOLLA_RAFT = registerBoatItem("cholla_raft", ModBoats.CHOLLA_RAFTS_ID, false, true);
    public static final Item CHOLLA_CHEST_RAFT = registerBoatItem("cholla_chest_raft", ModBoats.CHOLLA_RAFTS_ID, true, true);

    public static Item registerBoatItem(String path, Identifier boatId, boolean chest, boolean raft) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, path));
        return TerraformBoatItemHelper.registerBoatItem(
                boatId,
                new Item.Settings().maxCount(1).registryKey(registryKey),
                chest,
                raft
        );
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_CHEST_RAFT, ModBoats.CHOLLA_CHEST_RAFT);
                    itemGroup.addAfter(Items.BAMBOO_CHEST_RAFT, ModBoats.CHOLLA_RAFT);
                });

    }

}
