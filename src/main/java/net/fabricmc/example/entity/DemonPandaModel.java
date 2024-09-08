// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.5.2
// Paste this class into your mod and call render() in your Entity Render class
// Note: You may need to adjust the y values of the 'setRotationPoint's
package net.fabricmc.example.entity;

import net.minecraft.src.*;

public class DemonPandaModel extends ModelBase {
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg2;
	private final ModelRenderer leg1;
	private final ModelRenderer body;
	private final ModelRenderer head;

	public DemonPandaModel() {
		textureWidth = 64;
		textureHeight = 64;

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-6.0F, 15.0F, 6.0F);
		this.leg3.setTextureOffset(0, 32).addBox(-1.0F, 0.0F, -2.0F, 3, 9, 4, 0.0F);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(6.0F, 15.0F, 6.0F);
		this.leg4.setTextureOffset(22, 31).addBox(-2.0F, 0.0F, -2.0F, 3, 9, 4, 0.0F);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(5.0F, 18.0F, -5.0F);
		this.leg2.setTextureOffset(36, 0).addBox(-1.0F, 0.0F, -2.0F, 3, 6, 4, 0.0F);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-5.0F, 18.0F, -5.0F);
		this.leg1.setTextureOffset(36, 31).addBox(-2.0F, 0.0F, -2.0F, 3, 6, 4, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -1.0F);
		this.body.setTextureOffset(0, 0).addBox(-6.0F, -10.0F, -2.0F, 12, 9, 12, 0.0F);
		this.body.setTextureOffset(0, 21).addBox(-5.0F, -9.0F, -5.0F, 10, 8, 3, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 19.0F, -7.0F);
		this.head.setTextureOffset(26, 21).addBox(-3.0F, -3.0F, -3.0F, 6, 6, 4, 0.0F);
		this.head.setTextureOffset(28, 21).addBox(-1.0F, 0.0F, -4.0F, 2, 2, 4, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leg3.render(f5);
		leg4.render(f5);
		leg2.render(f5);
		leg1.render(f5);
		body.render(f5);
		head.render(f5);
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, f and f1 are used for animating the movement of arms
	 * and legs, where f represents the time(so that arms and legs swing back and forth) and f1 represents how
	 * "far" arms and legs can swing at most.
	 */
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		leg1.rotateAngleX = f1 * f * 0.01f;
		leg2.rotateAngleX = -f1 * f * 0.01f;
		leg3.rotateAngleX = f1 * f * 0.01f;
		leg4.rotateAngleX = -f1 * f * 0.01f;
	}

	/**
	 *	Sets the rotation of a ModelRenderer. Only called if the ModelRenderer has a rotation
	 */
	public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}