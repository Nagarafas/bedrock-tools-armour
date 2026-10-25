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
public abstract class ObsidianDestroyProgressMixin {

    @Unique
    private static final float OBSIDIAN_SPEED_MULTIPLIER = 4.0F;

    @Inject(method = "getDestroyProgress", at = @At("RETURN"), cancellable = true)
    private void obsidianPickaxeMinesFast(Player player, BlockGetter level, BlockPos pos,
                                          CallbackInfoReturnable<Float> cir) {
        BlockState state = (BlockState) (Object) this;
        if ( isObsidianBased(state) && player.getMainHandItem().is(ModItems.BEDROCK_PICKAXE)){
            cir.setReturnValue(cir.getReturnValueF() * OBSIDIAN_SPEED_MULTIPLIER);
        }

    }

    @Unique
    private boolean isObsidianBased(BlockState state){
      return ((state.is(Blocks.OBSIDIAN) || (state.is(Blocks.CRYING_OBSIDIAN)) || (state.is(Blocks.RESPAWN_ANCHOR))));
    }
}