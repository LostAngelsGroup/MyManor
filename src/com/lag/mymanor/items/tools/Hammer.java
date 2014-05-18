package com.lag.mymanor.items.tools;

import java.util.Set;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;

import com.lag.mymanor.MyManorCreativeTabs;
import com.lag.mymanor.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Hammer extends ItemTool{

	@SuppressWarnings("rawtypes")
	public Hammer(String name, float p_i45333_1_, ToolMaterial p_i45333_2_,
			Set p_i45333_3_) {
		super(p_i45333_1_, p_i45333_2_, p_i45333_3_);
		setUnlocalizedName(name);
		setCreativeTab(MyManorCreativeTabs.tabMyManorItems);
	}
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int damage){
		if (damage < this.getMaxDamage()/3){
			return icons[0];
		}else if(damage>this.getMaxDamage()/3){
			return icons[2];
		}else return icons[1];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister){
		icons = new IIcon[3];
		icons[0] = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_new");
		icons[1] = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		icons[2] = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_old");
    }
}
