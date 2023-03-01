package online.kingdomkeys.kingdomkeys.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import online.kingdomkeys.kingdomkeys.api.item.IItemCategory;
import online.kingdomkeys.kingdomkeys.api.item.ItemCategory;
import online.kingdomkeys.kingdomkeys.entity.GummiShipEntity;
import online.kingdomkeys.kingdomkeys.handler.KeyboardHelper;

import java.util.List;

import net.minecraft.world.item.Item.Properties;

public class GummiShipItem extends Item implements IItemCategory {
	
	//String data = "255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255";
	String data = "255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,16711680,255,";
	public GummiShipItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		if (!world.isClientSide) {
			GummiShipEntity gummi = new GummiShipEntity(world);
			gummi.setPos(player.getX(), player.getY(), player.getZ());
			gummi.setData(player.getItemInHand(hand).getTag().getString("data"));
			world.addFreshEntity(gummi);
		}
		return InteractionResultHolder.success(player.getItemInHand(hand));
	}

	private void takeItem(Player player) {
		if (!ItemStack.matches(player.getMainHandItem(), ItemStack.EMPTY) && player.getMainHandItem().getItem() == this) {
			player.getMainHandItem().shrink(1);
		} else if (!ItemStack.matches(player.getOffhandItem(), ItemStack.EMPTY) && player.getOffhandItem().getItem() == this) {
			player.getOffhandItem().shrink(1);
		}
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if(stack.getTag() != null && stack.getTag().contains("data") && KeyboardHelper.isShiftDown()) {
			/*String[] d = stack.getTag().getString("data").split(",");
			String formatted = "";
			for(int i=0;i<d.length;i++) {
				formatted+= d[i]+" ";
				
				if(i %5 == 0) {
					formatted+=" ";
				}
			}*/
			tooltip.add(new TranslatableComponent(stack.getTag().getString("data")));

			
		}
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public void inventoryTick(ItemStack itemStack, Level world, Entity entity, int itemSlot, boolean isSelected) {
		if (entity instanceof Player && !world.isClientSide) {
			Player player = (Player) entity;
			if (!itemStack.hasTag()) {
				itemStack.setTag(new CompoundTag());
				itemStack.getTag().putString("data", data);
			}
		}
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.MISC;
	}
}
