package net.fabricmc.example.render;

import btw.entity.model.DireWolfModel;
import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.ResourceLocation;

public class DemonHertraRenderer extends RenderLiving {
	private static final ResourceLocation WOLF_DIRE_TEXTURES = new ResourceLocation("btw:textures/entity/mob/wolf/beast.png");

	public DemonHertraRenderer(ModelBase model, ModelBase renderPassModel) {
		super(model, 1F);
		this.setRenderPassModel(model);
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return WOLF_DIRE_TEXTURES;
	}

}
