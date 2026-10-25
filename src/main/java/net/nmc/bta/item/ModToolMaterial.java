package net.nmc.bta.item;
import net.minecraft.world.item.ToolMaterial;
import net.nmc.bta.tags.ModTags;

public class ModToolMaterial {
    public static final ToolMaterial BEDROCK = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_BEDROCK_TOOL, // incorrect blocks for drops
            32, // durability
            80.0F, // speed
            8.0F, // attack damage bonus
            30, // enchantment value
            ModTags.Items.BEDROCK_REPAIR // repair items
    );
}