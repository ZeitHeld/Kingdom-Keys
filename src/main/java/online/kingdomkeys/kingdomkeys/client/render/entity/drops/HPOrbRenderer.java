package online.kingdomkeys.kingdomkeys.client.render.entity.drops;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.entity.EntityHPOrb;
import online.kingdomkeys.kingdomkeys.entity.EntityItemDrop;

public class HPOrbRenderer extends EntityItemDropRenderer {
	
	public static final Factory FACTORY = new HPOrbRenderer.Factory();

	public HPOrbRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	@Override
	public ResourceLocation getEntityTexture(EntityItemDrop entity) {
		this.texture = new ResourceLocation(KingdomKeys.MODID + ":textures/entity/hp_orb.png"); 
		return texture;
	}
	
			

	public static class Factory implements IRenderFactory<EntityHPOrb> {
		@Override
		public EntityRenderer<? super EntityHPOrb> createRenderFor(EntityRendererManager entityRendererManager) {
			return new HPOrbRenderer(entityRendererManager);
		}
	}
}
