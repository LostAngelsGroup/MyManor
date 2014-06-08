package com.lag.mymanor.magic.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.lag.mymanor.core.interfaces.IInfo;
import com.lag.mymanor.magic.interfaces.IMagicEnergyStorage;

public class Tileentity_MagicEnergyTransferer extends TileEntity implements IInfo, IInventory, IMagicEnergyStorage{
	
	private static final int RANGE_BASE = 10;
	private static final int NUMBER_OF_CONNECTIONS_BASE = 5;
	private static final int MAX_ENERGY_STORAGE_BASE = 800;
	private static final int TRANSFER_RATE = 200;
	private static final boolean EXTRACT_ENERGY_BASE = false;
	private static final int EXTRACT_ENERGY_SPEED_BASE = 200;
	
	
	private int range;
	private int numberOfConnections;
	private int maxEnergyStorage;
	private int energyStored;
	private int transferRate;
	private boolean extractEnergy;
	private int extractEnergySpeed;
	
	private ItemStack slots[] = new ItemStack[4];
	
	public Tileentity_MagicEnergyTransferer(){
		range = RANGE_BASE;
		numberOfConnections = NUMBER_OF_CONNECTIONS_BASE;
		maxEnergyStorage = MAX_ENERGY_STORAGE_BASE;
		transferRate = TRANSFER_RATE;
		extractEnergy = EXTRACT_ENERGY_BASE;
		extractEnergySpeed = EXTRACT_ENERGY_SPEED_BASE;
	}
	
	
	/**IInventory*/
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ItemStack getStackInSlot(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemStack decrStackSize(int var1, int var2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setInventorySlotContents(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		
	}

	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isUseableByPlayer(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}

	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		return false;
	}
	/**IInfo*/
	public String getInfo() {
		String str = energyStored + ";" + maxEnergyStorage;
		return str;
	}
	/**IMagicEnergyStorage*/
	public int receiveEnergy(int maxReceive, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int extractEnergy(int maxExtract, boolean simulate) {
		if(energyStored >= maxExtract){
			if(!simulate){
				this.energyStored -= maxExtract;
				return maxExtract;
			}
			return maxExtract;
		}
		int temp = energyStored;
		this.energyStored = 0;
		return temp;
	}

	public int getEnergyStored() {
		return energyStored;
	}

	public int getMaxEnergyStored() {
		return maxEnergyStorage;
	}
}
