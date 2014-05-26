package com.lag.mymanor.magic.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.lag.mymanor.core.blocks.MyManorBlock;
import com.lag.mymanor.magic.init.MItems;

public class MagicFuelOre extends MyManorBlock{

	public MagicFuelOre(String name) {
		super(name, Material.rock);
		setStepSound(soundTypeStone);
		setHardness(2.0F);
		setResistance(2.0F);
		setHarvestLevel("pickaxe", 1);
	}

	@Override
	public int quantityDropped(Random rand){
        return 1 + rand.nextInt(2);
    }
	
	@Override
	public int quantityDroppedWithBonus(int p_149679_1_, Random rand){
        return this.quantityDropped(rand) + rand.nextInt(p_149679_1_ + 1);
    }
	
	@Override
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata){
        return true;
    }
	
	@Override
	public boolean canDropFromExplosion(Explosion explosion){
        return false;
    }
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
		world.createExplosion(null, x, y, z, 2.0F, true);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
		return MItems.magicFuel;
    }
}
