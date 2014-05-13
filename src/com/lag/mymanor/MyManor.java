package com.lag.mymanor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.lag.mymanor.client.interfaces.GuiHandler;
import com.lag.mymanor.help.ConfigHandler;
import com.lag.mymanor.help.Reference;
import com.lag.mymanor.help.RegisterHelper;
import com.lag.mymanor.init.MBlocks;
import com.lag.mymanor.init.MCraftingRecipes;
import com.lag.mymanor.init.MItems;
import com.lag.mymanor.init.MSmeltingRecipes;
import com.lag.mymanor.items.tools.Axe;
import com.lag.mymanor.items.tools.Hammer;
import com.lag.mymanor.items.tools.Hoe;
import com.lag.mymanor.items.tools.Pickaxe;
import com.lag.mymanor.items.tools.Shovel;
import com.lag.mymanor.items.tools.Sword;
import com.lag.mymanor.world.MGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class MyManor {
	
	@Instance(value=Reference.MODID)
	public static MyManor instance;
	
	//Creative Tabs
		//blocks
	public static CreativeTabs tabMyManorBlocks = new CreativeTabs("tabMyManorBlocks") {
		public Item getTabIconItem(){
			return Items.sign;
		}
	};
		//items
	public static CreativeTabs tabMyManorItems = new CreativeTabs("tabMyManorItems"){
		public Item getTabIconItem(){
			return MItems.crystalRawLarge;
		}
	};
	
	//zatim nepouzity
	public static Item crystalSmallCombined;
	public static Item crystalNormalCombined;
	public static Item crystalLargeCombinet;
	public static Item crystalEnourmousCombined;
	
	//tady konci nepouzity
	
	@SuppressWarnings("static-access")
	public static ToolMaterial crystal = new EnumHelper().addToolMaterial("CRYSTAL", 2, 1000, 5.0F, 2.5F, 18);
	
	//Tools
	public static Item crystalSword;
	public static Item crystalAxe;
	public static Item crystalPickaxe;
	public static Item crystalShovel;
	public static Item crystalHoe;
	
	public static Item ironHammer;
	public static Item cobblestoneHammer;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//config
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		//blocks
		MBlocks.initBlocks();
		//items
		MItems.initItems();
		
		//tools
		crystalSword = new Sword("crystal_sword", MyManor.crystal);
		RegisterHelper.registerItem(crystalSword);
		crystalAxe = new Axe("crystal_axe", MyManor.crystal);
		RegisterHelper.registerItem(crystalAxe);
		crystalPickaxe = new Pickaxe("crystal_pickaxe", MyManor.crystal);
		RegisterHelper.registerItem(crystalPickaxe);
		crystalHoe = new Hoe("crystal_hoe", crystal);
		RegisterHelper.registerItem(crystalHoe);
		crystalShovel = new Shovel("crystal_shovel", MyManor.crystal);
		RegisterHelper.registerItem(crystalShovel);
		
		//nechapu posledni hodnotu
		ironHammer = new Hammer("iron_hammer", 0F, ToolMaterial.IRON, null);
		RegisterHelper.registerItem(ironHammer);
		
		//nechapu posledni hodnotu, asi neco jako set?
		cobblestoneHammer = new Hammer("cobblestone_hammer",0F,ToolMaterial.WOOD, null);
		RegisterHelper.registerItem(cobblestoneHammer);
		
		GameRegistry.registerWorldGenerator(new MGenerator(), 10);
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event){
    	//craftingRecipes
    	MCraftingRecipes.initCraftingRecipes();
    	//smeltingRecipes
    	MSmeltingRecipes.initSmeltingRecipes();
    	//tileEntities
    	MBlocks.initTileEntities();
    	//gui handler
    	new GuiHandler();
    	
    	//recepty jsou vadny vyuzivaji totiz crystalRaw
    	GameRegistry.addShapedRecipe(new ItemStack(crystalSword, 1), new Object[]{" X ", " X ", " I ", 'X', MItems.crystalRaw, 'I', Items.stick});
    	GameRegistry.addShapedRecipe(new ItemStack(crystalAxe, 1),new Object[]{"XX ", "XI ", " I ", 'X', MItems.crystalRaw, 'I',Items.stick});
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}
//zasranej testovaci update