package com.lag.mymanor;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.lag.mymanor.core.handlers.ConfigHandler;
import com.lag.mymanor.core.handlers.CraftingHandler;
import com.lag.mymanor.core.handlers.FuelHandler;
import com.lag.mymanor.core.handlers.GuiHandler;
import com.lag.mymanor.core.init.CItems;
import com.lag.mymanor.core.world.MGenerator;
import com.lag.mymanor.magic.init.MBlocks;
import com.lag.mymanor.magic.init.MCraftingRecipes;
import com.lag.mymanor.magic.init.MItems;
import com.lag.mymanor.magic.init.MSmeltingRecipes;
import com.lag.mymanor.technic.init.TBlocks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class MyManor {
	
	@Instance(value=Reference.MODID)
	public static MyManor instance;
	
	@SuppressWarnings("static-access")
	public static ToolMaterial crystal = new EnumHelper().addToolMaterial("CRYSTAL", 2, 1000, 5.0F, 2.5F, 18);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//config
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		//blocks
		//CBlocks?
		MBlocks.initMagicBlocks();
		TBlocks.initTechnicBlocks();
		
		//items
		CItems.initCoreItems();
		MItems.initMagicItems();
		//TItems?
		
		//tools
		//CTools
		MItems.initMagicTools();
		//TTools?
		
		//world generator
		GameRegistry.registerWorldGenerator(new MGenerator(), 10);
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event){
    	//craftingRecipes
    	//CCrafting?
    	MCraftingRecipes.initCraftingRecipes();
    	//TCrafting?
    	
    	//smeltingRecipes
    	//CSmelting?
    	MSmeltingRecipes.initSmeltingRecipes();
    	//TSmelting?
    	
    	//tileEntities
    	//CTileentities?
    	MBlocks.initMagicTileentities();
    	TBlocks.initTechnicTileentities();
    	
    	//fuel handler
    	GameRegistry.registerFuelHandler(new FuelHandler());
    	
    	//gui handler
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	
    	//crafting handler
    	FMLCommonHandler.instance().bus().register(new CraftingHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}