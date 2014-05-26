package com.lag.mymanor.magic.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.lag.mymanor.Reference;
import com.lag.mymanor.core.items.MyManorItem;
import com.lag.mymanor.magic.utils.ECrystalNames;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrystalRaw extends MyManorItem{

	public CrystalRaw(String name) {
		super(name);
		setHasSubtypes(true);
		
	}
	public static final String[] names = new String[]{ECrystalNames.AIR.toString() + "_RAW",ECrystalNames.DARKNESS.toString() + "_RAW", ECrystalNames.EARTH.toString() + "_RAW", ECrystalNames.FIRE.toString() + "_RAW", ECrystalNames.LIGHT.toString() + "_RAW", ECrystalNames.WATER.toString() + "_RAW"};
	
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1){
       switch(par1){
       		case 0: return icons[0];
       		case 1: return icons[1];
       		case 2: return icons[2];
       		case 3: return icons[3];
       		case 4: return icons[4];
       		case 5: return icons[5];
       		default: return icons[0];
       }
    }
	@SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IIconRegister par1IconRegister){
		icons = new IIcon[names.length];
		for (int i = 0; i < icons.length; i++){
			icons[i] = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + i);
		}
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_){
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 2));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 3));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 4));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 5));
    }
	
	public int getMetadata(int par1){
        return par1;
    }
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
    {
		String name = "";
		String raw = "_RAW";
		switch(par1ItemStack.getItemDamage())
		{
			case 0:
				{
					name = ECrystalNames.AIR.toString() + raw;
					break;
				}
			case 1:
				{
					name = ECrystalNames.DARKNESS.toString() + raw;
					break;
				}
			case 2:
				{
					name = ECrystalNames.EARTH.toString() + raw;
					break;
				}
			case 3:
				{
					name = ECrystalNames.FIRE.toString() + raw;
					break;
				}
			case 4:
				{
					name = ECrystalNames.LIGHT.toString() + raw;
					break;
				}
			case 5:
				{
					name = ECrystalNames.WATER.toString() + raw;
					break;
				}
			default:
				name = "Error";
		}
		return getUnlocalizedName() + "." + name;
		
    }
}
