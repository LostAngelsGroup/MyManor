package com.lag.mymanor.magic.init;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.core.handlers.ConfigHandler;
import com.lag.mymanor.core.util.RegisterHelper;
import com.lag.mymanor.magic.items.Crystal;
import com.lag.mymanor.magic.items.CrystalDust;
import com.lag.mymanor.magic.items.CrystalRaw;
import com.lag.mymanor.magic.items.CrystalRawLarge;
import com.lag.mymanor.magic.items.Item_EnergyConnector;
import com.lag.mymanor.magic.items.Item_EnergyCrystal;
import com.lag.mymanor.magic.items.Item_Upgrade;
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
	
	//upgrades
	public static Item upgrade_range;
	public static Item upgrade_transfer;
	public static Item upgrade_extract;
	public static Item upgrade_number;
	public static Item upgrade_capacity;
	public static Item upgrade_speed;
	
	//energy_crystals
	public static Item energy_crystal_AIR;
	public static Item energy_crystal_DARKNESS;
	public static Item energy_crystal_EARTH;
	public static Item energy_crystal_FIRE;
	public static Item energy_crystal_LIGHT;
	public static Item energy_crystal_WATER;
	
	//
	public static Item item_connector;
	
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
		
		//upgrades
		upgrade_capacity = new Item_Upgrade("upgrade_capacity");
		RegisterHelper.registerItem(upgrade_capacity);
		upgrade_extract = new Item_Upgrade("upgrade_extract");
		RegisterHelper.registerItem(upgrade_extract);
		upgrade_number = new Item_Upgrade("upgrade_number");
		RegisterHelper.registerItem(upgrade_number);
		upgrade_range = new Item_Upgrade("upgrade_range");
		RegisterHelper.registerItem(upgrade_range);
		upgrade_speed = new Item_Upgrade("upgrade_speed");
		RegisterHelper.registerItem(upgrade_speed);
		upgrade_transfer = new Item_Upgrade("upgrade_transfer");
		RegisterHelper.registerItem(upgrade_transfer);
		
		//energy_crystals
		energy_crystal_AIR = new Item_EnergyCrystal("energy_crystal_AIR");
		RegisterHelper.registerItem(energy_crystal_AIR);
		energy_crystal_DARKNESS = new Item_EnergyCrystal("energy_crystal_DARKNESS");
		RegisterHelper.registerItem(energy_crystal_DARKNESS);
		energy_crystal_EARTH = new Item_EnergyCrystal("energy_crystal_EARTH");
		RegisterHelper.registerItem(energy_crystal_EARTH);
		energy_crystal_FIRE = new Item_EnergyCrystal("energy_crystal_FIRE");
		RegisterHelper.registerItem(energy_crystal_FIRE);
		energy_crystal_LIGHT = new Item_EnergyCrystal("energy_crystal_LIGHT");
		RegisterHelper.registerItem(energy_crystal_LIGHT);
		energy_crystal_WATER = new Item_EnergyCrystal("energy_crystal_WATER");
		RegisterHelper.registerItem(energy_crystal_WATER);
		
		//
		item_connector = new Item_EnergyConnector("energy_connector");
		RegisterHelper.registerItem(item_connector);
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
