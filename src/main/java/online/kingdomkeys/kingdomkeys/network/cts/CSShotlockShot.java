package online.kingdomkeys.kingdomkeys.network.cts;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.network.PacketHandler;
import online.kingdomkeys.kingdomkeys.shotlock.Shotlock;
import online.kingdomkeys.kingdomkeys.util.Utils;

public class CSShotlockShot {
	
	List<Integer> shotlockEnemies;
	double cost;
	
	public CSShotlockShot() {}

	public CSShotlockShot(double cost, List<Integer> shotlockEnemies) {
		this.cost = cost;
		this.shotlockEnemies = shotlockEnemies;
	}


	public void encode(PacketBuffer buffer) {
		buffer.writeDouble(this.cost);
		buffer.writeInt(this.shotlockEnemies.size());
		for(int i= 0; i< this.shotlockEnemies.size(); i++) {
			buffer.writeInt(this.shotlockEnemies.get(i));
		}
	}

	public static CSShotlockShot decode(PacketBuffer buffer) {
		CSShotlockShot msg = new CSShotlockShot();
		msg.cost = buffer.readDouble();
		int size = buffer.readInt();
		msg.shotlockEnemies = new ArrayList<Integer>();

		for(int i= 0; i< size; i++) {
			msg.shotlockEnemies.add(buffer.readInt());
		}

		return msg;
	}

	public static void handle(CSShotlockShot message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			PlayerEntity player = ctx.get().getSender();

			IPlayerCapabilities playerData = ModCapabilities.getPlayer(player);
			Shotlock shotlock = Utils.getPlayerShotlock(player);
			
			List<Entity> targets = new ArrayList<Entity>();
			for(int enemyID : message.shotlockEnemies) {
				Entity target = player.world.getEntityByID(enemyID);
				targets.add(target);
			}

			shotlock.onUse(player, targets);
			playerData.remFocus(message.cost);
			PacketHandler.syncToAllAround(player, playerData);
			
		});
		ctx.get().setPacketHandled(true);
	}

}