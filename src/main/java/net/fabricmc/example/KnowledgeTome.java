package net.fabricmc.example;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;

public class KnowledgeTome extends Item {
	public KnowledgeTome(int id)
	{
		super(id);

		this.setCreativeTab(CreativeTabs.tabMisc);

		this.setUnlocalizedName("nmKnowledgeTome");
	}
}
