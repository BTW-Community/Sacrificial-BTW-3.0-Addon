package net.fabricmc.example.blocks;

import btw.item.BTWItems;
import net.minecraft.src.Item;
import net.minecraft.src.*;

import java.util.Random;

public class CrudeSacrificial extends Block {
	private int cooldown;
	private boolean onCooldown;

	public CrudeSacrificial(int id, Material material) {
		super(id, material);

		this.setUnlocalizedName("nmCrudeSacrificial");
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public int idDropped(int iMetaData, Random random, int iFortuneModifier) {
		return 666+3;
	}

	@Override
	public float getExplosionResistance(Entity entity, World world, int i, int j, int k)
	{
		return 9999;
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if (par5Entity.isItemEntity()) {
			if (onCooldown) {
				++cooldown;
				if (cooldown >= 60) {
					onCooldown = false;
					cooldown = 0;
				}
			}

			if (!((EntityItem) par5Entity).getEntityName().equals("item.item.fcItemMysteryMeatRaw") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.porkchopRaw") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.beefRaw") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.chickenRaw") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.fcItemMuttonRaw") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.fcItemRawCheval") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.fishRaw") &&
					!((EntityItem) par5Entity).getEntityName().equals("item.item.fcItemWolfChopRaw")
			) {
				return;
			}
			if (onCooldown)
				return;

			onCooldown = true;

			if (par5Entity instanceof EntityItem item)
			{
				var stack = item.getEntityItem();

				for(int i = 1; i <= stack.stackSize; ++i)
				{
					dropLoot(par1World, par2, par3, par4, par5Entity);
				}

				par5Entity.setFire(100);
				par1World.removeEntity(par5Entity);
			}

		}
	}
	private void dropLoot(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (((EntityItem) par5Entity).getEntityName().equals("item.item.fcItemMysteryMeatRaw"))
			dropItemsIndividually(par1World, par2, par3, par4, BTWItems.soulUrn.itemID, 1, 0, 1);

		var rand = par5Entity.rand;

		// Chance to drop rare items
		if (rand.nextInt(1, 100) == 1) {
			var random = rand.nextInt(1, 3);
			if (random == 1)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.plateBreastplate.itemID, 1, 100, 1);
			if (random == 2)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.corpseEye.itemID, 1, 0, 1);
		} else if (rand.nextInt(1, 20) == 1) {
			var random = rand.nextInt(1, 5);

			if (random == 1)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.diamondIngot.itemID, 1, 0, 1);
			if (random == 2)
				dropItemsIndividually(par1World, par2, par3, par4, Item.plateDiamond.itemID, 1, 670, 1);
			if (random == 3)
				dropItemsIndividually(par1World, par2, par3, par4, Item.swordIron.itemID, 1, 450, 1);
			if (random == 4)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.gimpHelmet.itemID, 1, 250, 1);

		} else {
			var random = rand.nextInt(1, 6);

			if (random == 1)
				dropItemsIndividually(par1World, par2, par3, par4, Item.ingotIron.itemID, 1, 0, 1);

			if (random == 2)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.curedMeat.itemID, 2, 0, 1);

			if (random == 3)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.ironNugget.itemID, 2, 0, 1);

			if (random == 4)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.boneClub.itemID, 1, 0, 1);

			if (random == 5)
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.bowDrill.itemID, 1, 0, 1);
		}
	}
}
