package net.nmc.bta.mixin;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BlockBehaviour.Properties.class)
public class BlockPropertiesMixin {

    private static final ResourceKey<LootTable> BEDROCK_LOOT_TABLE = ResourceKey.create(
            Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath("bedrock-tools-armour", "blocks/bedrock")
    );

    private static final boolean DATAGEN = System.getProperty("fabric-api.datagen") != null;

    @Inject(method = "setId", at = @At("RETURN"))
    private void makeBedrockBreakable(ResourceKey<Block> id, CallbackInfoReturnable<BlockBehaviour.Properties> cir) {
        if (id.identifier().equals(Identifier.withDefaultNamespace("bedrock"))) {
            BlockBehaviour.Properties properties = cir.getReturnValue()
                    .destroyTime(50.0F)
                    .requiresCorrectToolForDrops();

            // Vanilla's datagen checks that every block's loot table gets generated,
            // so only apply the override outside of datagen.
            if (!DATAGEN) {
                properties.overrideLootTable(Optional.of(BEDROCK_LOOT_TABLE));
            }
        }
    }
}