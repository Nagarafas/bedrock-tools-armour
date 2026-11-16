package net.nmc.bta.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.nmc.bta.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BlockBehaviour.class)
public abstract class BedrockDropFix {

    @Inject(method = "getDrops", at = @At("HEAD"), cancellable = true)
    private void bedrockNeedsRightPickaxe(BlockState state, LootParams.Builder params,
                                          CallbackInfoReturnable<List<ItemStack>> cir) {
        if (!state.is(Blocks.BEDROCK)) return;

        ItemStack tool = (ItemStack) params.getOptionalParameter(LootContextParams.TOOL);
        boolean allowed = tool != null
                && (tool.is(ModItems.SHULKER_REINFORCED_NETHERITE_PICKAXE) || tool.is(ModItems.BEDROCK_PICKAXE));
        if (!allowed) {
            cir.setReturnValue(List.of());
        }
    }
}