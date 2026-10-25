package net.nmc.bta.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.nmc.bta.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BedrockDestroyProgressMixin {

    @Inject(method = "getDestroyProgress", at = @At("HEAD"), cancellable = true)
    private void onlyBedrockPickaxeBreaksBedrock(Player player, BlockGetter level, BlockPos pos,
                                                 CallbackInfoReturnable<Float> cir) {
        BlockState state = (BlockState) (Object) this;
        if ((state.is(Blocks.BEDROCK) || state.is(Blocks.REINFORCED_DEEPSLATE)) && !player.getMainHandItem().is(ModItems.BEDROCK_PICKAXE)) {
            cir.setReturnValue(0.0F);
        }
    }
}