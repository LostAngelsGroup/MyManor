package com.lag.mymanor.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lag.mymanor.core.util.GuiHelper;
import com.lag.mymanor.magic.containers.Container_CrystalCraftingTable;
import com.lag.mymanor.magic.containers.Container_EnergyGenerator;
import com.lag.mymanor.magic.containers.Container_EnergyTransferer;
import com.lag.mymanor.magic.guis.Gui_CrystalCraftingTable;
import com.lag.mymanor.magic.guis.Gui_EnergyGenerator;
import com.lag.mymanor.magic.guis.Gui_EnergyTransferer;
import com.lag.mymanor.magic.tileentities.TileEntity_CrystalCraftingTable;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyGenerator;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyTransferer;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity != null){
			switch (ID){
				case GuiHelper.guiID_Crystal_crafting_table:{
					if(tileentity instanceof TileEntity_CrystalCraftingTable){
						return new Container_CrystalCraftingTable(player.inventory, (TileEntity_CrystalCraftingTable)tileentity);
					}
					break;
				}
				case GuiHelper.guiID_Energy_generator:{
					if(tileentity instanceof Tileentity_MagicEnergyGenerator){
						return new Container_EnergyGenerator(player.inventory, (Tileentity_MagicEnergyGenerator)tileentity);
					}
					break;
				}
				case GuiHelper.guiID_Energy_transferer:{
					if(tileentity instanceof Tileentity_MagicEnergyTransferer){
						return new Container_EnergyTransferer(player.inventory, (Tileentity_MagicEnergyTransferer)tileentity);
					}
					break;
				}
				
			}
		}
		
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity != null){
			switch (ID) {
				case GuiHelper.guiID_Crystal_crafting_table:{
					if(tileentity instanceof TileEntity_CrystalCraftingTable){
						return new Gui_CrystalCraftingTable(player.inventory, (TileEntity_CrystalCraftingTable)tileentity);
					}
					break;
				}
				case GuiHelper.guiID_Energy_generator:{
					if(tileentity instanceof Tileentity_MagicEnergyGenerator){
						return new Gui_EnergyGenerator(player.inventory, (Tileentity_MagicEnergyGenerator)tileentity);
					}
					break;
				}
				case GuiHelper.guiID_Energy_transferer:{
					if(tileentity instanceof Tileentity_MagicEnergyTransferer){
						return new Gui_EnergyTransferer(player.inventory, (Tileentity_MagicEnergyTransferer)tileentity);
					}
					break;
				}
				
			}
		}
		
		return null;
	}

}
//na strane serveru se vraci pouze container s daty a na strane clienta se vraci gui (ktere obshauje container s daty)