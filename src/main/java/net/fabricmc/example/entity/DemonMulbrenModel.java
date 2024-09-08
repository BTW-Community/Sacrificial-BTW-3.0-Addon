// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.5.2
// Paste this class into your mod and call render() in your Entity Render class
// Note: You may need to adjust the y values of the 'setRotationPoint's

package net.fabricmc.example.entity;

import net.minecraft.src.*;

public class DemonMulbrenModel extends ModelBase {
	private final ModelRenderer jaw;
	private final ModelRenderer torso;
	private final ModelRenderer head;

	public DemonMulbrenModel() {
		textureWidth = 128;
		textureHeight = 128;

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(0.0F, 19.0F, -9.0F);
		this.jaw.setTextureOffset(24, 41).addBox(-4.0F, -7.0F, -10.0F, 8, 4, 6, 0.0F);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 19.0F, -6.0F);
		this.torso.setTextureOffset(0, 0).addBox(-6.0F, -13.0F, 1.0F, 12, 13, 5, 0.0F);
		this.torso.setTextureOffset(0, 30).addBox(-5.0F, -12.0F, 6.0F, 10, 12, 5, 0.0F);
		this.torso.setTextureOffset(34, 0).addBox(-4.0F, -11.0F, 11.0F, 8, 10, 5, 0.0F);
		this.torso.setTextureOffset(46, 45).addBox(-3.0F, -10.0F, 16.0F, 6, 8, 6, 0.0F);
		this.torso.setTextureOffset(0, 47).addBox(-2.0F, -8.0F, 22.0F, 4, 4, 7, 0.0F);
		this.torso.setTextureOffset(54, 17).addBox(-1.0F, -7.0F, 29.0F, 2, 2, 7, 0.0F);
		this.torso.setTextureOffset(22, 51).addBox(-4.0F, -9.0F, -2.0F, 8, 4, 3, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 13.0F, -7.8F);
		this.head.setTextureOffset(30, 30).addBox(-5.0F, -1.0F, -5.2F, 10, 5, 6, 0.0F);
		this.head.setTextureOffset(31, 15).addBox(-5.0F, -5.0F, -12.2F, 10, 4, 5, 0.0F);
		this.head.setTextureOffset(0, 18).addBox(-6.0F, -6.0F, -7.2F, 12, 5, 7, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		jaw.render(f5);
		torso.render(f5);
		head.render(f5);
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, f and f1 are used for animating the movement of arms
	 * and legs, where f represents the time(so that arms and legs swing back and forth) and f1 represents how
	 * "far" arms and legs can swing at most.
	 */
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		jaw.rotateAngleX = f * f1 * 0.0025f;
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