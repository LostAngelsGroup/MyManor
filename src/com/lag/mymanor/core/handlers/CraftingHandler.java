package com.lag.mymanor.core.handlers;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.magic.init.MItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event){
		
		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++){
			if(event.craftMatrix.getStackInSlot(i) != null){
				
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if(item0 != null && item0.getItem() == MItems.cobblestoneHammer){
					ItemStack k = new ItemStack(MItems.cobblestoneHammer, 2, (item0.getItemDamage() + 1));
					
					if(k.getItemDamage() >= k.getMaxDamage()){
						k.stackSize--;
					}
				event.craftMatrix.setInventorySlotContents(i, k);
				}
				
				ItemStack item1 = event.craftMatrix.getStackInSlot(i);
				if(item1 != null && item1.getItem() == MItems.ironHammer){
					ItemStack k = new ItemStack(MItems.ironHammer, 2, (item1.getItemDamage() + 1));
					
					if(k.getItemDamage() >= k.getMaxDamage()){
						k.stackSize--;
					}
				event.craftMatrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
}
