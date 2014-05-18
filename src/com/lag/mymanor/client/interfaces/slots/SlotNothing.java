package com.lag.mymanor.client.interfaces.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotNothing extends Slot{

	public SlotNothing(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
		super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
	}
	@Override
	public boolean isItemValid (ItemStack itemstack) {
		return false;
	}
}