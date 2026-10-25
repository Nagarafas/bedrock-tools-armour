package net.nmc.bta.mixin;

import net.minecraft.core.HolderSet;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.core.registries.BuiltInRegistries;

@Mixin(Enchantment.class)
public abstract class BedrockEnchantmentMixin {

    @Inject(method = "isSupportedItem", at = @At("HEAD"), cancellable = true)
    private void blockDurabilityOnSupported(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (isDurabilityEnchantOnBedrockGear(stack)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "isPrimaryItem", at = @At("HEAD"), cancellable = true)
    private void blockDurabilityOnPrimary(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (isDurabilityEnchantOnBedrockGear(stack)) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private boolean isDurabilityEnchantOnBedrockGear(ItemStack stack) {
        Enchantment self = (Enchantment) (Object) this;
        HolderSet<Item> supported = self.definition().supportedItems();
        boolean isDurabilityEnchant = supported instanceof HolderSet.Named<Item> named
                && named.key() == ItemTags.DURABILITY_ENCHANTABLE;
        return isDurabilityEnchant
                && BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace().equals("bedrock-tools-armour");
    }
}