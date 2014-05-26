package com.lag.mymanor.core.util;

import com.lag.mymanor.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, Reference.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	public static void registerBlock(Block block, Class <? extends ItemBlock> itemclass){
		GameRegistry.registerBlock(block, itemclass, Reference.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, Reference.MODID + "_" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerTileEntity(String name, Class <?extends TileEntity> tileEntityClass){
		GameRegistry.registerTileEntity(tileEntityClass, Reference.MODID + "_" + name);
	}
}
