package com.lag.mymanor.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lag.mymanor.MyManorCreativeTabs;

public class MyManorBlockContainer extends BlockContainer{
	public MyManorBlockContainer(String name, Material material){
		super(material);
		setBlockName(name);
		setCreativeTab(MyManorCreativeTabs.tabMyManorBlocks);
	}

	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
}
