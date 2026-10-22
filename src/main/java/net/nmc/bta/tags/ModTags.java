package net.nmc.bta.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nmc.bta.BedrockToolsArmour;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_BEDROCK_TOOL = createTag( "needs_bedrock_tool");
        public static final TagKey<Block> INCORRECT_FOR_BEDROCK_TOOL = createTag( "incorrect_for_bedrock_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BEDROCK_REPAIR = createTag( "bedrock_repair");

        public static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, name));
        }
    }

}
