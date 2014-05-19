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
		generateNextLayer(world, rand, x, y, z, rand.nextInt(4));
		return true;
	}
	
	public void generateNextLayer(World world, Random rand, int x, int y, int z, int direction){
		if(ammount > 0 && world.getBlock(x, y, z) == Blocks.stone){
			switch(direction){
			case 0:
				switch(rand.nextInt(3)){
					case 0: 
						world.setBlock(x + 1, y, z, block);
						break;
					case 1:
						world.setBlock(x, y, z, block);
						break;
					case 2:
						world.setBlock(x, y, z + 1, block);
						break;
				}
				break;
			case 1:
				switch(rand.nextInt(3)){
					case 0: 
						world.setBlock(x - 1, y, z, block);
						break;
					case 1:
						world.setBlock(x, y, z, block);
						break;
					case 2:
						world.setBlock(x, y, z + 1, block);
						break;
				}
			break;
			case 2:
				switch(rand.nextInt(3)){
					case 0: 
						world.setBlock(x - 1, y, z, block);
						break;
					case 1:
						world.setBlock(x, y, z, block);
						break;
					case 2:
						world.setBlock(x, y, z - 1, block);
						break;
				}
				break;
			case 3:
				switch(rand.nextInt(3)){
					case 0: 
						world.setBlock(x + 1, y, z, block);
						break;
					case 1:
						world.setBlock(x, y, z, block);
						break;
					case 2:
						world.setBlock(x, y, z - 1, block);
						break;
				}
				break;
			default:
				world.setBlock(x, y, z, block);
				break;
			}

			ammount--;
			
			switch(direction){
			case 0: generateNextLayer(world, rand, x - 1, y + 1, z - 1, direction);
			case 1: generateNextLayer(world, rand, x + 1, y + 1, z - 1, direction);
			case 2: generateNextLayer(world, rand, x + 1, y + 1, z + 1, direction);
			case 3: generateNextLayer(world, rand, x - 1, y + 1, z + 1, direction);
			default: generateNextLayer(world, rand, x, y + 1, z, direction);
			}
		}
	}
	
}
