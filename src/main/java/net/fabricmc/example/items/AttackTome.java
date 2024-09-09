package net.fabricmc.example.items;

import net.minecraft.src.*;

public class AttackTome extends Item {
	public AttackTome(int id)
	{
		super(id);

		this.setMaxDamage(20);
		this.setCreativeTab(CreativeTabs.tabCombat);

		this.setUnlocalizedName("nmAttackTome");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		var arrow = new EntityArrow(world, player, 3);
		arrow.setFire(60);
		world.spawnEntityInWorld(arrow);
		arrow.playSound("mob.ghast.fireball", 1, 1);
		stack.damageItem(1, player);

		return stack;
	}
}
