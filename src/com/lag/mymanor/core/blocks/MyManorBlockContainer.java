package com.lag.mymanor.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lag.mymanor.MyManorCreativeTabs;

public abstract class MyManorBlockContainer extends BlockContainer{
	public MyManorBlockContainer(String name, Material material){
		super(material);
		setBlockName(name);
		
		setCreativeTab(MyManorCreativeTabs.tabMyManorBlocks);
	}

	public TileEntity createNewTileEntity(World world, int var2) {
		return null;
	}
}
