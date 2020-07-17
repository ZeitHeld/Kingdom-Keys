package online.kingdomkeys.kingdomkeys.network.stc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.lib.PortalCoords;

public class SCSyncCapabilityToAllPacket {

	private String name, driveForm;
	private int level = 0,
			exp = 0,
			expGiven = 0,
			strength = 0,
			magic = 0,
			defense = 0,
			reflectTicks = 0,
			aeroTicks = 0,
			antipoints = 0,
			maxHP = 20;
	
	LinkedHashMap<String,int[]> driveFormsMap = new LinkedHashMap<String,int[]>();

	private double dp = 0, fp = 0;

	private int aerialDodgeTicks = 0;
	private boolean isGliding = false, hasJumpedAD = false;
	
    PortalCoords[] orgPortalCoords = {new PortalCoords((byte)0,0,0,0,0),new PortalCoords((byte)0,0,0,0,0),new PortalCoords((byte)0,0,0,0,0)};

	
	public SCSyncCapabilityToAllPacket() {
	}

	public SCSyncCapabilityToAllPacket(String name, IPlayerCapabilities capability) {
		this.name = name;
		this.level = capability.getLevel();
		this.exp = capability.getExperience();
		this.expGiven = capability.getExperienceGiven();
		this.strength = capability.getStrength();
		this.magic = capability.getMagic();
		this.defense = capability.getDefense();
		this.driveForm = capability.getActiveDriveForm();
		this.aeroTicks = capability.getAeroTicks();
		this.reflectTicks = capability.getReflectTicks();
		this.fp = capability.getFP();
		this.dp = capability.getDP();
		this.antipoints = capability.getAntiPoints();
		this.maxHP = capability.getMaxHP();
		
        for(byte i=0;i<3;i++) {
        	this.orgPortalCoords[i] = capability.getPortalCoords((byte)i);
        }
		
		this.driveFormsMap = capability.getDriveFormsMap();

		this.isGliding = capability.getIsGliding();
		this.aerialDodgeTicks = capability.getAerialDodgeTicks();
		this.hasJumpedAD = capability.hasJumpedAerialDodge();
	}

	public void encode(PacketBuffer buffer) {
		buffer.writeString(name);
		buffer.writeInt(this.level);
		buffer.writeInt(this.exp);
		buffer.writeInt(this.expGiven);
		buffer.writeInt(this.strength);
		buffer.writeInt(this.magic);
		buffer.writeInt(this.defense);
		buffer.writeString(this.driveForm);
		buffer.writeInt(this.aeroTicks);
		buffer.writeInt(this.reflectTicks);
		buffer.writeDouble(this.dp);
		buffer.writeDouble(this.fp);
		buffer.writeInt(this.antipoints);
		buffer.writeInt(this.maxHP);
		
		for(byte i=0;i<3;i++) {
        	buffer.writeByte(this.orgPortalCoords[i].getPID());
        	buffer.writeDouble(this.orgPortalCoords[i].getX());
        	buffer.writeDouble(this.orgPortalCoords[i].getY());
        	buffer.writeDouble(this.orgPortalCoords[i].getZ());
        	buffer.writeInt(this.orgPortalCoords[i].getDimID());
        }
		
		CompoundNBT forms = new CompoundNBT();
		Iterator<Map.Entry<String, int[]>> driveFormsIt = driveFormsMap.entrySet().iterator();
		while (driveFormsIt.hasNext()) {
			Map.Entry<String, int[]> pair = (Map.Entry<String, int[]>) driveFormsIt.next();
			forms.putIntArray(pair.getKey().toString(), pair.getValue());
		}
		buffer.writeCompoundTag(forms);
		
		buffer.writeBoolean(this.isGliding);
		buffer.writeInt(this.aerialDodgeTicks);
		buffer.writeBoolean(this.hasJumpedAD);
	}

	public static SCSyncCapabilityToAllPacket decode(PacketBuffer buffer) {
		SCSyncCapabilityToAllPacket msg = new SCSyncCapabilityToAllPacket();
		msg.name = buffer.readString();
		msg.level = buffer.readInt();
		msg.exp = buffer.readInt();
		msg.expGiven = buffer.readInt();
		msg.strength = buffer.readInt();
		msg.magic = buffer.readInt();
		msg.defense = buffer.readInt();
		msg.driveForm = buffer.readString();
		msg.aeroTicks = buffer.readInt();
		msg.reflectTicks = buffer.readInt();
		msg.dp = buffer.readDouble();
		msg.fp = buffer.readDouble();
		msg.antipoints = buffer.readInt();
		msg.maxHP = buffer.readInt();
		
		for(byte i=0;i<3;i++) {
    		msg.orgPortalCoords[i].setPID(buffer.readByte());
    		msg.orgPortalCoords[i].setX(buffer.readDouble());
    		msg.orgPortalCoords[i].setY(buffer.readDouble());
    		msg.orgPortalCoords[i].setZ(buffer.readDouble());
    		msg.orgPortalCoords[i].setDimID(buffer.readInt());
        }
		
		CompoundNBT driveFormsTag = buffer.readCompoundTag();
		Iterator<String> driveFormsIt = driveFormsTag.keySet().iterator();
		while (driveFormsIt.hasNext()) {
			String driveFormName = (String) driveFormsIt.next();
			msg.driveFormsMap.put(driveFormName, driveFormsTag.getIntArray(driveFormName));
		}
		
		msg.isGliding = buffer.readBoolean();
		msg.aerialDodgeTicks = buffer.readInt();
		msg.hasJumpedAD = buffer.readBoolean();
		return msg;
	}

	public static void handle(final SCSyncCapabilityToAllPacket message, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			List<AbstractClientPlayerEntity> list = Minecraft.getInstance().world.getPlayers();
			PlayerEntity player = null;
			for (int i = 0; i < list.size(); i++) { //Loop through the players
				String name = list.get(i).getName().getFormattedText();
				if (name.equals(message.name)) {
					player = list.get(i);
				}
			}
			if (player != null) {
				LazyOptional<IPlayerCapabilities> props = player.getCapability(ModCapabilities.PLAYER_CAPABILITIES);
				props.ifPresent(cap -> cap.setLevel(message.level));
				props.ifPresent(cap -> cap.setExperience(message.exp));
				props.ifPresent(cap -> cap.setExperienceGiven(message.expGiven));
				props.ifPresent(cap -> cap.setStrength(message.strength));
				props.ifPresent(cap -> cap.setMagic(message.magic));
				props.ifPresent(cap -> cap.setDefense(message.defense));
				props.ifPresent(cap -> cap.setActiveDriveForm(message.driveForm));
				props.ifPresent(cap -> cap.setAeroTicks(message.aeroTicks));
				props.ifPresent(cap -> cap.setReflectTicks(message.reflectTicks));
				props.ifPresent(cap -> cap.setDP(message.dp));
				props.ifPresent(cap -> cap.setFP(message.fp));
				props.ifPresent(cap -> cap.setAntiPoints(message.antipoints));
				props.ifPresent(cap -> cap.setMaxHP(message.maxHP));
				
				props.ifPresent(cap -> cap.setPortalCoords((byte)0, message.orgPortalCoords[0]));
				props.ifPresent(cap -> cap.setPortalCoords((byte)1, message.orgPortalCoords[1]));
				props.ifPresent(cap -> cap.setPortalCoords((byte)2, message.orgPortalCoords[2]));
				
				props.ifPresent(cap -> cap.setDriveFormsMap(message.driveFormsMap));

				props.ifPresent(cap -> cap.setIsGliding(message.isGliding));
				props.ifPresent(cap -> cap.setAerialDodgeTicks(message.aerialDodgeTicks));
				props.ifPresent(cap -> cap.setHasJumpedAerialDodge(message.hasJumpedAD));
			}
		});
		ctx.get().setPacketHandled(true);
	}

}