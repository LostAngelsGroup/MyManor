package com.lag.mymanor.magic.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.lag.mymanor.Reference;
import com.lag.mymanor.core.blocks.MyManorBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Block_NatureBatteryDepleted extends MyManorBlock{

	public Block_NatureBatteryDepleted(String name) {
		super(name, Material.anvil);
		setHardness(5F);
		setResistance(5F);
		setHarvestLevel("pickaxe", 2);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":magic/natureBattery/nature_battery0");
    }
}
