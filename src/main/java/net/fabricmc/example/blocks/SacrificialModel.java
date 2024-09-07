package net.fabricmc.example.blocks;

import btw.block.model.BlockModel;
import btw.block.model.AnvilModel;
import net.minecraft.src.*;

import java.util.Random;

public class SacrificialModel extends BlockModel {
	public void SacrificialModel()
	{

	}

	public void initModel()
	{
		this.addBox(0, 0, 0, 1, 0.6, 1);
		this.addBox(0, 0.7, 0, 1, 1, 1);
		this.addBox(0.1, 0.6, 0.1, 0.9, 0.7, 0.9);
	}

}
