package online.kingdomkeys.kingdomkeys.shotlock;

import java.util.List;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.entity.shotlock.PrismRainCoreEntity;

@Mod.EventBusSubscriber(modid = KingdomKeys.MODID)
public class ShotlockPrismRain extends Shotlock {

	public ShotlockPrismRain(String registryName, int order, int cooldown, int max) {
		super(registryName, order, cooldown, max);
	}

	@Override
	public void doPartialShotlock(Player player, List<Entity> targetList) {
		PrismRainCoreEntity core = new PrismRainCoreEntity(player.level(), player, targetList, getDamage(player));
		core.setPos(player.getX(), player.getY(), player.getZ());
		player.level().addFreshEntity(core);
	}

	@Override
	public void doFullShotlock(Player player, List<Entity> targetList) {
		doPartialShotlock(player,targetList);
	}
}