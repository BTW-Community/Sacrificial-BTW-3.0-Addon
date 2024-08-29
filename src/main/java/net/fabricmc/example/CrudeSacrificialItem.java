package net.fabricmc.example;

import btw.item.items.PlaceAsBlockItem;
import net.minecraft.src.CreativeTabs;

public class CrudeSacrificialItem extends PlaceAsBlockItem {
	public CrudeSacrificialItem(int id, int blockId)
	{
		super(id, blockId);

		this.setCreativeTab(CreativeTabs.tabMisc);

		this.setUnlocalizedName("nmCrudeSacrificial");
	}
}
