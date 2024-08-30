package net.fabricmc.example;

import btw.item.items.PlaceAsBlockItem;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

import java.util.Random;

public class BloodBushItem extends PlaceAsBlockItem {
	public BloodBushItem(int id, int blockId)
	{
		super(id, blockId);

		this.setCreativeTab(CreativeTabs.tabMisc);

		this.setUnlocalizedName("nmBloodBush");
	}
}
