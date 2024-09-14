// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.5.2
// Paste this class into your mod and call render() in your Entity Render class
// Note: You may need to adjust the y values of the 'setRotationPoint's

package net.fabricmc.example.entity;

import net.minecraft.src.*;

public class DemonSkelbryModel extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;

	public DemonSkelbryModel() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.bb_main.setTextureOffset(0, 18).addBox(-2.0F, -12.5F, -1.0F, 4, 11, 4, 0.0F);
		this.bb_main.setTextureOffset(0, 0).addBox(-4.0F, -21.5F, -3.0F, 8, 11, 7, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, -23.5F, -2.0F);
		bb_main.addChild(cube_r1);
		setRotation(cube_r1, -0.2146F, -0.3529F, -0.2011F);
		this.cube_r1.setTextureOffset(16, 18).addBox(-3.0F, -2.0F, -1.0F, 5, 5, 5, 0.0F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-3.0F, -23.5F, -1.0F);
		bb_main.addChild(cube_r2);
		setRotation(cube_r2, -0.6001F, 0.3568F, -0.1244F);
		this.cube_r2.setTextureOffset(16, 18).addBox(-3.0F, -2.0F, -1.0F, 5, 5, 5, 0.0F);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -15.5F, -5.0F);
		bb_main.addChild(cube_r3);
		setRotation(cube_r3, -0.0381F, 0.1704F, -0.2214F);
		this.cube_r3.setTextureOffset(16, 18).addBox(-3.0F, -2.0F, -1.0F, 5, 5, 5, 0.0F);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(5.0F, -22.5F, -4.0F);
		bb_main.addChild(cube_r4);
		setRotation(cube_r4, 0.0F, 0.1309F, 0.0F);
		this.cube_r4.setTextureOffset(18, 37).addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(4.0F, -22.5F, 3.0F);
		bb_main.addChild(cube_r5);
		setRotation(cube_r5, 0.0F, -0.1309F, 0.0F);
		this.cube_r5.setTextureOffset(9, 28).addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-4.0F, -22.5F, 3.0F);
		bb_main.addChild(cube_r6);
		setRotation(cube_r6, 0.0F, 0.1309F, 0.0F);
		this.cube_r6.setTextureOffset(27, 28).addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-5.0F, -22.5F, -4.0F);
		bb_main.addChild(cube_r7);
		setRotation(cube_r7, 0.0F, -0.1309F, 0.0F);
		this.cube_r7.setTextureOffset(34, 37).addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(5.0F, -19.5F, -3.0F);
		bb_main.addChild(cube_r8);
		setRotation(cube_r8, 0.0F, 0.1309F, 0.0F);
		this.cube_r8.setTextureOffset(38, 27).addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(4.0F, -19.5F, 4.0F);
		bb_main.addChild(cube_r9);
		setRotation(cube_r9, 0.0F, -0.1309F, 0.0F);
		this.cube_r9.setTextureOffset(30, 0).addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-4.0F, -19.5F, 4.0F);
		bb_main.addChild(cube_r10);
		setRotation(cube_r10, 0.0F, 0.1309F, 0.0F);
		this.cube_r10.setTextureOffset(30, 9).addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-5.0F, -19.5F, -3.0F);
		bb_main.addChild(cube_r11);
		setRotation(cube_r11, 0.0F, -0.1309F, 0.0F);
		this.cube_r11.setTextureOffset(42, 3).addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-5.0F, -16.5F, -2.0F);
		bb_main.addChild(cube_r12);
		setRotation(cube_r12, 0.0F, -0.1309F, 0.0F);
		this.cube_r12.setTextureOffset(44, 35).addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-4.0F, -16.5F, 5.0F);
		bb_main.addChild(cube_r13);
		setRotation(cube_r13, 0.0F, 0.1309F, 0.0F);
		this.cube_r13.setTextureOffset(36, 18).addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(5.0F, -16.5F, -2.0F);
		bb_main.addChild(cube_r14);
		setRotation(cube_r14, 0.0F, 0.1309F, 0.0F);
		this.cube_r14.setTextureOffset(44, 43).addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(4.0F, -16.5F, 5.0F);
		bb_main.addChild(cube_r15);
		setRotation(cube_r15, 0.0F, -0.1309F, 0.0F);
		this.cube_r15.setTextureOffset(0, 37).addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bb_main.render(f5);
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, f and f1 are used for animating the movement of arms
	 * and legs, where f represents the time(so that arms and legs swing back and forth) and f1 represents how
	 * "far" arms and legs can swing at most.
	 */
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

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