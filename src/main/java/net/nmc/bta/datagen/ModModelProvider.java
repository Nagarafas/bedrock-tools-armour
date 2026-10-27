package net.nmc.bta.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.nmc.bta.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output){
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenrators){

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators){
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.BEDROCK_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHULKER_REINFORCED_NETHERITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_HELMET, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_CHESTPLATE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_LEGGINGS, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BEDROCK_BOOTS, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHULKER_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);


    }
}
