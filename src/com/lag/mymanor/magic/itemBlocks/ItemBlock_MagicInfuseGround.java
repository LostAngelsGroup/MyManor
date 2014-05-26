package com.lag.mymanor.magic.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.magic.blocks.MagicInfuseGround;

public class ItemBlock_MagicInfuseGround extends ItemBlock{

	public ItemBlock_MagicInfuseGround(Block p_i45328_1_) {
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
					name = MagicInfuseGround.names[0];
					break;
				}
			case 1:
				{
					name = MagicInfuseGround.names[1];
					break;
				}
			case 2:
				{
					name = MagicInfuseGround.names[2];
					break;
				}
			case 3:
				{
					name = MagicInfuseGround.names[3];
					break;
				}
			case 4:
				{
					name = MagicInfuseGround.names[4];
					break;
				}
			case 5:
				{
					name = MagicInfuseGround.names[5];
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
