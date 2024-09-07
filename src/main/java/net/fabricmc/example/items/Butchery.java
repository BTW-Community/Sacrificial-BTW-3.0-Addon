package net.fabricmc.example.items;

import net.minecraft.src.*;

public class Butchery extends ItemSword {
	public Butchery(int id, EnumToolMaterial material)
	{
		super(id, material);

		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setCreativeTab(CreativeTabs.tabCombat);

		this.setUnlocalizedName("nmButchery");
	}
}
