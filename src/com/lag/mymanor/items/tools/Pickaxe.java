package com.lag.mymanor.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.IIcon;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pickaxe extends ItemPickaxe{

	public Pickaxe(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		setUnlocalizedName(name);
		setCreativeTab(MyManor.tabMyManorItems);
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
