package com.lag.mymanor.magic.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.lag.mymanor.core.items.MyManorItem;
import com.lag.mymanor.magic.interfaces.IMagicEnergyNetworkNod;
import com.lag.mymanor.magic.utils.MagicEnergyNetworkConnection;

public class Item_EnergyConnector extends MyManorItem{

	IMagicEnergyNetworkNod tileentity1;
	IMagicEnergyNetworkNod tileentity2;
	
	public Item_EnergyConnector(String name) {
		super(name);
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
        if( !(world.getTileEntity(x, y, z) instanceof IMagicEnergyNetworkNod)){
        	System.out.println("EnergyConnctor: Bad Block");
        	return false;
        }
		
        if(tileentity1 == null){
        	tileentity1 = (IMagicEnergyNetworkNod)world.getTileEntity(x, y, z);
        	
        	System.out.println(tileentity1.hasFreeConnection());
        	
        	if(tileentity1.hasFreeConnection()){
        		player.addChatMessage(new ChatComponentText("Device ready to connect"));
        		return true;
        	}else{
        		tileentity1 = null;
        	}
        }else{
        	tileentity2 = (IMagicEnergyNetworkNod)world.getTileEntity(x, y, z);
        	
        	if(tileentity2.hasFreeConnection()){
        		
        		tileentity1.addConnection(new MagicEnergyNetworkConnection(tileentity1, tileentity2));
        		tileentity2.addConnection(new MagicEnergyNetworkConnection(tileentity1, tileentity2));
        		
        		player.addChatMessage(new ChatComponentText("Devices connected"));
        		
        		tileentity1 = null;
        		tileentity2 = null;
        		
        		return true;
        	}else{
        		tileentity2 = null;
        	}
        }
        
		return false;
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
        if(player.isSneaking()){
        	tileentity1 = null;
        	tileentity2 = null;
        	
        	player.addChatMessage(new ChatComponentText("Connector reseted"));
        }
		return false;
    }
}
