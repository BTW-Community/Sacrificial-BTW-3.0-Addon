package net.fabricmc.example;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemFood;

public class BloodBerries extends ItemFood {
	public BloodBerries(int id, int i2, float i3, boolean i4)
	{
		super(id, i2, i3, i4);

		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName("nmBloodBerries");
	}
}
