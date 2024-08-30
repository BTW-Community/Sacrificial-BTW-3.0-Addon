package net.fabricmc.example;

import btw.block.BTWBlocks;
import btw.block.util.Flammability;
import btw.item.BTWItems;
import net.minecraft.src.*;
import net.minecraft.src.BlockSapling;

import java.util.Random;

public class BloodBush extends Block {
    public boolean hasBerries;
	public float berryTimer;

	private Icon NoBerries;
	private Icon Berries;

	public BloodBush(int id, Material material) {
		super(id, material);

		this.setUnlocalizedName("nmBloodBush");
		this.setFireProperties(Flammability.LEAVES);
		this.setStepSound(BTWBlocks.leavesStepSound);
		this.setTickRandomly(true);
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public int idDropped(int iMetaData, Random random, int iFortuneModifier) {
		return 666+4;
	}

	public boolean isOpaqueCube(){
		return false;
	}

	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer){
		if (par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);

			dropItemsIndividually(par1World, par2, par3, par4, 671, 1, 0, 1);
		}
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);

			par1World.markBlockForRenderUpdate(par2, par3, par4);
		}
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		NoBerries = par1IconRegister.registerIcon("nmBloodBush");
		Berries = par1IconRegister.registerIcon("nmBloodBushBerries");
	}

	public Icon getBlockTexture(IBlockAccess blockAccess, int i, int j, int k, int iSide)
	{
		if (blockAccess.getBlockMetadata(i, j, k) == 1)
		{
			return Berries;
		}
		else
		{
			return NoBerries;
		}
	}
}
