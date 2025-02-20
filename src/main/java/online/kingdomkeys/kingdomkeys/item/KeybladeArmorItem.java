package online.kingdomkeys.kingdomkeys.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandlerModifiable;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.client.sound.ModSounds;
import online.kingdomkeys.kingdomkeys.container.PauldronInventory;
import online.kingdomkeys.kingdomkeys.util.Utils;

import javax.annotation.Nonnull;
import java.util.UUID;

public class KeybladeArmorItem extends BaseArmorItem {

	
	public KeybladeArmorItem(KKArmorMaterial materialIn, Type slot, String textureName) {
		super(materialIn, slot, textureName);
	}

	@Nonnull
	@Override
	public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		
		return KingdomKeys.MODID + ":" + "textures/models/armor/empty.png";
	}

	/*@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Nullable
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				HumanoidModel armorModel = ClientSetup.armorModels.get(itemStack.getItem());

				if (armorModel != null) {
					armorModel.head.visible = armorSlot == EquipmentSlot.HEAD;
					armorModel.hat.visible = false;
					armorModel.body.visible = armorSlot == EquipmentSlot.CHEST || armorSlot == EquipmentSlot.LEGS;
					armorModel.rightArm.visible = armorSlot == EquipmentSlot.CHEST;
					armorModel.leftArm.visible = armorSlot == EquipmentSlot.CHEST;
					armorModel.rightLeg.visible = armorSlot == EquipmentSlot.FEET || armorSlot == EquipmentSlot.FEET;
					armorModel.leftLeg.visible = armorSlot == EquipmentSlot.LEGS || armorSlot == EquipmentSlot.FEET;
				}
				return armorModel;
			}
		});
	}*/
	
	@Mod.EventBusSubscriber
	public static class Events {

		@SubscribeEvent
		public static void onItemDropped(EntityJoinLevelEvent event) {
			if (event.getEntity() instanceof ItemEntity) {
				ItemStack droppedItem = ((ItemEntity)event.getEntity()).getItem();
				UUID droppedID = Utils.getArmorID(droppedItem);
				if (droppedID != null && droppedItem.getItem() instanceof ArmorItem) {
					event.setCanceled(true);
				}
			}
		}

		@SubscribeEvent
		public static void onDeath(LivingDeathEvent event) {
			if (event.getEntity() instanceof Player player) {
				for (ItemStack armour : player.getArmorSlots()) {
					if (armour.getItem() instanceof ArmorItem armorItem) {
						if (Utils.hasArmorID(armour)) {
							ModCapabilities.getPlayer(player).getEquippedKBArmor(0).getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
								IItemHandlerModifiable pauldronInventory = (IItemHandlerModifiable) iItemHandler;
								switch (armorItem.getType()) {
									case HELMET -> pauldronInventory.setStackInSlot(0, armour);
									case CHESTPLATE -> pauldronInventory.setStackInSlot(1, armour);
									case LEGGINGS -> pauldronInventory.setStackInSlot(2, armour);
									case BOOTS -> pauldronInventory.setStackInSlot(3, armour);
								}
								player.level().playSound(null, player.position().x(), player.position().y(), player.position().z(), ModSounds.unsummon.get(), SoundSource.MASTER, 1.0f, 1.0f);
							});
						}
					}
				}
			}
		}

		@SubscribeEvent
		public static void onItemToss(ItemTossEvent event) {
			if (event.getEntity().getItem().getItem() instanceof ArmorItem armorItem) {
				ItemStack droppedItem = event.getEntity().getItem();
				if (Utils.hasArmorID(droppedItem)) {
					ModCapabilities.getPlayer(event.getPlayer()).getEquippedKBArmor(0).getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
						IItemHandlerModifiable pauldronInventory = (IItemHandlerModifiable) iItemHandler;
						switch (armorItem.getType()) {
							case HELMET -> pauldronInventory.setStackInSlot(0, droppedItem);
							case CHESTPLATE -> pauldronInventory.setStackInSlot(1, droppedItem);
							case LEGGINGS -> pauldronInventory.setStackInSlot(2, droppedItem);
							case BOOTS -> pauldronInventory.setStackInSlot(3, droppedItem);
						}
					event.getPlayer().level().playSound(null, event.getPlayer().position().x(), event.getPlayer().position().y(), event.getPlayer().position().z(), ModSounds.unsummon.get(), SoundSource.MASTER, 1.0f, 1.0f);
					});
				}
			}
		}



	}
}
