package com.lag.mymanor.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.lag.mymanor.MyManor;

public class MyManorBlock extends Block{
	public MyManorBlock(String name, Material material){
		super(material);
		setBlockName(name);
		setCreativeTab(MyManor.tabMyManorBlocks);
	}
}
