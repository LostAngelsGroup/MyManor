package com.lag.mymanor.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants.NBT;

public class TileEntity_CrystalCraftingTable extends TileEntity implements IInventory{
	
	private ItemStack[] inventory;
	
	public TileEntity_CrystalCraftingTable(){
		inventory = new ItemStack[10];
	}

	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList(); //new list item tagu
		
		for(int i = 0; i < getSizeInventory(); i++){
			ItemStack stack = getStackInSlot(i);
			
			if (stack != null){
				NBTTagCompound item = new NBTTagCompound(); //vytvoreni novyho tagu
				item.setByte("Slot", (byte)i); //ulozeni hodnoty IDmista do tagu item
				stack.writeToNBT(compound); //ulozeni stacku do nbt
				items.appendTag(item); //ulozeni itemu do items tag "list"
			}
		}
		compound.setTag("Items", items); //ulozeni items tag "listu"
	}
	
	//nefunguje nacitani
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items", NBT.TAG_COMPOUND);
		
		for (int i = 0; i < items.tagCount(); i++){
			NBTTagCompound item = items.getCompoundTagAt(i);
			int slot = item.getByte("Slot");
			
			if(slot >= 0 && slot < getSizeInventory()){
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	
	public int getSizeInventory() {
		return inventory.length;
	}

	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	public ItemStack decrStackSize(int slot, int ammount) {
		ItemStack itemstack = getStackInSlot(slot);
		
		if(itemstack != null){
			if(itemstack.stackSize <= ammount){
				setInventorySlotContents(slot, null);
			}else{
				//odebrani urciteho mnozstvi
				itemstack = itemstack.splitStack(ammount);
			}
		}
		return itemstack;
	}

	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemstack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemstack;
	}

	public void setInventorySlotContents(int position, ItemStack stack) {
		inventory[position] = stack;
		
		if(stack != null && stack.stackSize > getInventoryStackLimit()){
			stack.stackSize = getInventoryStackLimit();
		}
	}
	
	public String getInventoryName() {
		return null;
	}
	public boolean hasCustomInventoryName() {
		return false;
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}
	
	//only for chest
	public void openInventory() {
	}
	public void closeInventory() {
	}

	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		//da se nastavit na kterim slotu je ktery item dovoleny
		return true;
	}
}
