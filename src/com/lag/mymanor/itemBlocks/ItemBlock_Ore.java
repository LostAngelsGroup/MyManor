package com.lag.mymanor.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.blocks.Ore;

public class ItemBlock_Ore extends ItemBlock{

	public ItemBlock_Ore(Block p_i45328_1_) {
		super(p_i45328_1_);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		String name = "";
		switch(itemstack.getItemDamage())
		{
			case 0:
				{
					name = Ore.names[0];
					break;
				}
			case 1:
				{
					name = Ore.names[1];
					break;
				}
			case 2:
				{
					name = Ore.names[2];
					break;
				}
			case 3:
				{
					name = Ore.names[3];
					break;
				}
			default:
				name = "Error";
		}
		return getUnlocalizedName() + "." + name;
	}
	
	@Override
	public int getMetadata(int par1){
		return par1;
	}
	
}
