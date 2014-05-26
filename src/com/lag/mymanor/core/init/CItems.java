package com.lag.mymanor.core.init;

import com.lag.mymanor.core.items.Item_DebugItem;
import com.lag.mymanor.core.util.RegisterHelper;

import net.minecraft.item.Item;

public class CItems {
	
	public static Item debugItem;
	
	public static void initCoreItems(){
		debugItem = new Item_DebugItem("debug_tool");
		RegisterHelper.registerItem(debugItem);
	}
	
}
