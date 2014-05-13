package com.lag.mymanor.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CrystalSandGen extends WorldGenerator{

	private Block block;
	private int meta;
	
	public CrystalSandGen(Block block, int meta){
		this.block = block;
		this.meta = meta;
	}
	@Override
	public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
		if (var1.getBlock(var3, var4, var5) == Blocks.sand && var1.getBlock(var3, var4 + 1, var5) == Blocks.air){
			var1.setBlock(var3 - 1, var4, var5, block, meta, 0);
			var1.setBlock(var3 + 1, var4, var5, block, meta, 0);
			var1.setBlock(var3, var4, var5, block, meta, 0);
			var1.setBlock(var3, var4, var5 - 1, block, meta, 0);
			var1.setBlock(var3, var4, var5 + 1, block, meta, 0);
			var1.setBlock(var3, var4 - 1, var5, block, meta, 0);
		}
		return false;
	}

}
