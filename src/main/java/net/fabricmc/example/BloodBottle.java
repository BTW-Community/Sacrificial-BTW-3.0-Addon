package net.fabricmc.example;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemGlassBottle;

public class BloodBottle extends Item {
	public BloodBottle(int id)
	{
		super(id);

		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName("nmBottleOfBlood");
	}
}
