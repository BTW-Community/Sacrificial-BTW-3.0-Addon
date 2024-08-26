package net.fabricmc.example.mixin;

import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.src.BiomeDecorator;

import java.util.Random;

@Mixin(BiomeDecorator.class)
public class BiomeGenBaseMixin {
	//@Inject(at = @At("INVOKE"), method = "<init>", remap = false)
	//private void generate(World par1World, Random par2Random, int par3, int par4) {
	//	System.out.println("This line is printed by an example mod mixin!");
	//}
}
