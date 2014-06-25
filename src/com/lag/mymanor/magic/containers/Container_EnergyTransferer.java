package com.lag.mymanor.magic.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.core.guis.slots.Slot_EnergyCrystal;
import com.lag.mymanor.core.guis.slots.Slot_Upgrade;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyTransferer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Container_EnergyTransferer extends Container{
	
	private Tileentity_MagicEnergyTransferer tileentity;
	
	private int lastEnergyStored;
	
	public Container_EnergyTransferer(InventoryPlayer inventoryPlayer, Tileentity_MagicEnergyTransferer tileentity){
		this.tileentity = tileentity;
		
		//container inventory
		this.addSlotToContainer(new Slot_EnergyCrystal(tileentity, 0, 56 + 0, 22 + 0));
		
		this.addSlotToContainer(new Slot_Upgrade(tileentity, 1, 128, 8));
		this.addSlotToContainer(new Slot_Upgrade(tileentity, 2, 128, 32));
		this.addSlotToContainer(new Slot_Upgrade(tileentity, 3, 128, 56));
		
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
	
	@Override
	public void addCraftingToCrafters (ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		
		icrafting.sendProgressBarUpdate(this, 0, this.tileentity.getStoredEnergy());
	}
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastEnergyStored != this.tileentity.getStoredEnergy()){
				icrafting.sendProgressBarUpdate(this, 0, this.tileentity.getStoredEnergy());
			}
			
			this.lastEnergyStored = this.tileentity.getStoredEnergy();
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileentity.setStoreEnergy(par2);
		}
	}
	
	@Override //INFO: resi chybu s Shift + Click - zakazuje ho TODO: napsat transfer Stack
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		return null;
	}
}
