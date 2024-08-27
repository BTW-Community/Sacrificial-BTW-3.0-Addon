package net.fabricmc.example;

import btw.item.BTWItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.*;

import java.util.Random;

public class Sacrificial extends Block {
	private int cooldown;
	private boolean onCooldown;

	public Sacrificial(int id, Material material)
	{
		super(id, material);

		this.setUnlocalizedName("nmSacrificial");
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if (par5Entity.isItemEntity())
		{
			if (onCooldown)
			{
				++cooldown;
				if (cooldown >= 60)
				{
					onCooldown = false;
					cooldown = 0;
				}
			}

			if (!((EntityItem)par5Entity).getEntityName().equals("item.item.fcItemMysteryMeatRaw") &&
					!((EntityItem)par5Entity).getEntityName().equals("item.item.porkchopRaw") &&
					!((EntityItem)par5Entity).getEntityName().equals("item.item.beefRaw") &&
					!((EntityItem)par5Entity).getEntityName().equals("item.item.chickenRaw") &&
					!((EntityItem)par5Entity).getEntityName().equals("item.item.fcItemMuttonRaw") &&
					!((EntityItem)par5Entity).getEntityName().equals("item.item.fcItemRawCheval") &&
					!((EntityItem)par5Entity).getEntityName().equals("item.item.fcItemWolfChopRaw")
			)
			{
				return;
			}
			if (onCooldown)
				return;

			onCooldown = true;

			par5Entity.setFire(100);
			System.out.println("Sacrifice has been made!");
			System.out.println(((EntityItem)par5Entity).getEntityName());

			if (((EntityItem)par5Entity).getEntityName().equals("item.item.fcItemMysteryMeatRaw"))
				dropItemsIndividually(par1World, par2, par3, par4, BTWItems.soulUrn.itemID, 1, 0, 1);

			dropItemsIndividually(par1World, par2, par3, par4, BTWItems.soulUrn.itemID, 1, 0, 1);
		}
	}

}
