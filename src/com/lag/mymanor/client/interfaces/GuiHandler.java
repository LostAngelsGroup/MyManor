package com.lag.mymanor.client.interfaces;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.tileentities.TileEntity_CrystalCraftingTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	public GuiHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MyManor.instance, this); //registrace GUI handleru
	}
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID){
			case 0:{
				TileEntity tileentity = world.getTileEntity(x, y, z);
				if( tileentity != null && tileentity instanceof TileEntity_CrystalCraftingTable){
					return new Container_CrystalCraftingTable(player.inventory, (TileEntity_CrystalCraftingTable)tileentity);
				}
				break;
			}
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:{
				TileEntity tileentity = world.getTileEntity(x, y, z);
				if( tileentity != null && tileentity instanceof TileEntity_CrystalCraftingTable){
					return new Gui_CrystalCraftingTable(player.inventory, (TileEntity_CrystalCraftingTable)tileentity);
				}
				break;
			}
		}
		return null;
	}

}
//na strane serveru se vraci pouze container s daty a na strane clienta se vraci gui (ktere obshauje container s daty)