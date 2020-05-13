package online.kingdomkeys.kingdomkeys.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ObjectHolder;
import online.kingdomkeys.kingdomkeys.KingdomKeys;

public class ContainerSynthesisBag extends Container {

	@ObjectHolder(KingdomKeys.MODID + ":synthesis_bag")
	public static ContainerType<ContainerSynthesisBag> TYPE;

	public static ContainerSynthesisBag fromNetwork(int windowId, PlayerInventory inv, PacketBuffer buf) {
		Hand hand = buf.readBoolean() ? Hand.MAIN_HAND : Hand.OFF_HAND;
		return new ContainerSynthesisBag(windowId, inv, inv.player.getHeldItem(hand));
	}
	
	private final ItemStack bag;

	public ContainerSynthesisBag(int windowId, PlayerInventory playerInv, ItemStack bag) {
		super(TYPE, windowId);
		int i;
		int j;

		this.bag = bag;
		IItemHandlerModifiable bagInv = (IItemHandlerModifiable) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);

		CompoundNBT nbt = playerInv.getCurrentItem().getOrCreateTag();
		int bagLevel = nbt.getInt("level");
		
		int invStart = 0;
				
		if(bagLevel == 1) {
			invStart = 2; 
		} else if(bagLevel == 2) {
			invStart = 4;
		}
		

		for (i = 0; i < 2*(bagLevel+1); ++i) {
			for (j = 0; j < 9; ++j) {
				int k = j + i * 9;
				addSlot(new SlotSynthesisBag(bagInv, k, 8 + j * 18,18+i * 18));
			}
		}

		for (i = 0; i < 3; ++i) {
			for (j = 0; j < 9; ++j) {
				addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 41 + 17 + (i+invStart) * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			addSlot(new Slot(playerInv, i, 8 + i * 18, 45 + 17 + (3+invStart) * 18));
		}

     }
    
    @Override
    public boolean canInteractWith (PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot (PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(itemStack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack1);
        }

        return itemStack;
    }

    @Override
    public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, PlayerEntity player) {
        if (slot >= 0 && getSlot(slot).getStack() == player.getHeldItem(Hand.MAIN_HAND)) return ItemStack.EMPTY;
        return super.slotClick(slot, dragType, clickTypeIn, player);
    }

    @Override
    protected boolean mergeItemStack (ItemStack stack, int start, int end, boolean backwards) {
        boolean flag1 = false;
        int k = (backwards ? end - 1 : start);
        Slot slot;
        ItemStack itemstack1;

        if (stack.isStackable()) while (stack.getCount() > 0 && (!backwards && k < end || backwards && k >= start)) {
            slot = inventorySlots.get(k);
            itemstack1 = slot.getStack();

            if (!slot.isItemValid(stack)) {
                k += (backwards ? -1 : 1);
                continue;
            }

            if (!ItemStack.areItemStacksEqual(itemstack1, ItemStack.EMPTY) && itemstack1.getItem() == stack.getItem()) {
                int l = itemstack1.getCount() + stack.getCount();

                if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
                    stack.setCount(0);
                    itemstack1.setCount(1);
                    flag1 = true;
                } else if (itemstack1.getCount() < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
                    stack.setCount(stack.getCount() - (stack.getMaxStackSize() - itemstack1.getCount()));
                    itemstack1.setCount(stack.getMaxStackSize());
                    flag1 = true;
                }
            }

            k += (backwards ? -1 : 1);
        }

        if (stack.getCount() > 0) {
            k = (backwards ? end - 1 : start);

            while (!backwards && k < end || backwards && k >= start) {
                slot = inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (!slot.isItemValid(stack)) {
                    k += (backwards ? -1 : 1);
                    continue;
                }

                if (ItemStack.areItemStacksEqual(itemstack1, ItemStack.EMPTY)) {
                    int l = stack.getCount();

                    if (l <= slot.getSlotStackLimit()) {
                        slot.putStack(stack.copy());
                        stack.setCount(0);
                        flag1 = true;
                        break;
                    } else {
                        putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit()));
                        stack.setCount(stack.getCount() - slot.getSlotStackLimit());
                        flag1 = true;
                    }
                }

                k += (backwards ? -1 : 1);
            }
        }

        return flag1;
    }
}