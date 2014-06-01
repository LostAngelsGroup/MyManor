package com.lag.mymanor.magic.items;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.lag.mymanor.Reference;
import com.lag.mymanor.core.items.MyManorItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Item_EnergyCrystal extends MyManorItem{

	public Item_EnergyCrystal(String name) {
		super(name);

		setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":magic/energy_crystals/" +  getUnlocalizedName().substring(5));
    }
}
