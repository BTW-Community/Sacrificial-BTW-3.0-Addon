package net.fabricmc.example.mixin;

import net.fabricmc.example.entity.DemonHertraEntity;
import net.fabricmc.example.entity.DemonMulbrenEntity;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeGenHell.class)
public abstract class BiomeGenHellMixin {
	public BiomeGenHellMixin(int par1){
		super();
	}
	@Inject(at = @At("TAIL"), method = "<init>")
	public void BiomeGenHell(int par1, CallbackInfo callbackInfo)
	{
		BiomeGenHell hell = (BiomeGenHell)(Object)this;
		hell.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(DemonHertraEntity.class, 150, 1, 2));
		hell.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(DemonMulbrenEntity.class, 150, 1, 2));
	}
}
