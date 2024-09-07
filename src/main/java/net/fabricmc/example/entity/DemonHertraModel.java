package net.fabricmc.example.entity;

import btw.entity.mob.behavior.SimpleWanderBehavior;
import btw.entity.model.DireWolfModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;

@Environment(EnvType.CLIENT)
public class DemonHertraModel extends ModelBase {

	public ModelRenderer modelBody;

	public DemonHertraModel()
	{
		super();
		this.modelBody = new ModelRenderer(this, 0, 0);
		this.modelBody.addBox(1, 1, 1, 7, 7, 7);
	}

	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		this.modelBody.render(7);
	}
}
