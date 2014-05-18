package com.lag.mymanor.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.lag.mymanor.help.Reference;
import com.lag.mymanor.init.MBlocks;
import com.lag.mymanor.tileentities.TileEntity_S_ConnectedGlass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class S_ConnectedGlass extends MyManorBlockContainer{

	public S_ConnectedGlass(String name) {
		super(name, Material.glass);
		setStepSound(soundTypeGlass);
		setHardness(1.5F);
		setResistance(1.5F);
	}
	
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side){
		TileEntity_S_ConnectedGlass s_glass = (TileEntity_S_ConnectedGlass)iBlockAccess.getTileEntity(x, y, z);
		
		switch(side){
		case 0:
			return icons[s_glass.getTextureID(0)];
		
		case 1: 
			return icons[s_glass.getTextureID(0)];
		case 2:
			return icons[s_glass.getTextureID(1)]; //nevim jestli 1 nebo 2
		case 3:
			return icons[s_glass.getTextureID(1)]; //-||-
		case 4:
			return icons[s_glass.getTextureID(2)]; //-||-
		case 5:
			return icons[s_glass.getTextureID(2)]; //-||-
		}
		return icons[s_glass.getTextureID(side)];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister iconRegister){
		icons = new IIcon[46];
		for(int i = 0; i < icons.length; i++){
			icons[i] = iconRegister.registerIcon(Reference.MODID + ":/s_glass/" + getUnlocalizedName().substring(5) + i);
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

        if (this == MBlocks.connectedTextureGlass)
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
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntity_S_ConnectedGlass();
	}
}
