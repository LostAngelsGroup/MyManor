package com.lag.mymanor.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.lag.mymanor.help.ConfigHandler;
import com.lag.mymanor.init.MBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class MGenerator implements IWorldGenerator{

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
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
		for(int i = 0; i < 6; i++){
			//oreCrystal
			spawnOre(MBlocks.oreCrystal, i, world, random, chunkX, chunkZ, 18, 3, 6, 10, 80);
			//oreCrystalLage
			spawnOre(MBlocks.oreCrystalLarge, i, world, random, chunkX, chunkZ, 15, 2, 5, 10, 80);
		}
		for(int i = 0; i < 4; i++){
			spawnOre(MBlocks.ore, i, world, random, chunkX, chunkZ, 20, 2, 3, 20, 100);
		}
		for(int i = 0; i < 6; i++){
			if(ConfigHandler.SAND_AND_GLASS_HIGH_VALUE) spawnCrystalSand(MBlocks.crystalSandHigh, i, world, random, chunkX, chunkZ, 1, 50, 80);
			if(ConfigHandler.SAND_AND_GLASS_NORMAL_VALUE) spawnCrystalSand(MBlocks.crystalSandNormal, i, world, random, chunkX, chunkZ, 3, 50, 80);
			if(ConfigHandler.SAND_AND_GLASS_LOW_VALUE) spawnCrystalSand(MBlocks.crystalSandLow, i, world, random, chunkX, chunkZ, 5, 50, 80);
		}
		spawnMagicFuel(MBlocks.magicFuel, world, random, chunkX, chunkZ, 10, 20, 80);
	}
	public void spawnCrystalSand(Block block, int meta, World world, Random random, int chunkX, int chunkZ, int interations, int minY, int maxY){
		for(int i = 0; i < interations; i++){
			int posX = chunkX + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = chunkZ + random.nextInt(16);
			new CrystalSandGen(block, meta).generate(world, random, posX, posY, posZ);
		}
	}
	
	public void spawnOre(Block block, int meta, World world, Random random, int chunkX, int chunkZ, int interations, int minVainSize, int maxVainSize, int minY, int maxY){
		//interations = kolikrát se generátor pokusí generovat na 1 chunku
		for(int i = 0; i < interations; i++){
			int posX = chunkX + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = chunkZ + random.nextInt(16);
			int vainSize = minVainSize + random.nextInt(maxVainSize - minVainSize);
			new WorldGenMinable(block, meta, vainSize, Blocks.stone).generate(world, random, posX, posY, posZ);
		}
	}
	public void spawnMagicFuel(Block block, World world, Random random, int chunkX, int chunkZ, int interations, int minY, int maxY){
		for(int i = 0; i < interations; i++){
			int posX = chunkX + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = chunkZ + random.nextInt(16);
			int ammount = random.nextInt(6);
			new MagicFuelGen(block, ammount).generate(world, random, posX, posY, posZ);
		}
	}
}
