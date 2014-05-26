package com.lag.mymanor.magic.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.magic.blocks.CrystalSand;

public class ItemBlock_CrystalSand extends ItemBlock{
	public ItemBlock_CrystalSand(Block p_i45328_1_) {
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
					name = CrystalSand.names[0];
					break;
				}
			case 1:
				{
					name = CrystalSand.names[1];
					break;
				}
			case 2:
				{
					name = CrystalSand.names[2];
					break;
				}
			case 3:
				{
					name = CrystalSand.names[3];
					break;
				}
			case 4:
				{
					name = CrystalSand.names[4];
					break;
				}
			case 5:
				{
					name = CrystalSand.names[5];
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
