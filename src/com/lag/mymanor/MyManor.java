package com.lag.mymanor;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.lag.mymanor.client.interfaces.GuiHandler;
import com.lag.mymanor.help.ConfigHandler;
import com.lag.mymanor.help.Reference;
import com.lag.mymanor.init.MBlocks;
import com.lag.mymanor.init.MCraftingRecipes;
import com.lag.mymanor.init.MItems;
import com.lag.mymanor.init.MSmeltingRecipes;
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
	
	@SuppressWarnings("static-access")
	public static ToolMaterial crystal = new EnumHelper().addToolMaterial("CRYSTAL", 2, 1000, 5.0F, 2.5F, 18);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//config
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		//blocks
		MBlocks.initBlocks();
		//items
		MItems.initItems();
		//tools
		MItems.initTools();
		//world generator
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
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}