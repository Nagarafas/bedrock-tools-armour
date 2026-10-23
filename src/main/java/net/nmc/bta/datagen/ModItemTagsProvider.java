package net.nmc.bta.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nmc.bta.BedrockToolsArmour;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> BEDROCK_ITEMS = TagKey.create(Registries.ITEM, BedrockToolsArmour.id("bedrock_items"));

    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture){
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup){
    }
}
