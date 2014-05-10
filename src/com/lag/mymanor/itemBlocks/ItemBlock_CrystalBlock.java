package com.lag.mymanor.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.blocks.CrystalBlock;

public class ItemBlock_CrystalBlock extends ItemBlock{
	public ItemBlock_CrystalBlock(Block p_i45328_1_) {
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
					name = CrystalBlock.names[0];
					break;
				}
			case 1:
				{
					name = CrystalBlock.names[1];
					break;
				}
			case 2:
				{
					name = CrystalBlock.names[2];
					break;
				}
			case 3:
				{
					name = CrystalBlock.names[3];
					break;
				}
			case 4:
				{
					name = CrystalBlock.names[4];
					break;
				}
			case 5:
				{
					name = CrystalBlock.names[5];
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
