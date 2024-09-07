package net.fabricmc.example.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemFood;

public class PermafreshBlood extends ItemFood {
	public PermafreshBlood(int id, int i2, float i3, boolean i4)
	{
		super(id, i2, i3, i4);

		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("nmPermafreshBlood");
	}
}
