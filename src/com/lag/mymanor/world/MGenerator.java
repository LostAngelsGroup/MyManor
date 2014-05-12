package com.lag.mymanor.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.lag.mymanor.init.MBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class MGenerator implements IWorldGenerator{

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId){
			case 0:{
				generateOverworld(random, chunkX*16, chunkZ*16, world);
				break;
			}
            case 1:{
            	generateEnd(random, chunkX*16, chunkZ*16, world);
            	break;
            }
            case -1:{
            	generateNether(random, chunkX*16, chunkZ*16, world);
            	break;
            }
            default:;
			}
		}
	//nether generator
	private void generateNether(Random random, int chunkX, int chunkZ, World world) {
		
		
	}
	//end generator
	private void generateEnd(Random random, int chunkX, int chunkZ, World world) {
		
		
	}
	//overworld
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
		for(int i = 0; i <6; i++){
			//oreCrystal
			spawnOre(MBlocks.oreCrystal, i, world, random, chunkX, chunkZ, 3, 6, 10, 60);
			//oreCrystalLage
			spawnOre(MBlocks.oreCrystalLarge, i, world, random, chunkX, chunkZ, 2, 5, 10, 60);
		}
		for(int i = 0; i < 4; i++){
			spawnOre(MBlocks.ore, i, world, random, chunkX, chunkZ, 2, 3, 20, 80);
		}
	}
	
	public void spawnOre(Block block, int meta, World world, Random random, int chunkX, int chunkZ, int minVainSize, int maxVainSize, int minY, int maxY){
		int posX = chunkX + random.nextInt(16);
		int posY = minY + random.nextInt(maxY - minY);
		int posZ = chunkZ + random.nextInt(16);
		int vainSize = minVainSize + random.nextInt(maxVainSize - minVainSize);
		new WorldGenMinable(block, meta, vainSize, Blocks.stone).generate(world, random, posX, posY, posZ);
	}
}
