package com.lag.mymanor.technic.init;

import com.lag.mymanor.core.util.RegisterHelper;
import com.lag.mymanor.technic.blocks.Ore;
import com.lag.mymanor.technic.blocks.ConnectedGlass;
import com.lag.mymanor.technic.itemBlocks.ItemBlock_Ore;
import com.lag.mymanor.technic.tileentities.Tileentity_ConnectedGlass;

import net.minecraft.block.Block;

public class TBlocks {
	
	public static Block ore;
	
	public static Block connectedGlass;
	
	public static void initTechnicBlocks(){
		
		ore = new Ore("ore");
		RegisterHelper.registerBlock(ore, ItemBlock_Ore.class);
		
		connectedGlass = new ConnectedGlass("s_glass");
		RegisterHelper.registerBlock(connectedGlass);
		
	}
	
	public static void initTechnicTileentities(){
		RegisterHelper.registerTileEntity("s_glass", Tileentity_ConnectedGlass.class);
	}
	
}
