package net.nmc.bta.item;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nmc.bta.BedrockToolsArmour;
import net.nmc.bta.tags.ModTags;

public class ModArmourMaterial {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> BEDROCK_KEY =
            ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, "bedrock"));

    public static final ArmorMaterial BEDROCK_ARMOUR_MATERIAL = new ArmorMaterial(
            32,
            ArmorMaterials.makeDefense(6, 12, 16, 6, 40),
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            10.0f,
            1.0f,
            ModTags.Items.BEDROCK_REPAIR,
            BEDROCK_KEY
    );
}
