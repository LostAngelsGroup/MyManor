package com.lag.mymanor.init;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.help.ConfigHandler;
import com.lag.mymanor.help.RegisterHelper;
import com.lag.mymanor.items.Crystal;
import com.lag.mymanor.items.CrystalDust;
import com.lag.mymanor.items.CrystalRaw;
import com.lag.mymanor.items.CrystalRawLarge;
import com.lag.mymanor.items.MagicFuel;
import com.lag.mymanor.items.tools.Axe;
import com.lag.mymanor.items.tools.Hammer;
import com.lag.mymanor.items.tools.Hoe;
import com.lag.mymanor.items.tools.Pickaxe;
import com.lag.mymanor.items.tools.Shovel;
import com.lag.mymanor.items.tools.Sword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

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
		
		magicFuel = new MagicFuel("magic_fuel");
		RegisterHelper.registerItem(magicFuel);
	}
	
	public static void initTools(){
		//nechapu posledni hodnotu
		cobblestoneHammer = new Hammer("cobblestone_hammer", 0F, ToolMaterial.STONE, null);
		RegisterHelper.registerItem(cobblestoneHammer);
		
		//nechapu posledni hodnotu
		ironHammer = new Hammer("iron_hammer", 0F, ToolMaterial.IRON, null);
		RegisterHelper.registerItem(ironHammer);
		
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
