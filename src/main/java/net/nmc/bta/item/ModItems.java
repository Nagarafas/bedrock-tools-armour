package net.nmc.bta.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.DamageResistant;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Blocks;
import net.nmc.bta.BedrockToolsArmour;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;

import java.util.List;
import java.util.function.Function;

public class ModItems {

    private static final TagKey<DamageType> BEDROCK_IMMUNE = TagKey.create(
            Registries.DAMAGE_TYPE,
            Identifier.fromNamespaceAndPath("bedrock-tools-armour", "bedrock_immune"));

    public static final Item SHULKER_REINFORCED_NETHERITE_PICKAXE = registerItem("reinforced_pickaxe", properties -> new Item(
            properties.pickaxe(
                            ModToolMaterial.SHULKER,
                            1.0f,
                            -2.8f)
                    .fireResistant()
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.translatable("item.bedrock-tools-armour.reinforced_pickaxe.tooltip")
                                    .withStyle(ChatFormatting.DARK_AQUA)
                                    .withStyle(style -> style.withItalic(false)))))
    ));

    public static final Item BEDROCK_SWORD = registerItem("bedrock_sword",
            properties -> new Item(
                    properties.sword(
                            ModToolMaterial.BEDROCK,
                            3.0f,
                            -2.4f)
                            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                            .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                        context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
            ));

    public static final Item BEDROCK_SPEAR = registerItem("bedrock_spear",
            properties -> new Item(
                    properties.spear(
                                    ModToolMaterial.BEDROCK,
                                    1.35f,
                                    1.40f,
                                    0.30f,
                                    2.5f,
                                    6.0f,
                                    4.0f,
                                    5.1f,
                                    7.5f,
                                    4.6f)
                            .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                            .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                            context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
            ));

    public static final Item BEDROCK_PICKAXE = registerItem("bedrock_pickaxe", properties -> new Item(
            properties.pickaxe(
                    ModToolMaterial.BEDROCK,
                    1.0f,
                    -2.8f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));

    public static final Item BEDROCK_AXE = registerItem("bedrock_axe", properties -> new Item(
            properties.axe(
                    ModToolMaterial.BEDROCK,
                    5.0f,
                    -3.0f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));

    public static final Item BEDROCK_SHOVEL = registerItem("bedrock_shovel", properties -> new Item(
            properties.shovel(
                    ModToolMaterial.BEDROCK,
                    1.5f,
                    -3.0f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));

    public static final Item BEDROCK_HOE = registerItem("bedrock_hoe", properties -> new Item(
            properties.hoe(
                    ModToolMaterial.BEDROCK,
                    -5.0f,
                    0.0f)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));

    public static final Item BEDROCK_HELMET = registerItem("bedrock_helmet", properties -> new Item(
            properties.humanoidArmor(
                    ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                    ArmorType.HELMET)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));
    public static final Item BEDROCK_CHESTPLATE = registerItem("bedrock_chestplate", properties -> new Item(
            properties.humanoidArmor(
                            ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                            ArmorType.CHESTPLATE)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));
    public static final Item BEDROCK_LEGGINGS = registerItem("bedrock_leggings", properties -> new Item(
            properties.humanoidArmor(
                            ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                            ArmorType.LEGGINGS)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));
    public static final Item BEDROCK_BOOTS = registerItem("bedrock_boots", properties -> new Item(
            properties.humanoidArmor(
                            ModArmourMaterial.BEDROCK_ARMOUR_MATERIAL,
                            ArmorType.BOOTS)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.DAMAGE_RESISTANT,
                context -> new DamageResistant(context.getOrThrow(BEDROCK_IMMUNE)))
    ));

    public static final Item SHULKER_UPGRADE_SMITHING_TEMPLATE = registerItem("shulker_upgrade_smithing_template",
            properties -> new SmithingTemplateItem(
                    Component.translatable("item.bedrock-tools-armour.smithing_template.shulker_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.bedrock-tools-armour.smithing_template.shulker_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.bedrock-tools-armour.smithing_template.shulker_upgrade.base_slot_description"),
                    Component.translatable("item.bedrock-tools-armour.smithing_template.shulker_upgrade.additions_slot_description"),
                    List.of(Identifier.withDefaultNamespace("container/slot/pickaxe")),
                    List.of(Identifier.withDefaultNamespace("container/slot/ingot")),
                    properties));

    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, name),
                function.apply(new Item.Properties().rarity(Rarity.EPIC).setId(ResourceKey.create(Registries.ITEM,
                        Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, name)))));
    }

    public static void registerModItems(){
        BedrockToolsArmour.LOGGER.info("Registering Mod Items for " + BedrockToolsArmour.MOD_ID);

        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> {
            if (!state.is(Blocks.BEDROCK)) return;

            ItemStack stack = player.getMainHandItem();
            if (stack.is(SHULKER_REINFORCED_NETHERITE_PICKAXE)) {
                // vanilla already took 1 durability, so 249 more makes 250 per bedrock block
                stack.hurtAndBreak(255, player, EquipmentSlot.MAINHAND);
            }
        });
        // placing items in creative mode tabs

        // reinforced pick
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(SHULKER_REINFORCED_NETHERITE_PICKAXE);
        });

        // Sword
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_SWORD);
        });

        // Spear
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BEDROCK_SPEAR);
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

        // Template
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(SHULKER_UPGRADE_SMITHING_TEMPLATE);
        });
    }
}
