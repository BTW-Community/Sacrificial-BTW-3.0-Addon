package net.fabricmc.example.entity;

import btw.entity.mob.behavior.SimpleWanderBehavior;
import btw.entity.mob.DireWolfEntity;
import net.minecraft.src.*;

public class DemonHertraEntity extends EntityMob {
	private IEntitySelector targetEntitySelector;
	private final float moveSpeed = 1;
	private final float maxHealth = 1000;

	public DemonHertraEntity(World world)
	{
		super(world);

		this.tasks.addTask(0, new SimpleWanderBehavior(this, moveSpeed));
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(moveSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(maxHealth);
	}

	public boolean isAIEnabled(){ return true; }

	public String getLivingSound() {return "mob.ghast.fireball"; }
	public String getHurtSound() {return "mob.ghast.fireball"; }
	public String getDeathSound() {return "mob.ghast.fireball"; }
}
