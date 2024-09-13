package net.fabricmc.example.items;

import btw.item.BTWItems;
import com.google.common.collect.Multimap;
import net.minecraft.src.*;

public class SacrificialKnife extends Item {
	public int itemId;
	private int weaponDamage = 50;

	public SacrificialKnife(int id)
	{
		super(id);

		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxDamage(1300);
		this.maxStackSize = 1;

		itemId = id;
		this.setUnlocalizedName("nmSacrificialKnife");
	}

	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		if (itemRand.nextInt(0, 50) == 1)
		{
			par2EntityLivingBase.entityDropItem(new ItemStack(BTWItems.rawMysteryMeat), 1);

		}

		par1ItemStack.damageItem(1, par3EntityLivingBase);

		return true;
	}

	public Multimap getItemAttributeModifiers() {
		Multimap var1 = super.getItemAttributeModifiers();
		var1.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
		return var1;
	}
}
