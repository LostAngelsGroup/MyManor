package com.lag.mymanor.magic.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.lag.mymanor.MyManorCreativeTabs;
import com.lag.mymanor.Reference;
import com.lag.mymanor.core.blocks.MyManorBlockContainer;
import com.lag.mymanor.core.interfaces.IInfo;
import com.lag.mymanor.magic.init.MBlocks;
import com.lag.mymanor.magic.tileentities.Tileentity_NatureBattery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Block_NatureBattery extends MyManorBlockContainer implements IInfo{
	public Block_NatureBattery(String name) {
		super(name, Material.anvil);
		setHardness(10F);
		setResistance(10F);
		setHarvestLevel("pickaxe", 3);
		
		setCreativeTab(MyManorCreativeTabs.tabMyManorBlocks);
	}
	
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side){
		Tileentity_NatureBattery tileentity = (Tileentity_NatureBattery) iBlockAccess.getTileEntity(x, y, z);
		return icons[tileentity.getTexture()];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister iconRegister){
		icons = new IIcon[10];
		for(int i = 0; i < icons.length; i++){
			iconRegister.registerIcon(Reference.MODID + ":magic/natureBattery/" + this.getUnlocalizedName().substring(5) + i);
		}
	}
	
	@Override
	public int quantityDropped(Random rand){
        return 1;
    }
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
        return Item.getItemFromBlock(MBlocks.block_natureBattery_depleated);
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new Tileentity_NatureBattery();
	}
	
	/*IInfo*/
	public String getInfo() {
		String ret = getUnlocalizedName().substring(5);
		return ret;
	}
	
}
