package net.nmc.bta.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.nmc.bta.item.ModItems;

import java.util.concurrent.CompletableFuture;

import static net.nmc.bta.item.ModItems.getRK;

public class ModItemTagsProvider  extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture){
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries){
        tag(ItemTags.SWORDS).add(getRK(ModItems.BEDROCK_SWORD));
        tag(ItemTags.SPEARS).add(getRK(ModItems.BEDROCK_SPEAR));
        tag(ItemTags.PICKAXES)
                .add(getRK(ModItems.BEDROCK_PICKAXE))
                .add(getRK(ModItems.SHULKER_REINFORCED_NETHERITE_PICKAXE));
        tag(ItemTags.SHOVELS).add(getRK(ModItems.BEDROCK_SHOVEL));
        tag(ItemTags.HOES).add(getRK(ModItems.BEDROCK_HOE));
        tag(ItemTags.AXES).add(getRK(ModItems.BEDROCK_AXE));
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(getRK(ModItems.BEDROCK_HELMET));
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(getRK(ModItems.BEDROCK_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(getRK(ModItems.BEDROCK_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(getRK(ModItems.BEDROCK_BOOTS));
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(getRK(ModItems.BEDROCK_HELMET))
                .add(getRK(ModItems.BEDROCK_CHESTPLATE))
                .add(getRK(ModItems.BEDROCK_LEGGINGS))
                .add(getRK(ModItems.BEDROCK_BOOTS));
    }

}
