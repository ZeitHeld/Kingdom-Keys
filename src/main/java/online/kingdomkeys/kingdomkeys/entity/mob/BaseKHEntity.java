package online.kingdomkeys.kingdomkeys.entity.mob;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import online.kingdomkeys.kingdomkeys.capability.IGlobalCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.config.ModConfigs;
import online.kingdomkeys.kingdomkeys.entity.EntityHelper.MobType;
import online.kingdomkeys.kingdomkeys.item.KeybladeItem;
import online.kingdomkeys.kingdomkeys.item.ModItems;
import online.kingdomkeys.kingdomkeys.item.organization.IOrgWeapon;

public class BaseKHEntity extends Monster implements IKHMob {

	public BaseKHEntity(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public int getDefense() {
		return 0;
	}

	@Override
	public MobType getKHMobType() {
		return MobType.NPC;
	}

	@Override
	public int getExperienceReward() {
		if (getKHMobType() != MobType.NPC) {
			IGlobalCapabilities mobData = ModCapabilities.getGlobal(this);
			if (mobData != null && mobData.getLevel() > 0) {
				return (int) (super.getExperienceReward() * (mobData.getLevel() / 10F));
			}
		}
		return super.getExperienceReward();
	}

	@Override //True = can't get hit
	public boolean skipAttackInteraction(Entity pEntity) {
		if (getKHMobType() != MobType.NPC) {
			if(pEntity instanceof Player player) {
				if(ItemStack.isSameItem(player.getMainHandItem(),ItemStack.EMPTY)) {
					return true;
				}
				if(player.getMainHandItem().getItem() instanceof KeybladeItem || player.getMainHandItem().getItem() instanceof IOrgWeapon) {
					return false;
				}
				if(player.getMainHandItem().getItem() == ModItems.dreamSword.get() || player.getMainHandItem().getItem() == ModItems.dreamSword.get() || player.getMainHandItem().getItem() == ModItems.dreamShield.get()) {
					return false;
				}
				if(player.getMainHandItem().getItem() == ModItems.struggleSword.get() || player.getMainHandItem().getItem() == ModItems.struggleWand.get() || player.getMainHandItem().getItem() == ModItems.struggleHammer.get() || player.getMainHandItem().getItem() == ModItems.woodenStick.get()) {
					return true;
				}
				return ModConfigs.needKeybladeForHeartless;
			}
		}
		return super.skipAttackInteraction(pEntity);
	}

}