package com.lag.mymanor.help;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static final String CATEGORY_DECORATION = "Decoration";
	public static final String CATEGORY_MAGIC = "Magic";
	
	//decoration
	public static boolean SAND_AND_GLASS_LOW_VALUE;
	private static final String SAND_AND_GLASS_LOW_NAME = "Sand & Glass - low";
	private static final boolean SAND_AND_GLASS_LOW_DEFAULT = true;
	
	public static boolean SAND_AND_GLASS_NORMAL_VALUE;
	private static final String SAND_AND_GLASS_NORMAL_NAME = "Sand & Glass - normal";
	private static final boolean SAND_AND_GLASS_NORMAL_DEFAULT = true;
	
	public static boolean SAND_AND_GLASS_HIGH_VALUE;
	private static final String SAND_AND_GLASS_HIGH_NAME = "Sand & Glass - high";
	private static final boolean SAND_AND_GLASS_HIGH_DEFAULT = true;
	
	public static boolean CRYSTAL_BLOCK_VALUE;
	private static final String CRYSTAL_BLOCK_NAME = "Crystal Block";
	private static final boolean CRYSTAL_BLOCK_DEFAULT = true;
	
	//magic
	public static boolean INFUSE_GROUND_VALUE;
	private static final String INFUSE_GROUND_NAME = "Infuse Ground";
	private static final boolean INFUSE_GROUND_DEFAULT = true;
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		//decoration
		SAND_AND_GLASS_LOW_VALUE = config.get(CATEGORY_DECORATION, SAND_AND_GLASS_LOW_NAME, SAND_AND_GLASS_LOW_DEFAULT).getBoolean(SAND_AND_GLASS_LOW_DEFAULT);
		SAND_AND_GLASS_NORMAL_VALUE = config.get(CATEGORY_DECORATION, SAND_AND_GLASS_NORMAL_NAME, SAND_AND_GLASS_NORMAL_DEFAULT).getBoolean(SAND_AND_GLASS_NORMAL_DEFAULT);
		SAND_AND_GLASS_HIGH_VALUE = config.get(CATEGORY_DECORATION, SAND_AND_GLASS_HIGH_NAME, SAND_AND_GLASS_HIGH_DEFAULT).getBoolean(SAND_AND_GLASS_HIGH_DEFAULT);
		
		CRYSTAL_BLOCK_VALUE = config.get(CATEGORY_DECORATION, CRYSTAL_BLOCK_NAME, CRYSTAL_BLOCK_DEFAULT).getBoolean(CRYSTAL_BLOCK_DEFAULT);
		
		//magic
		INFUSE_GROUND_VALUE = config.get(CATEGORY_MAGIC, INFUSE_GROUND_NAME, INFUSE_GROUND_DEFAULT).getBoolean(INFUSE_GROUND_DEFAULT);
		config.save();
	}
}
