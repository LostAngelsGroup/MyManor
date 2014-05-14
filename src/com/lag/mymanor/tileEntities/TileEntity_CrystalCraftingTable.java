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
	public void updateEntity(){
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList(); //new list item tagu
		for(int i = 0; i < getSizeInventory(); i++){
			ItemStack stack = getStackInSlot(i);
			if (stack != null){
				NBTTagCompound item = new NBTTagCompound(); //vytvoreni novyho tagu
				item.setByte("slot", (byte)i); //ulozeni hodnoty IDmista do tagu item
				stack.writeToNBT(compound); //ulozeni stacku do nbt
				items.appendTag(item); //ulozeni itemu do items tag "list"
			}
		}
		compound.setTag("items", items); //ulozeni items tag "listu"
	}
	
	//nefunguje nacitani
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("items", NBT.TAG_COMPOUND);
		for (int i = 0; i < items.tagCount(); i++){
			NBTTagCompound item = items.getCompoundTagAt(i);
			int slot = item.getByte("slot");
			
			if(slot >= 0 && slot < getSizeInventory()){
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	
	public int getSizeInventory() {
		return inventory.length;
	}

	public ItemStack getStackInSlot(int var1) {
		return inventory[var1];
	}

	public ItemStack decrStackSize(int var1, int var2) {
		ItemStack itemstack = getStackInSlot(var1);
		
		if(itemstack != null){
			if(itemstack.stackSize <= var2){
				setInventorySlotContents(var1, null);
			}else{
				//odebrani urciteho mnozstvi
				itemstack = itemstack.splitStack(var2);
			}
		}
		return itemstack;
	}

	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack itemstack = getStackInSlot(var1);
		setInventorySlotContents(var1, null);
		return itemstack;
	}

	public void setInventorySlotContents(int var1, ItemStack var2) {
		inventory[var1] = var2;
		
		if(var2 != null && var2.stackSize > getInventoryStackLimit()){
			var2.stackSize = getInventoryStackLimit();
		}
	}
	
	//kdo by si doprdele pojemnovaval inventar?
	public String getInventoryName() {
		return null;
	}
	public boolean hasCustomInventoryName() {
		return false;
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean isUseableByPlayer(EntityPlayer var1) {
		if(var1.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64){
			return true;
		}
		System.out.println("Sorry stojis moc daleko");
		return false;
	}
	
	//only for chest
	public void openInventory() {
	}
	public void closeInventory() {
	}

	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		//da se nastavit na kterim slotu je ktery item dovoleny
		return true;
	}
}
