package com.lag.mymanor.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.help.Reference;
import com.lag.mymanor.tileEntities.TileEntity_CrystalCraftingTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrystalCraftingTable extends MyManorBlockContainer{

	public CrystalCraftingTable(String name) {
		super(name, Material.wood);
		setStepSound(soundTypeWood);
		setHardness(2.0F);
		setResistance(3.0F);
	}
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta){
		switch(side){
		case 0: return icons[0];
		case 1: return icons[1];
		case 2: return icons[2];
		default: return icons[3];
		}
	}
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister iconRegister){
		icons = new IIcon[4];
		icons[0] = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_bottom");
		icons[1] = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_top");
		icons[2] = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_front");
		icons[3] = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_side");
    }
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntity_CrystalCraftingTable();
	}
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		//server side only
		if(!p_149727_1_.isRemote){
			p_149727_5_.openGui(MyManor.instance, 0, p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
		}
        return true;
    }
}
