package net.nmc.bta.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.nmc.bta.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture){
        super(output, registryLookupFuture);
    }

   @Override
   protected void addTags(HolderLookup.Provider registries){
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(ModTags.Blocks.NEEDS_BEDROCK_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_COPPER_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("bedrock")))
                .add(ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("reinforced_deepslate")));

   }
}

