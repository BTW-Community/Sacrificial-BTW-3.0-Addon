package net.fabricmc.example.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class KnowledgeTome extends Item {
	public KnowledgeTome(int id)
	{
		super(id);

		this.setCreativeTab(CreativeTabs.tabMisc);

		this.setUnlocalizedName("nmKnowledgeTome");
	}
}
