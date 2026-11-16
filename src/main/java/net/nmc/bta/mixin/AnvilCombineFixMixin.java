package net.nmc.bta.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AnvilMenu.class)
public abstract class AnvilCombineFixMixin {

    @WrapOperation(method = "createResult",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;isDamageableItem()Z"))
    private boolean allowUnbreakableBedrockGear(ItemStack stack, Operation<Boolean> original) {
        boolean bedrockGear = stack.has(DataComponents.MAX_DAMAGE)
                && stack.has(DataComponents.UNBREAKABLE)
                && BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace().equals("bedrock-tools-armour");
        return original.call(stack) || bedrockGear;
    }
}