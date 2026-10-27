package net.nmc.bta.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.nmc.bta.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class ReinforcedPickDestroyProgressMixin {

    @Unique
    private static final float BEDROCK_SPEED_MULTIPLIER = 0.05F;

    @Inject(method = "getDestroyProgress", at = @At("RETURN"), cancellable = true)
    private void ReinforcedPickaxeMinesSlow(Player player, BlockGetter level, BlockPos pos,
                                          CallbackInfoReturnable<Float> cir) {
        BlockState state = (BlockState) (Object) this;
        if ( (state.is(Blocks.BEDROCK) || state.is(Blocks.REINFORCED_DEEPSLATE)) && player.getMainHandItem().is(ModItems.SHULKER_REINFORCED_NETHERITE_PICKAXE)){
            cir.setReturnValue(cir.getReturnValueF() * BEDROCK_SPEED_MULTIPLIER);
        }

    }

}