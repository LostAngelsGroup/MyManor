package com.lag.mymanor.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.blocks.CrystalGlass;

public class ItemBlock_CrystalGlass extends ItemBlock{
	public ItemBlock_CrystalGlass(Block p_i45328_1_) {
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
					name = CrystalGlass.names[0];
					break;
				}
			case 1:
				{
					name = CrystalGlass.names[1];
					break;
				}
			case 2:
				{
					name = CrystalGlass.names[2];
					break;
				}
			case 3:
				{
					name = CrystalGlass.names[3];
					break;
				}
			case 4:
				{
					name = CrystalGlass.names[4];
					break;
				}
			case 5:
				{
					name = CrystalGlass.names[5];
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
