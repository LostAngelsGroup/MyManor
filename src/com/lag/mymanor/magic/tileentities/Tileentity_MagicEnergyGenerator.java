package com.lag.mymanor.magic.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.lag.mymanor.core.interfaces.IInfo;
import com.lag.mymanor.magic.init.MItems;
import com.lag.mymanor.magic.interfaces.IMagicEnergyStorage;
import com.lag.mymanor.magic.items.ItemHelper_Upgrade;
import com.lag.mymanor.magic.items.Item_EnergyCrystal;
import com.lag.mymanor.magic.items.Item_Upgrade;

public class Tileentity_MagicEnergyGenerator extends TileEntity implements IInfo, IInventory, IMagicEnergyStorage{

	private ItemStack[] slots = new ItemStack[4];
	
	private static final int MAX_ENERGY_STORED_BASE = 10000;
	private static final int RANGE_BASE = 5;
	private static final int EXTRACT_SPEED_BASE = 1;
	private static final int UPDATE_TIME_BASE = 250;
	
	private int energyStored;
	private int maxEnergyStored;
	
	private int range;
	private double extractSpeed;
	
	private int updateTime;
	
	public Tileentity_MagicEnergyGenerator(){
		energyStored = 0;
		maxEnergyStored = MAX_ENERGY_STORED_BASE;
		
		range = RANGE_BASE;
		extractSpeed = EXTRACT_SPEED_BASE;
		
		updateTime = UPDATE_TIME_BASE;
	}
	
	@Override
	public void updateEntity(){
		
		if(updateTime <= 0){
			System.out.println("It is update time");
			
			recalculateUpgrades();
			
			
			if (energyStored < maxEnergyStored && slots[0] != null){
				generateEnergy(true);
			}
			
			updateTime = 100;
		}else{
			if (energyStored < maxEnergyStored && slots[0] != null){
				generateEnergy(false);
			}
			updateTime--;
		}
		
	}
	
	private void recalculateUpgrades(){
		maxEnergyStored = MAX_ENERGY_STORED_BASE + getNumberOfUpgrades(MItems.upgrade_capacity) * ItemHelper_Upgrade.upgrade_capacity_energyGenerator;
		range = RANGE_BASE + getNumberOfUpgrades(MItems.upgrade_range) * ItemHelper_Upgrade.upgrade_range_energyGenerator;
		extractSpeed = EXTRACT_SPEED_BASE + getNumberOfUpgrades(MItems.upgrade_extract) * ItemHelper_Upgrade.upgrade_extract_energyGenerator;
		//TODO: add another if needed
	}
	
	private int getNumberOfUpgrades(Item upgrade){
		int ret = 0;
		
		for(int i = 0; i < getSizeInventory(); i++){
			if(slots[i] != null){
				ItemStack stack = getStackInSlot(i);
				
				System.out.println(stack.getItem().getUnlocalizedName().substring(5));
				
				if(stack.getItem() == upgrade){
					ret += stack.stackSize;
				}
			}
		}
		return ret;
	}
	
	private void generateEnergy(boolean needUpdate) {
		// TODO Auto-generated method stub
		if(slots[0].getItem() == MItems.energy_crystal_AIR){
			energyStored += 5;
			/*
			int height;
			int numberOfBlocksAround;
			
			if(needUpdate){
				height = this.yCoord;
				//numberOfBlocksAround = getBlocksAround(Blocks.air);
				
			}
			
			//do staff
			
			*/
		}else if(slots[0].getItem() == MItems.energy_crystal_WATER){
			
		}
		
	}
	
	public void setEnergyStored(int value){
		this.energyStored = value;
	}
	
	public int getEnergyStoredScaled(int value){
		return energyStored * value / maxEnergyStored;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", 10);
		
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");
			
			if(b >= 0 && b < this.slots.length){
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}

		this.energyStored = nbt.getInteger("EnergyStored");
		this.maxEnergyStored = nbt.getInteger("MaxEnergyStored");
		
		this.range = nbt.getInteger("Range");
		this.extractSpeed = nbt.getDouble("ExtractSpeed");
		
		this.updateTime = nbt.getInteger("UpdateTime");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		nbt.setInteger("EnergyStored", energyStored);
		nbt.setInteger("MaxEnergyStored", maxEnergyStored);
		
		nbt.setInteger("Range", range);
		nbt.setDouble("ExtractSpeed", extractSpeed);
		
		nbt.setInteger("UpdateTime", updateTime);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < slots.length; ++i){
			if(this.slots[i] != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("Items", list);
	}
	
	/*IInventory*/
	public int getSizeInventory() {
		return slots.length;
	}

	public ItemStack getStackInSlot(int slot) {
		return slots[slot];
	}

	public ItemStack decrStackSize(int slot, int ammount) {
		//nelze vyndat energy crystal
		if(slot == 0){
			return null;
		}
		
		if(this.slots[slot] != null){
			ItemStack stack;
			
			if(this.slots[slot].stackSize <= ammount){
				stack = this.slots[slot];
				
				this.slots[slot] = null;
				return stack;
			}else{
				stack = this.slots[slot].splitStack(ammount);
				
				if(this.slots[slot].stackSize == 0){
					this.slots[slot] = null;
				}
				return stack;
			}
		}
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.slots[slot] != null){
			ItemStack stack = this.slots[slot];
			this.slots[slot] = null;
			return stack;
		}
		return null;
	}

	//FIXME: zamkni vkladani do slotu 0 pokud jiz neco obsahuje
	public void setInventorySlotContents(int slot, ItemStack stack) {
		
		this.slots[slot] = stack;

		if(stack != null && stack.stackSize > this.getInventoryStackLimit()){
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	public String getInventoryName() {
		return null;
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	public int getInventoryStackLimit() {
		return 4;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}

	public void openInventory() {}
	public void closeInventory() {}

	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if(slot == 0){
			return stack.getItem() instanceof Item_EnergyCrystal;
		}else if(slot == 1 || slot == 2 || slot == 3){
			return stack.getItem() instanceof Item_Upgrade;
		}
		return false;
	}
	
	/*IInfo*/
	public String getInfo() {
		String str = energyStored + ";" + maxEnergyStored;
		return str;
	}

	/*IMagicEnergyStorage*/
	public int receiveEnergy(int maxReceive, boolean simulate) {
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
		return maxEnergyStored;
	}

}
