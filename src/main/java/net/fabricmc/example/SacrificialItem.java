package net.fabricmc.example;

import btw.item.items.PlaceAsBlockItem;
import net.minecraft.src.*;

public class SacrificialItem extends PlaceAsBlockItem {
	public SacrificialItem(int id, int blockId)
	{
		super(id, blockId);

		this.setCreativeTab(CreativeTabs.tabMisc);
		//this.setAssociatedBlockID(666);

		this.setUnlocalizedName("nmSacrificial");
	}
}
