package net.nmc.bta.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.nmc.bta.BedrockToolsArmour;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;

import java.util.function.Function;

public class ModItems {

    public static final Item BEDROCK_SWORD = registerItem("bedrock_sword",
            properties -> new Item(
                    properties.sword(
                            ModToolMaterial.BEDROCK,
                            3.0f,
                            -2.4f)
                            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
            ));


    public static final Item BEDROCK_PICKAXE = registerItem("bedrock_pickaxe", properties -> new Item(
            properties.pickaxe(
                    ModToolMaterial.BEDROCK,
                    1.0f,
                    -2.8f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item BEDROCK_AXE = registerItem("bedrock_axe", properties -> new Item(
            properties.axe(
                    ModToolMaterial.BEDROCK,
                    5.0f,
                    -3.0f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item BEDROCK_SHOVEL = registerItem("bedrock_shovel", properties -> new Item(
            properties.shovel(
                    ModToolMaterial.BEDROCK,
                    1.5f,
                    -3.0f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item BEDROCK_HOE = registerItem("bedrock_hoe", properties -> new Item(
            properties.hoe(
                    ModToolMaterial.BEDROCK,
                    -3.0f,
                    0.0f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));

    public static final Item BEDROCK_HELMET = registerItem("bedrock_helmet", properties -> new Item(
            properties.humanoidArmor(
                    ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                    ArmorType.HELMET)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item BEDROCK_CHESTPLATE = registerItem("bedrock_chestplate", properties -> new Item(
            properties.humanoidArmor(
                            ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                            ArmorType.CHESTPLATE)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item BEDROCK_LEGGINGS = registerItem("bedrock_leggings", properties -> new Item(
            properties.humanoidArmor(
                            ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                            ArmorType.LEGGINGS)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));
    public static final Item BEDROCK_BOOTS = registerItem("bedrock_boots", properties -> new Item(
            properties.humanoidArmor(
                            ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                            ArmorType.BOOTS)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
    ));

    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                        Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, name)))));
    }

    public static void registerModItems(){
        BedrockToolsArmour.LOGGER.info("Registering Mod Items for " + BedrockToolsArmour.MOD_ID);

        // placing items in creative mode tabs
        // sword
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_SWORD);
        });

        // Pickaxe
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(BEDROCK_PICKAXE);
        });

        // Axe
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(BEDROCK_AXE);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_AXE);
        });

        // Shovel
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(BEDROCK_SHOVEL);
        });

        // Hoe
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(BEDROCK_HOE);
        });

        // Helmet
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_HELMET);
        });

        // Chestplate
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_CHESTPLATE);
        });

        // Leggings
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_LEGGINGS);
        });

        // Boots
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_BOOTS);
        });
    }
}
