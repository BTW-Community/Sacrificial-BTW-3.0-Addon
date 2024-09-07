package net.fabricmc.example.items;

import net.minecraft.src.*;

public class HealTome extends Item {
	public HealTome(int id)
	{
		super(id);

		this.setMaxDamage(10);
		this.setCreativeTab(CreativeTabs.tabCombat);

		this.setUnlocalizedName("nmHealTome");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.addPotionEffect(new PotionEffect(6, 1));
		player.playSound("mob.ghast.fireball", 1, 1);
		stack.damageItem(1, player);

		return stack;
	}
}
