package com.lag.mymanor.core.guis.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.magic.items.Item_Upgrade;

public class Slot_Upgrade extends Slot{

	public Slot_Upgrade(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
		super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		if(itemstack.getItem() instanceof Item_Upgrade){
			return true;
		}
		return false;
	}
}
