package net.fabricmc.example.entity;

import btw.entity.mob.behavior.SimpleWanderBehavior;
import btw.item.BTWItems;
import net.minecraft.src.*;

public class DeaconHarmaEntity extends EntityMob {
	private final float moveSpeed = 0.175f;
	private int arrowCooldown;
	private int arrowMaxCooldown = 80;
	private EntityLivingBase target = null;

	public DeaconHarmaEntity(World world)
	{
		super(world);

		this.setSize(2f, 4f);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new SimpleWanderBehavior(this, moveSpeed));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 2.0, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (IEntitySelector)null, false));

	}

	public void onLivingUpdate() {
		super.onLivingUpdate();

		this.target = this.worldObj.getClosestVulnerablePlayerToEntity(this, 60);

		if (this.target == null)
			return;

		for (var i = 0f; i <= 2f; ++i)
		{
			--arrowCooldown;
			if (arrowCooldown <= 0)
			{
				arrowCooldown = arrowMaxCooldown;

				var arrow = new EntityArrow(this.worldObj, this, this.target, 3f, 12f);
				arrow.setFire(60);
				this.worldObj.spawnEntityInWorld(arrow);
				arrow.playSound("mob.ghast.fireball", 1, 1);
			}
		}
	}

	protected void dropFewItems(boolean bKilledByPlayer, int iLootingLevel) {
		super.dropFewItems(bKilledByPlayer, iLootingLevel);
		this.dropItem(668, 1);
		this.dropItem(777, 3);
		this.dropItem(778, 3);
		this.dropItem(BTWItems.soulforgedSteelIngot.itemID, 3);
		this.dropItem(BTWItems.padding.itemID, 2);
		this.dropItem(BTWItems.leatherStrap.itemID, 4);

	}

		public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(moveSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(400);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(7.0);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(200.0);
	}

	public boolean isAIEnabled(){ return true; }

	public String getLivingSound() {return "mob.ghast.scream"; }
	public String getHurtSound() {return "mob.ghast.fireball"; }
	public String getDeathSound() {return "mob.ghast.scream"; }
}
