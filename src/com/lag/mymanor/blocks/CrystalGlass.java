package com.lag.mymanor.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.lag.mymanor.help.ECrystalNames;
import com.lag.mymanor.help.Reference;
import com.lag.mymanor.init.MBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrystalGlass extends MyManorBlock{

	public CrystalGlass(String name) {
		super(name, Material.glass);
		setStepSound(soundTypeGlass);
		setHardness(1.5f);
		setResistance(1.5F);
	}
	public static final String[] names = new String[]{ECrystalNames.AIR.toString(), ECrystalNames.DARKNESS.toString(), ECrystalNames.EARTH.toString(), ECrystalNames.FIRE.toString(), ECrystalNames.LIGHT.toString(), ECrystalNames.WATER.toString()};
	
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
	public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderBlockPass()
    {
        return 1;
    }
	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side){
		
		Block block = blockAccess.getBlock(x, y, z);

        if (this == MBlocks.crystalGlassLow || this == MBlocks.crystalGlassNormal || this == MBlocks.crystalGlassHigh)
        {
            if (blockAccess.getBlockMetadata(x, y, z) != blockAccess.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return block == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}
}
