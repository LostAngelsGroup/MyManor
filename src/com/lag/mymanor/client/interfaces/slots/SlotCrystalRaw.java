package com.lag.mymanor.client.interfaces.slots;

import com.lag.mymanor.init.MItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCrystalRaw extends Slot{

	public SlotCrystalRaw(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
		super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		if(itemstack.getItem() == MItems.crystalRaw || itemstack.getItem() == MItems.crystalRawLarge){
			return true;
		}
		return false;
	}
}
