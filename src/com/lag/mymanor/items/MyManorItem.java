package com.lag.mymanor.items;

import net.minecraft.item.Item;

import com.lag.mymanor.MyManorCreativeTabs;

public class MyManorItem extends Item{
	public MyManorItem(String name){
		setUnlocalizedName(name);
		setCreativeTab(MyManorCreativeTabs.tabMyManorItems);
	}
}
