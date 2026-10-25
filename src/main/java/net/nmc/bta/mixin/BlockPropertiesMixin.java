package net.nmc.bta.mixin;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BlockBehaviour.class)
public class BlockPropertiesMixin {

    // Stored as a raw ResourceKey (fixes the Optional field warning!)
    // Uses YOUR mod's namespace so Fabric's datagen doesn't filter it out!
    @Unique
    private static final ResourceKey<LootTable> BEDROCK_LOOT_TABLE = ResourceKey.create(
            Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath("bedrock-tools-armour", "blocks/bedrock")
    );

    @Inject(method = "getLootTable", at = @At("HEAD"), cancellable = true)
    private void getBedrockLootTable(CallbackInfoReturnable<Optional<ResourceKey<LootTable>>> cir) {
        if ((Object) this == Blocks.BEDROCK) {
            cir.setReturnValue(Optional.of(BEDROCK_LOOT_TABLE));
        }
    }

    @Mixin(BlockBehaviour.Properties.class)
    public static class PropertiesMixin {
        @Inject(method = "setId", at = @At("RETURN"))
        private void makeBedrockBreakable(ResourceKey<Block> id, CallbackInfoReturnable<BlockBehaviour.Properties> cir) {
            if (id.identifier().equals(Identifier.withDefaultNamespace("bedrock"))) {
                cir.getReturnValue()
                        .destroyTime(50.0F)
                        .requiresCorrectToolForDrops();
            }
        }
    }
}