package com.lag.mymanor.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.lag.mymanor.help.ECrystalNames;
import com.lag.mymanor.help.Reference;
import com.lag.mymanor.init.MBlocks;
import com.lag.mymanor.init.MItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrystalOre extends MyManorBlock{

	public CrystalOre(String name) {
		super(name, Material.rock);
		setStepSound(soundTypeStone);
		setHardness(2.0F);
		setResistance(3.0F);
	}
	public static final String[] names = new String[]{ECrystalNames.AIR.toString(),ECrystalNames.DARKNESS.toString(), ECrystalNames.EARTH.toString(), ECrystalNames.FIRE.toString(), ECrystalNames.LIGHT.toString(), ECrystalNames.WATER.toString()};
	
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta){
		if(meta < 0 || meta > icons.length)
			return icons[0];
		else
			return icons[meta];
	}
	
	@Override
	public int damageDropped(int p_149692_1_){
        return p_149692_1_;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_){
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 4));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 5));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister iconRegister){
		icons = new IIcon[names.length];
		for(int i = 0; i < icons.length; i++){
			icons[i] = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + i);
		}
    }
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
		return MItems.crystalRaw;
    }
	@Override
	public int quantityDropped(Random rand){
        return 4 + rand.nextInt(3);
    }
	@Override
	public int quantityDroppedWithBonus(int p_149679_1_, Random rand){
        return this.quantityDropped(rand) + rand.nextInt(p_149679_1_ + 1);
    }
	@Override
	protected ItemStack createStackedBlock(int metadata){
        return new ItemStack(MBlocks.oreCrystal, 0, metadata);
    }
}
