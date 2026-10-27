package net.nmc.bta.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nmc.bta.BedrockToolsArmour;
import net.nmc.bta.item.ModItems;


public class ModCreativeModeTabs{
    public static final CreativeModeTab BTA_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, "bta_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BEDROCK_PICKAXE))
                    .title(Component.translatable("creativemodetab.bedrock-tools-armour.bta_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SHULKER_UPGRADE_SMITHING_TEMPLATE);
                        output.accept(ModItems.SHULKER_REINFORCED_NETHERITE_PICKAXE);
                        output.accept(ModItems.BEDROCK_SWORD);
                        output.accept(ModItems.BEDROCK_SPEAR);
                        output.accept(ModItems.BEDROCK_PICKAXE);
                        output.accept(ModItems.BEDROCK_AXE);
                        output.accept(ModItems.BEDROCK_SHOVEL);
                        output.accept(ModItems.BEDROCK_HOE);
                        output.accept(ModItems.BEDROCK_HELMET);
                        output.accept(ModItems.BEDROCK_CHESTPLATE);
                        output.accept(ModItems.BEDROCK_LEGGINGS);
                        output.accept(ModItems.BEDROCK_BOOTS);
                    })
                    .build());

    public static void registerModCreativeModeTabs(){
        BedrockToolsArmour.LOGGER.info("Registering Creative Mode Tabs for " + BedrockToolsArmour.MOD_ID);
    }
}
