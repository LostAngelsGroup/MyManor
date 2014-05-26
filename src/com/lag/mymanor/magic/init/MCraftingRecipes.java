package com.lag.mymanor.magic.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.lag.mymanor.core.handlers.ConfigHandler;

import cpw.mods.fml.common.registry.GameRegistry;

public class MCraftingRecipes {
	
	public static void initCraftingRecipes(){
		//registrace vseho craftingu, kterej je po 6 druzich
		for (int i = 0; i < 6; i++){
			if (ConfigHandler.CRYSTAL_BLOCK_VALUE){
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.blockCrystalTiny, 1, i), new Object[]{"XXX","XXX","XXX", 'X', new ItemStack(MItems.crystalTiny, 1, i)});
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.blockCrystalSmall, 1, i), new Object[]{"XXX","XXX","XXX", 'X', new ItemStack(MItems.crystalSmall, 1, i)});
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.blockCrystalNormal, 1, i), new Object[]{"XXX","XXX","XXX", 'X', new ItemStack(MItems.crystalNormal, 1, i)});
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.blockCrystalLarge, 1, i), new Object[]{"XXX","XXX","XXX", 'X', new ItemStack(MItems.crystalLarge, 1, i)});
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.blockCrystalEnormous, 1, i), new Object[]{"XXX","XXX","XXX", 'X', new ItemStack(MItems.crystalEnormous, 1, i)});
			}
			
			if (ConfigHandler.INFUSE_GROUND_VALUE){
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.magicInfuseGround, 1, i), new Object[]{"XXX","XYX","XXX", 'X', new ItemStack(MItems.crystalDust, 1, i), 'Y',Blocks.dirt});
			}
			
			if (ConfigHandler.SAND_AND_GLASS_LOW_VALUE){
				GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.crystalSandLow, 1, i), new Object[]{new ItemStack(MItems.crystalDust, 1, i), Blocks.sand});
			}
			
			if (ConfigHandler.SAND_AND_GLASS_NORMAL_VALUE){
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.crystalSandNormal, 1, i), new Object[]{"X X", " Y ", "X X", 'X', new ItemStack(MItems.crystalDust, 1, i), 'Y', Blocks.sand});
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.crystalSandNormal, 1, i), new Object[]{" X ", "XYX", " X ", 'X', new ItemStack(MItems.crystalDust, 1, i), 'Y', Blocks.sand});
			}
			
			if (ConfigHandler.SAND_AND_GLASS_HIGH_VALUE){
				GameRegistry.addShapedRecipe(new ItemStack(MBlocks.crystalSandHigh, 1, i), new Object[]{"XXX", "XYX", "XXX", 'X', new ItemStack(MItems.crystalDust, 1, i), 'Y', Blocks.sand});
			}
			
		}
		//registrace ostatniho craftingu
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.crystalNormal, 1, 0), new Object[]{new ItemStack(MItems.cobblestoneHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(MItems.crystalRaw, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.crystalNormal, 1, 0), new Object[]{new ItemStack(MItems.ironHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(MItems.crystalRaw, 1, 0)});
	}
}
