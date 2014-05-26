package com.lag.mymanor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.lag.mymanor.magic.init.MBlocks;
import com.lag.mymanor.magic.init.MItems;

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
