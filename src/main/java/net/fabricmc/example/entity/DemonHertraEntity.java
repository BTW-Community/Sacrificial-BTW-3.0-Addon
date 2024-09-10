package net.fabricmc.example.entity;

import btw.entity.mob.behavior.SimpleWanderBehavior;
import btw.item.BTWItems;
import net.fabricmc.example.items.AttackTome;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.*;

public class DemonHertraEntity extends EntityMob {
	private IEntitySelector targetEntitySelector;
	private final float moveSpeed = 0.2f;

	public DemonHertraEntity(World world)
	{
		super(world);

		this.setSize(1, 2.5f);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 2.0, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (IEntitySelector)null, false));
		this.tasks.addTask(2, new SimpleWanderBehavior(this, moveSpeed));
	}

	protected void dropFewItems(boolean bKilledByPlayer, int iLootingLevel) {
		super.dropFewItems(bKilledByPlayer, iLootingLevel);
		this.dropItem(777, this.rand.nextInt(1, 3));
		this.dropItem(BTWItems.soulforgedSteelIngot.itemID, 1);
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(moveSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(200);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(7.0);
	}

	public boolean isAIEnabled(){ return true; }

	public String getLivingSound() {return "mob.ghast.scream"; }
	public String getHurtSound() {return "mob.ghast.fireball"; }
	public String getDeathSound() {return "mob.ghast.scream"; }
}
