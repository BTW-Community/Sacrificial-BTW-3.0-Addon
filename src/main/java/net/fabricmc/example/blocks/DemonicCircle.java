package net.fabricmc.example.blocks;

import btw.item.BTWItems;
import net.fabricmc.example.entity.DemonHertraEntity;
import net.fabricmc.example.entity.DemonMulbrenEntity;
import net.fabricmc.example.entity.DemonPandaEntity;
import net.minecraft.src.*;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.EntityDragon;

import java.util.Random;

public class DemonicCircle extends Block {
	private DemonicCircleModel model = new DemonicCircleModel();

	private Icon Fed;
	private Icon Unfed;

	public DemonicCircle(int id, Material material) {
		super(id, material);

		this.setUnlocalizedName("nmDemonicCircle");

		this.initBlockBounds(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
		this.setTickRandomly(true);
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
		return 0;
	}

	public int tickRate(World par1World) {
		return 1;
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		var metadata = par1World.getBlockMetadata(par2, par3, par4);
		if (metadata == 1)
		{
			var demon = new DemonHertraEntity(par1World);
			par1World.spawnEntityInWorld(demon);
			demon.setLocationAndAngles(par2, par3 + 2, par4, 0, 0);

			par1World.playSound(par2, par3, par4, "mob.ghast.scream", 2, 1);
			par1World.spawnParticle("hugeexplosion", par2, par3, par4, 0.0, 0.0, 0.0);
		}
		else if (metadata == 2)
		{

			var demon = new DemonPandaEntity(par1World);
			par1World.spawnEntityInWorld(demon);
			demon.setLocationAndAngles(par2, par3 + 2, par4, 0, 0);

			par1World.playSound(par2, par3, par4, "mob.ghast.scream", 2, 1);
			par1World.spawnParticle("hugeexplosion", par2, par3, par4, 0.0, 0.0, 0.0);
		}
		else if (metadata == 3)
		{

			var demon = new DemonMulbrenEntity(par1World);
			par1World.spawnEntityInWorld(demon);
			demon.setLocationAndAngles(par2, par3 + 2, par4, 0, 0);

			par1World.playSound(par2, par3, par4, "mob.ghast.scream", 2, 1);
			par1World.spawnParticle("hugeexplosion", par2, par3, par4, 0.0, 0.0, 0.0);
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
	}

	@Override
	public float getExplosionResistance(Entity entity, World world, int i, int j, int k)
	{
		return 0;
	}



	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.getBlockMetadata(par2, par3, par4) == 1)
			return false;

		var heldItem = par5EntityPlayer.getHeldItem();
		if (heldItem.itemID != Item.porkRaw.itemID &&
				heldItem.itemID != Item.beefRaw.itemID &&
				heldItem.itemID != BTWItems.rawMutton.itemID
		) {
			return false;
		}

		par1World.playSound(par2, par3, par4, "mob.ghast.scream", 1, 1);
		par1World.spawnParticle("hugeexplosion", par2, par3, par4, 0.0, 0.0, 0.0);

		if (heldItem.itemID == Item.porkRaw.itemID)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
		}
		if (heldItem.itemID == Item.beefRaw.itemID)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
		}
		if (heldItem.itemID == BTWItems.rawMutton.itemID)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
		}

		--heldItem.stackSize;

		return true;
	}

	public boolean renderBlock(RenderBlocks renderer, int x, int y, int z)
	{
		return model.makeTemporaryCopy().renderAsBlock(renderer, this, x, y, z);
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		Fed = par1IconRegister.registerIcon("nmDemonicCircleFed");
		Unfed = par1IconRegister.registerIcon("nmDemonicCircle");
	}

	public Icon getBlockTexture(IBlockAccess blockAccess, int i, int j, int k, int iSide)
	{
		if (blockAccess.getBlockMetadata(i, j, k) != 0)
		{
			return Fed;
		}
		else
		{
			return Unfed;
		}
	}
}
