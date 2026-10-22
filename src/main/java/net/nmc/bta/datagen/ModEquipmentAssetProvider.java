package net.nmc.bta.datagen;

import com.mojang.serialization.Codec;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nmc.bta.BedrockToolsArmour;
import net.nmc.bta.item.ModArmourMaterial;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider implements DataProvider {

    public final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture){
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    };

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer){
        consumer.accept(
                ModArmourMaterial.BEDROCK_KEY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(BedrockToolsArmour.MOD_ID, "bedrock"))
                        .build());
    }

    @Override
    public CompletableFuture<?> run(final CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + String.valueOf(id));
            }
        });
        Codec var10001 = EquipmentClientInfo.CODEC;
        PackOutput.PathProvider var10002 = this.pathProvider;
        Objects.requireNonNull(var10002);
        return DataProvider.saveAll(cache, var10001, var10002::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "Bedrock Tools and Armour Equipment Asset Provider";
    }
}
