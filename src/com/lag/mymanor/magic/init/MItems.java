package com.lag.mymanor.magic.init;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.core.handlers.ConfigHandler;
import com.lag.mymanor.core.util.RegisterHelper;
import com.lag.mymanor.magic.items.Crystal;
import com.lag.mymanor.magic.items.CrystalDust;
import com.lag.mymanor.magic.items.CrystalRaw;
import com.lag.mymanor.magic.items.CrystalRawLarge;
import com.lag.mymanor.magic.items.MagicFuel;
import com.lag.mymanor.magic.items.tools.Axe;
import com.lag.mymanor.magic.items.tools.Hammer;
import com.lag.mymanor.magic.items.tools.Hoe;
import com.lag.mymanor.magic.items.tools.Pickaxe;
import com.lag.mymanor.magic.items.tools.Shovel;
import com.lag.mymanor.magic.items.tools.Sword;

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
	
	public static Item magicFuel;
	
	//zatim nepouzity
	public static Item crystalSmallCombined;
	public static Item crystalNormalCombined;
	public static Item crystalLargeCombinet;
	public static Item crystalEnourmousCombined;
	
	//tools
	public static Item cobblestoneHammer;
	public static Item ironHammer;
	
	public static Item crystalSword;
	public static Item crystalAxe;
	public static Item crystalPickaxe;
	public static Item crystalShovel;
	public static Item crystalHoe;
	
	public static void initMagicItems(){
		
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
		
		magicFuel = new MagicFuel("magic_fuel");
		RegisterHelper.registerItem(magicFuel);
	}
	
	public static void initMagicTools(){
		
		if(ConfigHandler.TOOLS_HAMMERS_VALUE){
			cobblestoneHammer = new Hammer("cobblestone_hammer", 64);
			RegisterHelper.registerItem(cobblestoneHammer);
			
			ironHammer = new Hammer("iron_hammer", 256);
			RegisterHelper.registerItem(ironHammer);
		}
		
		if(ConfigHandler.CRYSTAL_TOOLS_VALUE){
			crystalSword = new Sword("crystal_sword", MyManor.crystal);
			RegisterHelper.registerItem(crystalSword);
			
			crystalAxe = new Axe("crystal_axe", MyManor.crystal);
			RegisterHelper.registerItem(crystalAxe);
			
			crystalPickaxe = new Pickaxe("crystal_pickaxe", MyManor.crystal);
			RegisterHelper.registerItem(crystalPickaxe);
			
			crystalHoe = new Hoe("crystal_hoe", MyManor.crystal);
			RegisterHelper.registerItem(crystalHoe);
			
			crystalShovel = new Shovel("crystal_shovel", MyManor.crystal);
			RegisterHelper.registerItem(crystalShovel);
		}
	}
}
