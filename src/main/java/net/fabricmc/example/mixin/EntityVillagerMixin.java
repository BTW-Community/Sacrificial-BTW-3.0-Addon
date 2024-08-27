package net.fabricmc.example.mixin;

import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityVillager.class)
public abstract class EntityVillagerMixin extends EntityLivingBase {
	@Shadow(remap = false)
	public abstract int getCurrentTradeXP();

	@Shadow(remap = false)
	public abstract void setTradeExperience(int amount);

	public EntityVillagerMixin(World world)
	{
		super(world);
	}
	@Inject(at = @At("TAIL"), method = "useRecipe")
	private void useRecipe(MerchantRecipe recipe, CallbackInfo info) {
        int currentXP = this.getCurrentTradeXP();
        ++currentXP;
		this.setTradeExperience(currentXP);
	}
}
