package com.lag.mymanor.core.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.lag.mymanor.MyManorCreativeTabs;
import com.lag.mymanor.core.interfaces.IInfo;

public class Item_DebugItem extends Item{
	
	public Item_DebugItem(String name){
		this.setUnlocalizedName(name);
		this.setCreativeTab(MyManorCreativeTabs.tabMyManorItems);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		Block block = world.getBlock(x, y, z);
		if(tileentity instanceof IInfo){
			player.addChatMessage(new ChatComponentText(((IInfo) tileentity).getInfo()));
        	return true;
		}
		if(block instanceof IInfo){
        	player.addChatMessage(new ChatComponentText(((IInfo) block).getInfo()));
        	return true;
		}
        return false;
    }
}
