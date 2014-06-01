package com.lag.mymanor.magic.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.Reference;
import com.lag.mymanor.core.blocks.MyManorBlockContainer;
import com.lag.mymanor.core.util.GuiHelper;
import com.lag.mymanor.magic.tileentities.TileEntity_CrystalCraftingTable;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, MyManor.instance, GuiHelper.guiID_Crystal_crafting_table, world, x, y, z);
		}
        return true;
    }
}
