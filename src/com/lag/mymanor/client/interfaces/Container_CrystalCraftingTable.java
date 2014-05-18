package com.lag.mymanor.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.client.interfaces.slots.SlotCrystalRaw;
import com.lag.mymanor.client.interfaces.slots.SlotNothing;
import com.lag.mymanor.tileEntities.TileEntity_CrystalCraftingTable;

public class Container_CrystalCraftingTable extends Container{
	
	private TileEntity_CrystalCraftingTable table;
	
	public Container_CrystalCraftingTable(InventoryPlayer invPlayer, TileEntity_CrystalCraftingTable table){
		this.table = table;
		
		//player
		//hotbar
		for(int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}
		//inv
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18)); //tenhle kod zajistuje zobrazeni hracova invu v tablu //mozna nesedi
			}
		}
		//machine
		//crystal slot
		addSlotToContainer(new SlotCrystalRaw(table, 0, 59, 29));
		//tool slot
		for(int y = 0; y < 3; y++){
			addSlotToContainer(new Slot(table, y + 1, 20, y * 18 + 9 + y * 2));
		}
		//inventory
		for(int y = 0; y < 2; y++){
			for(int x = 0; x < 3; x++){
				addSlotToContainer(new SlotNothing(table, x + y * 3 + 4, 18 * x + 101, y * 18 + 21));
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return table.isUseableByPlayer(var1);
	}
	
	//zabranuje padu pri Shift kliku/nedovolu je ho
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
		return null;
	}
}
//pouze conteiner s daty, kterej musi byt na obou stranach