package net.nmc.bta.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;
import net.nmc.bta.item.ModItems;


public class ModLootTableModifiers {

    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                        LootTableSource source, HolderLookup.Provider provider){
        if(key.identifier().equals(Identifier.withDefaultNamespace("chests/end_city_treasure"))){
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.SHULKER_UPGRADE_SMITHING_TEMPLATE))
                    .when(LootItemRandomChanceCondition.randomChance(0.05f));

            builder.pool(poolBuilder.build());
        };
    }
}
