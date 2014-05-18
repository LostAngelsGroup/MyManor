package com.lag.mymanor;

import com.lag.mymanor.init.MBlocks;
import com.lag.mymanor.init.MItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class MyManorCreativeTabs extends CreativeTabs{
	public MyManorCreativeTabs(String lable) {
		super(lable);
	}
	
	public static final CreativeTabs tabMyManorBlocks = new CreativeTabs("tabMyManorBlocks") {
		
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(MBlocks.oreCrystalLarge);
		}
	};
	public static final CreativeTabs tabMyManorItems = new CreativeTabs("tabMyManorItems") {
		
		@Override
		public Item getTabIconItem() {
			return MItems.crystalRawLarge;
		}
	};
}
