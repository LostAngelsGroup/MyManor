package com.lag.mymanor.magic.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.lag.mymanor.core.interfaces.IInfo;
import com.lag.mymanor.magic.interfaces.IMagicEnergyNetworkNod;
import com.lag.mymanor.magic.items.Item_EnergyCrystal;
import com.lag.mymanor.magic.items.Item_Upgrade;
import com.lag.mymanor.magic.utils.MagicEnergyNetworkConnection;

public class Tileentity_MagicEnergyTransferer extends TileEntity implements IInfo, IInventory, IMagicEnergyNetworkNod{
	
	private static final int RANGE_BASE = 10;
	private static final int NUMBER_OF_CONNECTIONS_BASE = 5;
	private static final int MAX_ENERGY_STORAGE_BASE = 800;
	private static final int TRANSFER_RATE = 200;
	private static final boolean EXTRACT_ENERGY_BASE = false;
	private static final int EXTRACT_ENERGY_SPEED_BASE = 200;
	
	
	private int range;
	private int numberOfConnections;
	private int maxEnergyStored;
	private int energyStored;
	private int transferRate;
	private boolean extractEnergy;
	private int extractEnergySpeed;
	
	private ItemStack slots[] = new ItemStack[4];
	private MagicEnergyNetworkConnection connections[];
	
	public Tileentity_MagicEnergyTransferer(){
		range = RANGE_BASE;
		numberOfConnections = NUMBER_OF_CONNECTIONS_BASE;
		maxEnergyStored = MAX_ENERGY_STORAGE_BASE;
		transferRate = TRANSFER_RATE;
		extractEnergy = EXTRACT_ENERGY_BASE;
		extractEnergySpeed = EXTRACT_ENERGY_SPEED_BASE;
		
		connections = new MagicEnergyNetworkConnection[20];
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
		this.numberOfConnections = nbt.getInteger("NumberOfConnections");
		this.range = nbt.getInteger("Range");
		this.transferRate = nbt.getInteger("TransferRate");
		this.extractEnergySpeed = nbt.getInteger("ExtractEnergySpeed");
		
		this.extractEnergy = nbt.getBoolean("ExtractEnergy");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		nbt.setInteger("EnergyStored", energyStored);
		nbt.setInteger("MaxEnergyStored", maxEnergyStored);
		nbt.setInteger("NumberOfConnections", numberOfConnections);
		nbt.setInteger("Range", range);
		nbt.setInteger("TransferRate", transferRate);
		nbt.setInteger("ExtractEnergySpeed", extractEnergySpeed);
		
		nbt.setBoolean("ExtractEnergy", extractEnergy);
		
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
		/*
		NBTTagList list2 = new NBTTagList();
		
		for(int i = 0; i < connections.length; i++){
			if(this.connections[i] instanceof MagicEnergyNetworkConnection){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("ID", (byte)i);
				//compound.set Connections?
				
				list2.appendTag(compound);
			}
		}
		*/
	}
	
	/**IInventory*/
	public int getSizeInventory() {
		return slots.length;
	}

	public ItemStack getStackInSlot(int slot) {
		return slots[slot];
	}

	public ItemStack decrStackSize(int slot, int ammount) {
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
	/**IInfo*/
	public String getInfo() {
		String str = energyStored + ";" + maxEnergyStored + ";" + usedConnections() + ";" + numberOfConnections;
		return str;
	}
	/**IMagicEnergyNetworkNod*/
	public int getStoredEnergy() {
		return energyStored;
	}

	public int getMaxStoredEnergy() {
		return maxEnergyStored;
	}

	public IMagicEnergyNetworkNod[] getConnectedDevices() {
		IMagicEnergyNetworkNod[] connectedDevices = new IMagicEnergyNetworkNod[connections.length];
		
		for(int i = 0; i < connections.length; i++){
			connectedDevices[i] = connections[i].getDeviceNotThis(this);
		}
		
		return connectedDevices;
	}

	public void addConnection(MagicEnergyNetworkConnection connection) {
		
		for(int i = 0; i < connections.length; i++){
			if(!(connections[i] instanceof MagicEnergyNetworkConnection)){
				this.connections[i] = connection;
			}
		}
	}
	
	public void removeConnection(MagicEnergyNetworkConnection connection) {
		
	}

	public int getTransferRate() {
		return transferRate;
	}

	public boolean hasFreeConnection() {
		return numberOfConnections > usedConnections() ? true: false;
	}
	//for container
	public void setStoreEnergy(int par2) {
		if(par2 <= maxEnergyStored){
			energyStored = par2;
		}
		
	}
	//for gui
	public int getEnergyStoredScaled(int value) {
		return energyStored * value / maxEnergyStored;
	}
	
	public int usedConnections(){
		int usedConnections = 0;
		
		for(int i = 0; i < connections.length; i++){
			if( connections[i] != null){
				usedConnections++;
			}
		}
		System.out.println(usedConnections);
		return usedConnections;
	}
	
}
