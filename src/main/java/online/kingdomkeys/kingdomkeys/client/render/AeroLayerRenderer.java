package online.kingdomkeys.kingdomkeys.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.config.ModConfigs;
import online.kingdomkeys.kingdomkeys.driveform.DriveForm;
import online.kingdomkeys.kingdomkeys.driveform.ModDriveForms;

@OnlyIn(Dist.CLIENT)
public class AeroLayerRenderer<T extends LivingEntity> extends RenderLayer<T, PlayerModel<T>> {
	   public static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/trident_riptide.png");
	   public static final String BOX = "box";
	   private final ModelPart box;

	public AeroLayerRenderer(RenderLayerParent<T, PlayerModel<T>> p_174540_, EntityModelSet p_174541_) {
	      super(p_174540_);
	      ModelPart modelpart = p_174541_.bakeLayer(ModelLayers.PLAYER_SPIN_ATTACK);
	      this.box = modelpart.getChild("box");
	   }

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if(ModCapabilities.getPlayer((Player) entitylivingbaseIn) != null) {
			IPlayerCapabilities playerData = ModCapabilities.getPlayer((Player) entitylivingbaseIn);
			if(playerData.getAeroTicks() > 0) {
				VertexConsumer vertexconsumer = bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));

		         for(int i = 1; i <= playerData.getAeroLevel() + 1; ++i) {
		        	matrixStackIn.pushPose();
		            float f = ageInTicks*20;
		            if(i %2 == 0)
		            	f*=-1;
		            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f));
		            float scale = 1;
		            switch(playerData.getAeroLevel()) {
		            case 0:
		            	scale = 0.75F*i;
			            matrixStackIn.scale(scale,scale*1.2F,scale);
			            matrixStackIn.translate(0.0D, (double)(-0.4F + 0.8F * (float)i), 0.0D);

		            	break;
		            case 1:
		            	scale = 0.85F*i;
			            matrixStackIn.scale(scale,scale*1F,scale);
			            matrixStackIn.translate(0.0D, (double)(-0.8F + 0.8F * (float)i), 0.0D);

		            	break;
		            case 2:
		            	scale = 0.7F*i;
			            matrixStackIn.scale(scale,scale*0.6F,scale);
			            matrixStackIn.translate(0.0D, (double)(-1.2F + 0.6F * (float)i), 0.0D);

		            	break;
		            	
		            }
		            
		            this.box.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
		            matrixStackIn.popPose();
		         }
			}
		}
	}
}
