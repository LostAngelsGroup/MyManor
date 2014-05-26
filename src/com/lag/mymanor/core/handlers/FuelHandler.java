package com.lag.mymanor.core.handlers;

import net.minecraft.item.ItemStack;

import com.lag.mymanor.magic.init.MItems;

import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == MItems.magicFuel){
			return 2400;
		}
		return 0;
	}

}
