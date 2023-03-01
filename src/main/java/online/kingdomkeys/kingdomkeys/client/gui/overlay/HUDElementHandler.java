package online.kingdomkeys.kingdomkeys.client.gui.overlay;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to initialise and render all the HUD elements
 */
public class HUDElementHandler extends OverlayBase {

    private List<HUDElement> elements = new ArrayList<>();

    private CommandMenuHUDElement CommandMenu;
    private HPBarHUDElement HPBar;

    public HUDElementHandler() {
        init();
    }

    protected void init() {
        elements.clear();
        elements.add(CommandMenu = new CommandMenuHUDElement(0, 0, 0, 0, HUDAnchorPosition.BOTTOM_LEFT, "Command Menu"));
        elements.add(HPBar = new HPBarHUDElement(0, 0, 256, 256, HUDAnchorPosition.CENTER, "HP Bar"));
        elements.forEach(HUDElement::initElement);
        elements.forEach(HUDElement::anchorElement);
    }

    @SubscribeEvent
    public void onRenderOverlayPost(RenderGuiOverlayEvent.Post event) {

    }

    @Override
    public void render(ForgeGui gui, PoseStack poseStack, float partialTick, int width, int height) {
        super.render(gui, poseStack, partialTick, width, height);
        elements.forEach(HUDElement::anchorElement);
        elements.forEach(element -> element.render(poseStack, partialTick));
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) 
        	return;
        elements.forEach(HUDElement::tick);
    }

}
