package net.fabricmc.example.items;

import btw.item.items.PlaceAsBlockItem;
import net.minecraft.src.CreativeTabs;

public class BloodBushItem extends PlaceAsBlockItem {
	public BloodBushItem(int id, int blockId)
	{
		super(id, blockId);

		this.setCreativeTab(CreativeTabs.tabMisc);

		this.setUnlocalizedName("nmBloodBush");
	}
}
