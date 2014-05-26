package com.lag.mymanor.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lag.mymanor.magic.containers.Container_CrystalCraftingTable;
import com.lag.mymanor.magic.guis.Gui_CrystalCraftingTable;
import com.lag.mymanor.magic.tileentities.TileEntity_CrystalCraftingTable;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
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