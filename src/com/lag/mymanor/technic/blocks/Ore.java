package com.lag.mymanor.technic.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.lag.mymanor.Reference;
import com.lag.mymanor.core.blocks.MyManorBlock;
import com.lag.mymanor.magic.init.MBlocks;
import com.lag.mymanor.technic.utils.EOreNames;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Ore extends MyManorBlock{

	public Ore(String name) {
		super(name, Material.rock);
		setStepSound(soundTypeStone);
		setHardness(3.0F);
		setResistance(5.0F);
	}
	public static final String[] names = new String[]{EOreNames.COPPER.toString(), EOreNames.LEAD.toString(), EOreNames.SILVER.toString(), EOreNames.TIN.toString()};
	
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
	protected ItemStack createStackedBlock(int p_149644_1_){
        return new ItemStack(MBlocks.oreCrystal, 0, p_149644_1_);
    }
}
