package net.nmc.bta.item;

import net.minecraft.world.item.ToolMaterial;
import net.nmc.bta.tags.ModTags;

public class ModToolMaterial {
    public static final ToolMaterial BEDROCK = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_BEDROCK_TOOL, // incorrect blocks for drops
            10241, // durability
            9.0F, // speed
            6.0F, // attack damage bonus
            25, // enchantment value
            ModTags.Items.BEDROCK_REPAIR // repair items
    );
}
