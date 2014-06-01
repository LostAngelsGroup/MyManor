package com.lag.mymanor.core.guis.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Slot_Nothing extends Slot{

	public Slot_Nothing(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
		super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
	}
	@Override
	public boolean isItemValid (ItemStack itemstack) {
		return false;
	}
}
