package com.lag.mymanor.init;

import com.lag.mymanor.help.RegisterHelper;
import com.lag.mymanor.items.Crystal;
import com.lag.mymanor.items.CrystalDust;
import com.lag.mymanor.items.CrystalRaw;
import com.lag.mymanor.items.CrystalRawLarge;

import net.minecraft.item.Item;

public class MItems {
	
	public static Item crystalDust;
	
	public static Item crystalRaw;
	public static Item crystalRawLarge;
	
	public static Item crystalTiny;
	public static Item crystalSmall;
	public static Item crystalNormal;
	public static Item crystalLarge;
	public static Item crystalEnormous;
	
	public static void initItems(){
		
		crystalDust = new CrystalDust("crystal_dust");
		RegisterHelper.registerItem(crystalDust);
		
		crystalRaw = new CrystalRaw("crystal_raw");
		RegisterHelper.registerItem(crystalRaw);

		crystalRawLarge = new CrystalRawLarge("crystal_raw_large");
		RegisterHelper.registerItem(crystalRawLarge);
		
		crystalTiny = new Crystal("crystal_tiny");
		RegisterHelper.registerItem(crystalTiny);
		
		crystalSmall = new Crystal("crystal_small");
		RegisterHelper.registerItem(crystalSmall);
		
		crystalNormal = new Crystal("crystal_medium");
		RegisterHelper.registerItem(crystalNormal);
		
		crystalLarge = new Crystal("crystal_large");
		RegisterHelper.registerItem(crystalLarge);
		
		crystalEnormous = new Crystal("crystal_enormous");
		RegisterHelper.registerItem(crystalEnormous);
	}
}
