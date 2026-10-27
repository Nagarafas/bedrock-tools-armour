package net.nmc.bta.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider  extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture){
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries){
        tag(ItemTags.SWORDS)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_sword")));
        tag(ItemTags.SPEARS)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_spear")));
        tag(ItemTags.PICKAXES)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_pickaxe")))
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","reinforced_pickaxe")));
        tag(ItemTags.SHOVELS)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_shovel")));
        tag(ItemTags.HOES)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_hoe")));
        tag(ItemTags.AXES)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_axe")));
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_helmet")));
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_chestplate")));
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_leggings")));
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("bedrock-tools-armour","bedrock_boots")));
    }

}
