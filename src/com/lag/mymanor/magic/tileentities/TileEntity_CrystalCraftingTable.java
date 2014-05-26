package com.lag.mymanor.magic.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntity_CrystalCraftingTable extends TileEntity implements IInventory{
	
	private ItemStack[] inventory;
	
	public TileEntity_CrystalCraftingTable(){
		inventory = new ItemStack[10];
	}
	
	@Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        NBTTagList nbttaglist = new NBTTagList(); //novej taglist

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i); //slot v inv
                this.inventory[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        compound.setTag("Items", nbttaglist);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound){
        super.readFromNBT(nbtTagCompound);
        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND); //ID for compounds
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
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
