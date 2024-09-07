package net.fabricmc.example.items;

import btw.item.BTWItems;
import net.minecraft.src.*;

public class SacrificialKnife extends ItemSword {
	public int itemId;

	public SacrificialKnife(int id, EnumToolMaterial material)
	{
		super(id, material);

		this.setCreativeTab(CreativeTabs.tabCombat);

		itemId = id;
		this.setUnlocalizedName("nmSacrificialKnife");
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {


		par2EntityLivingBase.entityDropItem(new ItemStack(BTWItems.soulDust), 0);
		return true;
	}
}
