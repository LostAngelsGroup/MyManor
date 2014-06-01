package com.lag.mymanor.magic.containers;

import com.lag.mymanor.core.guis.slots.Slot_EnergyCrystal;
import com.lag.mymanor.core.guis.slots.Slot_Upgrade;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_EnergyGenerator extends Container{
	
	private Tileentity_MagicEnergyGenerator tileentity;
	
	public Container_EnergyGenerator(InventoryPlayer inventoryPlayer, Tileentity_MagicEnergyGenerator tileentity){
		this.tileentity = tileentity;
		
		//container inventory
		this.addSlotToContainer(new Slot_EnergyCrystal(tileentity, 0, 74, 12));
		
		this.addSlotToContainer(new Slot_Upgrade(tileentity, 1, 38, 50));
		this.addSlotToContainer(new Slot_Upgrade(tileentity, 2, 74, 50));
		this.addSlotToContainer(new Slot_Upgrade(tileentity, 3, 110, 50));
		
		//player invetory
		//hotbar
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
		//inventory
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileentity.isUseableByPlayer(player);
	}
	
	@Override //INFO: resi chybu s Shift + Click - zakazuje ho TODO: napsat transfer Stack
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		return null;
	}
}
