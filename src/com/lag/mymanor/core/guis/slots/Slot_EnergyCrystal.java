package com.lag.mymanor.core.guis.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.magic.items.Item_EnergyCrystal;

public class Slot_EnergyCrystal extends Slot{

	public Slot_EnergyCrystal(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
		super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		if(itemstack.getItem() instanceof Item_EnergyCrystal){
			return true;
		}
		return false;
	}

}
