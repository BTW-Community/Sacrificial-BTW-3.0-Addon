// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.5.2
// Paste this class into your mod and call render() in your Entity Render class
// Note: You may need to adjust the y values of the 'setRotationPoint's

package net.fabricmc.example.entity;

import net.minecraft.src.*;


public class DeaconHarmaModel extends ModelBase {
	private final ModelRenderer torso;
	private final ModelRenderer cube_r1;
	private final ModelRenderer head;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public DeaconHarmaModel() {
		textureWidth = 256;
		textureHeight = 256;

		torso = new ModelRenderer(this);
		torso.setRotationPoint(-13.0F, -10.0F, -7.0F);
		this.torso.setTextureOffset(72, 0).addBox(10.0F, 3.0F, 0.0F, 6, 8, 8, 0.0F);
		this.torso.setTextureOffset(0, 128).addBox(6.0F, 3.0F, 15.0F, 14, 30, 5, 0.0F);
		this.torso.setTextureOffset(64, 39).addBox(0.0F, 3.0F, -6.0F, 6, 30, 26, 0.0F);
		this.torso.setTextureOffset(0, 39).addBox(20.0F, 3.0F, -6.0F, 6, 30, 26, 0.0F);
		this.torso.setTextureOffset(0, 0).addBox(1.0F, -12.0F, -5.0F, 24, 15, 24, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		torso.addChild(cube_r1);
		setRotation(cube_r1, 0.5236F, 0.0F, 0.0F);
		this.cube_r1.setTextureOffset(38, 39).addBox(5.0F, -9.0F, -13.0F, 16, 11, 10, 0.0F);
		this.cube_r1.setTextureOffset(72, 95).addBox(-2.0F, -8.0F, -12.0F, 7, 10, 24, 0.0F);
		this.cube_r1.setTextureOffset(96, 0).addBox(21.0F, -8.0F, -12.0F, 7, 10, 24, 0.0F);
		this.cube_r1.setTextureOffset(102, 34).addBox(12.0F, -10.0F, -14.0F, 2, 13, 12, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(-6.0F, -36.8F, 0.0F);
		this.head.setTextureOffset(0, 95).addBox(-3.0F, -0.2F, -9.0F, 18, 15, 18, 0.0F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(cube_r2);
		setRotation(cube_r2, 0.0F, 0.0F, -0.2618F);
		this.cube_r2.setTextureOffset(54, 95).addBox(-3.0F, -8.0F, -8.0F, 5, 10, 5, 0.0F);
		this.cube_r2.setTextureOffset(74, 95).addBox(-3.0F, -8.0F, 3.0F, 5, 10, 5, 0.0F);
		this.cube_r2.setTextureOffset(100, 0).addBox(-3.0F, -8.0F, -2.0F, 5, 10, 4, 0.0F);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(12.0F, 0.0F, -12.0F);
		head.addChild(cube_r3);
		setRotation(cube_r3, 0.0F, 0.0F, 0.2618F);
		this.cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -8.0F, 15.0F, 5, 10, 5, 0.0F);
		this.cube_r3.setTextureOffset(0, 95).addBox(-2.0F, -8.0F, 10.0F, 5, 10, 4, 0.0F);
		this.cube_r3.setTextureOffset(0, 39).addBox(-2.0F, -8.0F, 4.0F, 5, 10, 5, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
		head.rotateAngleX = f3 / 57;
		head.rotateAngleY = f4 / 57;
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