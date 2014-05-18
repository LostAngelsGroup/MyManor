package com.lag.mymanor.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MagicFuelGen extends WorldGenerator{

	private Block block;
	private int ammount;
	
	public MagicFuelGen(Block block, int ammount){
		this.block = block;
		this.ammount = ammount;
	}
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		generateNext(world, rand, x, y, z);
		return true;
	}
	public void generateNext(World world, Random rand, int x, int y, int z){
		if(ammount > 0 && world.getBlock(x, y, z) == Blocks.stone){
			world.setBlock(x, y, z, block);
			ammount--;
			
			switch(rand.nextInt(8)){
			case 0: generateNext(world, rand, x - 1, y + 1, z - 1);
			case 1: generateNext(world, rand, x, y + 1, z - 1);
			case 2: generateNext(world, rand, x + 1, y + 1, z - 1);
			case 3: generateNext(world, rand, x - 1, y + 1, z);
			case 4: generateNext(world, rand, x + 1, y + 1, z);
			case 5: generateNext(world, rand, x - 1, y + 1, z + 1);
			case 6: generateNext(world, rand, x, y + 1, z + 1);
			case 7: generateNext(world, rand, x + 1, y + 1, z + 1);
			}
			
		}
		return;
	}
}
