package net.fabricmc.example.blocks;

import btw.item.BTWItems;
import net.fabricmc.example.entity.DemonHertraEntity;
import net.minecraft.src.*;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.EntityDragon;

import java.util.Random;

public class DemonicCircle extends Block {
	private DemonicCircleModel model = new DemonicCircleModel();

	public DemonicCircle(int id, Material material) {
		super(id, material);

		this.setUnlocalizedName("nmDemonicCircle");

		this.initBlockBounds(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
	}

	public boolean isOpaqueCube() { return false; }

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 5;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public int idDropped(int iMetaData, Random random, int iFortuneModifier) {
		return this.blockID;
	}

	@Override
	public float getExplosionResistance(Entity entity, World world, int i, int j, int k)
	{
		return 0;
	}



	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		var heldItem = par5EntityPlayer.getHeldItem();
		if (heldItem.itemID != Item.porkRaw.itemID &&
				heldItem.itemID != Item.beefRaw.itemID
		) {
			return false;
		}

		par1World.playSound(par2, par3, par4, "mob.ghast.scream", 1, 1);
		par1World.spawnParticle("hugeexplosion", par2, par3, par4, 0.0, 0.0, 0.0);

		if (heldItem.itemID == Item.porkRaw.itemID)
		{
			var demon = new DemonHertraEntity(par1World);
			par1World.spawnEntityInWorld(demon);
			demon.setLocationAndAngles(par2, par3 + 4, par4, 0, 0);
		}

		--heldItem.stackSize;

		return true;
	}

	public boolean renderBlock(RenderBlocks renderer, int x, int y, int z)
	{
		return model.makeTemporaryCopy().renderAsBlock(renderer, this, x, y, z);
	}
}
