package com.lag.mymanor.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.lag.mymanor.blocks.CrystalOre;

public class ItemBlock_CrystalOre extends ItemBlock{

	public ItemBlock_CrystalOre(Block p_i45328_1_) {
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
					name = CrystalOre.names[0];
					break;
				}
			case 1:
				{
					name = CrystalOre.names[0];
					break;
				}
			case 2:
				{
					name = CrystalOre.names[0];
					break;
				}
			case 3:
				{
					name = CrystalOre.names[0];
					break;
				}
			case 4:
				{
					name = CrystalOre.names[0];
					break;
				}
			case 5:
				{
					name = CrystalOre.names[0];
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
