package com.lag.mymanor.magic.init;

import com.lag.mymanor.core.handlers.ConfigHandler;
import com.lag.mymanor.core.util.RegisterHelper;
import com.lag.mymanor.magic.blocks.Block_NatureBattery;
import com.lag.mymanor.magic.blocks.Block_NatureBatteryDepleted;
import com.lag.mymanor.magic.blocks.CrystalBlock;
import com.lag.mymanor.magic.blocks.CrystalCraftingTable;
import com.lag.mymanor.magic.blocks.CrystalGlass;
import com.lag.mymanor.magic.blocks.CrystalOre;
import com.lag.mymanor.magic.blocks.CrystalOreLarge;
import com.lag.mymanor.magic.blocks.CrystalSand;
import com.lag.mymanor.magic.blocks.MagicFuelOre;
import com.lag.mymanor.magic.blocks.MagicInfuseGround;
import com.lag.mymanor.magic.itemBlocks.ItemBlock_CrystalBlock;
import com.lag.mymanor.magic.itemBlocks.ItemBlock_CrystalGlass;
import com.lag.mymanor.magic.itemBlocks.ItemBlock_CrystalOre;
import com.lag.mymanor.magic.itemBlocks.ItemBlock_CrystalSand;
import com.lag.mymanor.magic.itemBlocks.ItemBlock_MagicInfuseGround;
import com.lag.mymanor.magic.tileentities.TileEntity_CrystalCraftingTable;
import com.lag.mymanor.magic.tileentities.Tileentity_NatureBattery;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class MBlocks {
	
	public static Block block_natureBattery;
	public static Block block_natureBattery_depleated;
	
	public static Block oreCrystal;
	public static Block oreCrystalLarge;
	
	public static Block crystalSandLow;
	public static Block crystalGlassLow;
	
	public static Block crystalSandNormal;
	public static Block crystalGlassNormal;
	
	public static Block crystalSandHigh;
	public static Block crystalGlassHigh;
	
	public static Block blockCrystalTiny;
	public static Block blockCrystalSmall;
	public static Block blockCrystalNormal;
	public static Block blockCrystalLarge;
	public static Block blockCrystalEnormous;
	
	public static Block magicInfuseGround;
	
	public static Block crystalCraftingTable;
	
	public static Block magicFuel;
	
	public static TileEntity tileentity_natureBatery;
	
	public static void initMagicBlocks(){
		
		block_natureBattery = new Block_NatureBattery("nature_battery");
		RegisterHelper.registerBlock(block_natureBattery);
		
		block_natureBattery_depleated = new Block_NatureBatteryDepleted("nature_battery_depleted");
		RegisterHelper.registerBlock(block_natureBattery_depleated);
		
		oreCrystal = new CrystalOre("crystal_ore");
		RegisterHelper.registerBlock(oreCrystal, ItemBlock_CrystalOre.class);
		
		oreCrystalLarge = new CrystalOreLarge("crystal_ore_large");
		RegisterHelper.registerBlock(oreCrystalLarge, ItemBlock_CrystalOre.class);
		
		if (ConfigHandler.SAND_AND_GLASS_LOW_VALUE){
			crystalSandLow = new CrystalSand("crystal_sand_low");
			RegisterHelper.registerBlock(crystalSandLow, ItemBlock_CrystalSand.class);
			
			crystalGlassLow = new CrystalGlass("crystal_glass_low");
			RegisterHelper.registerBlock(crystalGlassLow, ItemBlock_CrystalGlass.class);
		}
		
		if (ConfigHandler.SAND_AND_GLASS_NORMAL_VALUE){
			crystalSandNormal = new CrystalSand("crystal_sand_normal");
			RegisterHelper.registerBlock(crystalSandNormal, ItemBlock_CrystalSand.class);
			
			crystalGlassNormal = new CrystalGlass("crystal_glass_normal");
			RegisterHelper.registerBlock(crystalGlassNormal, ItemBlock_CrystalGlass.class);
		}
		
		if (ConfigHandler.SAND_AND_GLASS_HIGH_VALUE){
			crystalSandHigh = new CrystalSand("crystal_sand_high");
			RegisterHelper.registerBlock(crystalSandHigh, ItemBlock_CrystalSand.class);
			
			crystalGlassHigh = new CrystalGlass("crystal_glass_high");
			RegisterHelper.registerBlock(crystalGlassHigh, ItemBlock_CrystalGlass.class);
		}
		
		if (ConfigHandler.CRYSTAL_BLOCK_VALUE){
			blockCrystalTiny = new CrystalBlock("crystal_block_tiny");
			RegisterHelper.registerBlock(blockCrystalTiny, ItemBlock_CrystalBlock.class);
			
			blockCrystalSmall = new CrystalBlock("crystal_block_small");
			RegisterHelper.registerBlock(blockCrystalSmall, ItemBlock_CrystalBlock.class);
			
			blockCrystalNormal = new CrystalBlock("crystal_block_normal");
			RegisterHelper.registerBlock(blockCrystalNormal, ItemBlock_CrystalBlock.class);
			
			blockCrystalLarge = new CrystalBlock("crystal_block_large");
			RegisterHelper.registerBlock(blockCrystalLarge, ItemBlock_CrystalBlock.class);
			
			blockCrystalEnormous = new CrystalBlock("crystal_block_enormous");
			RegisterHelper.registerBlock(blockCrystalEnormous, ItemBlock_CrystalBlock.class);
		}
		
		if (ConfigHandler.INFUSE_GROUND_VALUE){
			magicInfuseGround = new MagicInfuseGround("magic_infuse_ground");
			RegisterHelper.registerBlock(magicInfuseGround, ItemBlock_MagicInfuseGround.class);
		}
		
		crystalCraftingTable = new CrystalCraftingTable("crystal_crafting_table");
		RegisterHelper.registerBlock(crystalCraftingTable);
		
		magicFuel = new MagicFuelOre("magic_fuel_ore");
		RegisterHelper.registerBlock(magicFuel);
		
	}
	
	public static void initMagicTileentities(){
		RegisterHelper.registerTileEntity("tileentity_nature_battery", Tileentity_NatureBattery.class);
		RegisterHelper.registerTileEntity("tileEntity_crystal_crafting_table", TileEntity_CrystalCraftingTable.class);
	}
}
