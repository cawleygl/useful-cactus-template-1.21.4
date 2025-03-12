package bluesteel42.usefulcactus.util;

import bluesteel42.usefulcactus.UsefulCactus;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CHOLLA_BLOCKS = createTag("cholla_blocks");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(UsefulCactus.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CHOLLA_BLOCKS = createTag("cholla_blocks");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(UsefulCactus.MOD_ID, name));
        }
    }
}
