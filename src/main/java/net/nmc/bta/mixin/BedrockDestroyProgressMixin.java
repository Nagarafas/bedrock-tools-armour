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
        if ((state.is(Blocks.BEDROCK) || state.is(Blocks.REINFORCED_DEEPSLATE) || state.is(Blocks.END_PORTAL_FRAME)) && isInvalidPick(player)){
            cir.setReturnValue(0.0F);
        }
    }

    private boolean isInvalidPick(Player player){
        return (!player.getMainHandItem().is(ModItems.BEDROCK_PICKAXE) && !player.getMainHandItem().is(ModItems.SHULKER_REINFORCED_NETHERITE_PICKAXE));
    }
}