package net.fabricmc.example.entity;

import btw.entity.mob.behavior.AnimalFleeBehavior;
import btw.entity.mob.behavior.SimpleWanderBehavior;
import net.minecraft.src.*;

public class DemonPandaEntity extends EntityMob {
	private IEntitySelector targetEntitySelector;
	private final float moveSpeed = 0.05f;

	public DemonPandaEntity(World world)
	{
		super(world);

		this.setSize(1, 2.5f);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new SimpleWanderBehavior(this, moveSpeed));
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(moveSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(50);
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(7.0);
	}

	public boolean isAIEnabled(){ return true; }

	public String getLivingSound() {return "mob.ghast.scream"; }
	public String getHurtSound() {return "mob.ghast.fireball"; }
	public String getDeathSound() {return "mob.ghast.scream"; }
}
