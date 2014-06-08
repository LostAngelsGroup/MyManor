package com.lag.mymanor.magic.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.lag.mymanor.core.items.MyManorItem;
import com.lag.mymanor.magic.interfaces.IMagicEnergyStorage;

public class Item_EnergyConnector extends MyManorItem{

	public Item_EnergyConnector(String name) {
		super(name);
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
        //TODO: Write method to linking divaces
		if (world.getTileEntity(x, y, z) instanceof IMagicEnergyStorage){
        	return true;
        }
		
		return false;
    }
}
