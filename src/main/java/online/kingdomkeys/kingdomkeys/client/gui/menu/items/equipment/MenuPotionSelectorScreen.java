package online.kingdomkeys.kingdomkeys.client.gui.menu.items.equipment;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuBackground;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuBox;
import online.kingdomkeys.kingdomkeys.client.gui.elements.MenuColourBox;
import online.kingdomkeys.kingdomkeys.client.gui.elements.buttons.MenuButton;
import online.kingdomkeys.kingdomkeys.client.gui.elements.buttons.MenuSelectPotionButton;
import online.kingdomkeys.kingdomkeys.item.KKPotionItem;
import online.kingdomkeys.kingdomkeys.lib.Strings;
import online.kingdomkeys.kingdomkeys.util.Utils;

public class MenuPotionSelectorScreen extends MenuBackground {

	MenuBox keyblades, details;
    Button back;

	int buttonColour;
	Color colour;
	public int slot = -1;

	public Map<KKPotionItem,Integer> addedItemsList = new HashMap<KKPotionItem, Integer>();
	
	public MenuPotionSelectorScreen(int slot, Color colour, int buttonColour) {
		super(Strings.Gui_Menu_Items_Equipment_Weapon, new Color(0,0,255));
		drawSeparately = true;
		minecraft = Minecraft.getInstance();
		this.slot = slot;
		this.colour = colour;
		this.buttonColour = buttonColour;
	}	

	@Override
	public void init() {
		super.init();
        buttonWidth = ((float)width * 0.07F);
		float keybladesX = width * 0.2F;
		float keybladesY = height * 0.175F;
		float keybladesWidth = width * 0.35F;
		float keybladesHeight = height * 0.5972F;
		float detailsX = width * 0.55F;
		float detailsWidth = width * 0.2F;
		float listX = width * 0.21F;
		float listY = height * 0.2546F;


        addRenderableWidget(back = new MenuButton((int)buttonPosX, buttonPosY, (int)buttonWidth, Component.translatable(Strings.Gui_Menu_Back).getString(), MenuButton.ButtonType.BUTTON, false, b -> minecraft.setScreen(new MenuEquipmentScreen())));

		int itemHeight = 15;

		int pos = 0;
		IPlayerCapabilities playerData = ModCapabilities.getPlayer(minecraft.player);
		ItemStack equippedPotion = playerData.getEquippedItem(slot);
		//If the equipped item is an item get the translation key, otherwise ---
		String equippedPotionName = (equippedPotion != null && equippedPotion.getItem() instanceof KKPotionItem) ? ((KKPotionItem) equippedPotion.getItem()).getDescriptionId() : "---";
		
		//Adds the form current keychain (base too as it's DriveForm.NONE)
		addRenderableWidget(new MenuColourBox((int) listX, (int) listY + (itemHeight * (pos-1)), (int) (keybladesWidth - (listX - keybladesX)*2), Utils.translateToLocal(equippedPotionName),"", buttonColour));
		if(slot >= 0) {
			if(!ItemStack.matches(equippedPotion, ItemStack.EMPTY)) {
				if (minecraft.player.getInventory().getFreeSlot() > -1) {
					addRenderableWidget(new MenuSelectPotionButton(ItemStack.EMPTY, minecraft.player.getInventory().getFreeSlot(), (int) listX, (int) listY + (itemHeight * pos++), 150, this, buttonColour));
				}
			}
			
			for (int i = 0; i < minecraft.player.getInventory().getContainerSize(); i++) {
				if (!ItemStack.matches(minecraft.player.getInventory().getItem(i), ItemStack.EMPTY)) {
					if (minecraft.player.getInventory().getItem(i).getItem() instanceof KKPotionItem) {
						KKPotionItem item = (KKPotionItem) minecraft.player.getInventory().getItem(i).getItem();
						if(addedItemsList.containsKey(item)) {
							int amount = addedItemsList.get(item);
							addedItemsList.replace(item, amount+1);
						} else {
							addRenderableWidget(new MenuSelectPotionButton(minecraft.player.getInventory().getItem(i), i, (int) listX, (int) listY + (itemHeight * pos++), 150, this, buttonColour));
							addedItemsList.put((KKPotionItem) minecraft.player.getInventory().getItem(i).getItem(), 1);
						}
					}
				}
			}
		}
		keyblades = new MenuBox((int) keybladesX, (int) keybladesY, (int) keybladesWidth, (int) keybladesHeight, colour);
		details = new MenuBox((int) detailsX, (int) keybladesY, (int) detailsWidth, (int) keybladesHeight, colour);
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		drawMenuBackground(matrixStack, mouseX, mouseY, partialTicks);
		keyblades.draw(matrixStack);
		details.draw(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		RenderSystem.setShaderTexture(0, new ResourceLocation(KingdomKeys.MODID, "textures/gui/menu/menu_button.png"));
	}
}
