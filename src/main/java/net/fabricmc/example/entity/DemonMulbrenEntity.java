package net.fabricmc.example.entity;

import btw.entity.mob.behavior.SimpleWanderBehavior;
import net.minecraft.src.*;
import net.minecraft.src.EntityZombie;

public class DemonMulbrenEntity extends EntityMob {
	private IEntitySelector targetEntitySelector;
	private final float moveSpeed = 0.2f;

	public DemonMulbrenEntity(World world)
	{
		super(world);

		this.setSize(1.5f, 1f);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new SimpleWanderBehavior(this, moveSpeed));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 2.0, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (IEntitySelector)null, false));

	}

	public int getDropItemId() {
		return 778;
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(moveSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(250);
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(7.0);
	}

	public boolean isAIEnabled(){ return true; }

	public String getLivingSound() {return "mob.ghast.scream"; }
	public String getHurtSound() {return "mob.ghast.fireball"; }
	public String getDeathSound() {return "mob.ghast.scream"; }
}
