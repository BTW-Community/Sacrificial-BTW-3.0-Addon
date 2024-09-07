package net.fabricmc.example.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class BloodBottle extends Item {
	public BloodBottle(int id)
	{
		super(id);

		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName("nmBottleOfBlood");
	}
}
