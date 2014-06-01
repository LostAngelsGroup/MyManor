package com.lag.mymanor.magic.items;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.lag.mymanor.Reference;
import com.lag.mymanor.core.items.MyManorItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Item_Upgrade extends MyManorItem{

	public Item_Upgrade(String name) {
		super(name);
		
		setMaxStackSize(16);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":magic/upgrades/" +  getUnlocalizedName().substring(5));
    }
	
}
