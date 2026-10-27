package net.nmc.bta.mixin;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BlockBehaviour.Properties.class)
public class BlockPropertiesMixin {

    @Unique
    private static final ResourceKey<LootTable> BEDROCK_LOOT_TABLE = ResourceKey.create(
            Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath("bedrock-tools-armour", "blocks/bedrock")
    );

    @Unique
    private static final ResourceKey<LootTable> REINFORCED_DEEPSLATE_LOOT_TABLE = ResourceKey.create(
            Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath("bedrock-tools-armour", "blocks/reinforced_deepslate")
    );

    @Unique
    private static final ResourceKey<LootTable> END_PORTAL_FRAME_LOOT_TABLE = ResourceKey.create(
            Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath("bedrock-tools-armour", "blocks/end_portal_frame")
    );

    @Unique
    private static final boolean DATAGEN = System.getProperty("fabric-api.datagen") != null;

    @Inject(method = "setId", at = @At("RETURN"))
    private void makeBedrockBreakable(ResourceKey<Block> id, CallbackInfoReturnable<BlockBehaviour.Properties> cir) {
        boolean isBedrock = id.identifier().equals(Identifier.withDefaultNamespace("bedrock")),
                isReinforced_deepslate = id.identifier().equals(Identifier.withDefaultNamespace("reinforced_deepslate")),
                isEnd_portal_frame = id.identifier().equals(Identifier.withDefaultNamespace("end_portal_frame"));
        if (isBedrock) {
            BlockBehaviour.Properties properties = cir.getReturnValue()
                    .destroyTime(25.0F)
                    .requiresCorrectToolForDrops();

            if (!DATAGEN) {
                properties.overrideLootTable(Optional.of(BEDROCK_LOOT_TABLE));

            }
        }
        if(isReinforced_deepslate || isEnd_portal_frame) {
            BlockBehaviour.Properties properties = cir.getReturnValue()
                    .destroyTime(20.0F)
                    .requiresCorrectToolForDrops();

            if (!DATAGEN && isReinforced_deepslate) {
                properties.overrideLootTable(Optional.of(REINFORCED_DEEPSLATE_LOOT_TABLE));
            }else {
                properties.overrideLootTable(Optional.of(END_PORTAL_FRAME_LOOT_TABLE));
            }
        }
    }
}