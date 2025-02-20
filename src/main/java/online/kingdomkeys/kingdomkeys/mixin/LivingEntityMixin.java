package online.kingdomkeys.kingdomkeys.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import online.kingdomkeys.kingdomkeys.capability.IGlobalCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.client.sound.ModSounds;
import online.kingdomkeys.kingdomkeys.util.Utils;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot pSlot);

    @Shadow public abstract void startUsingItem(InteractionHand pHand);

    @SuppressWarnings("UnreachableCode")
    @Redirect(method = "die", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", remap = false))
    public void stopDeathLogSpam(Logger instance, String s, Object o, Object o1) {
        IGlobalCapabilities globalData = (ModCapabilities.getGlobal((LivingEntity)(Object)this));
        if (globalData != null) {
            if (globalData.getLevel() > 0) {
                return;
            }
        }
        instance.info(s, o, o1);
    }

    @SuppressWarnings("UnreachableCode")
    @Inject(method = "broadcastBreakEvent(Lnet/minecraft/world/entity/EquipmentSlot;)V", at = @At(value = "TAIL"))
    public void armourBreak(EquipmentSlot pSlot, CallbackInfo ci) {
        if (((LivingEntity)(Object)this) instanceof Player player) {
            if (pSlot.isArmor()) {
                ItemStack stack = player.getItemBySlot(pSlot);
                if (stack.getTag() != null) {
                    if (Utils.hasArmorID(stack)) {
                        ModCapabilities.getPlayer(player).getEquippedKBArmor(0).getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
                            IItemHandlerModifiable pauldronInventory = (IItemHandlerModifiable) iItemHandler;
                            switch (pSlot) {
                                case HEAD -> pauldronInventory.setStackInSlot(0, ItemStack.EMPTY);
                                case CHEST -> pauldronInventory.setStackInSlot(1, ItemStack.EMPTY);
                                case LEGS -> pauldronInventory.setStackInSlot(2, ItemStack.EMPTY);
                                case FEET -> pauldronInventory.setStackInSlot(3, ItemStack.EMPTY);
                            }
                            player.level().playSound(null, player.position().x(), player.position().y(), player.position().z(), ModSounds.unsummon.get(), SoundSource.MASTER, 1.0f, 1.0f);
                        });
                    }
                }
            }
        }
    }

}
