package net.fabricmc.example.render;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.ResourceLocation;

public class DemonSkelbryRenderer extends RenderLiving {
	private static final ResourceLocation TEXTURES = new ResourceLocation("minecraft:textures/entity/deaconSkelbry.png");

	public DemonSkelbryRenderer(ModelBase model, ModelBase renderPassModel) {
		super(model, 1F);
		this.setRenderPassModel(model);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return TEXTURES;
	}

}
