package com.lag.mymanor.magic.containers;

import com.lag.mymanor.core.guis.slots.Slot_EnergyCrystal;
import com.lag.mymanor.core.guis.slots.Slot_Upgrade;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyGenerator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_EnergyGenerator extends Container{
	
	private Tileentity_MagicEnergyGenerator tileentity;
	
	private int lastEnergyStored;
	
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
	
	@Override
	public void addCraftingToCrafters (ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		
		icrafting.sendProgressBarUpdate(this, 0, this.tileentity.getEnergyStored());
	}
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastEnergyStored != this.tileentity.getEnergyStored()){
				icrafting.sendProgressBarUpdate(this, 0, this.tileentity.getEnergyStored());
			}
			
			this.lastEnergyStored = this.tileentity.getEnergyStored();
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileentity.setEnergyStored(par2);
		}
	}
	
	@Override //INFO: resi chybu s Shift + Click - zakazuje ho TODO: napsat transfer Stack
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		return null;
	}
}
