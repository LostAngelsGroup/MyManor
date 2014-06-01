package com.lag.mymanor.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lag.mymanor.MyManor;
import com.lag.mymanor.MyManorCreativeTabs;
import com.lag.mymanor.core.util.GuiHelper;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyGenerator;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class Block_MagicEnergyGenerator extends BlockContainer{

	public Block_MagicEnergyGenerator(String name) {
		super(Material.iron);
		this.setBlockName(name);
		this.setCreativeTab(MyManorCreativeTabs.tabMyManorBlocks);
		
		this.setHardness(2.0F);
		this.setResistance(2.0F);
		
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeGlass);
	}
	
	public TileEntity createNewTileEntity(World world, int var2){
		System.out.println("Tileentity_MagicEnergyGenerator created"); //testovaci - nedojde k zavolani???
		return new Tileentity_MagicEnergyGenerator();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata){
		Tileentity_MagicEnergyGenerator tileentity = (Tileentity_MagicEnergyGenerator)world.getTileEntity(x, y, z);
        
        if(tileentity != null && tileentity instanceof IInventory){
        	for(int i = 0; i < tileentity.getSizeInventory(); i++){
        		ItemStack stack = tileentity.getStackInSlotOnClosing(i);
        		
        		if(stack != null){
        			float spawnX = x + world.rand.nextFloat();
        			float spawnY = y + world.rand.nextFloat();
        			float spawnZ = z + world.rand.nextFloat();
        			
        			float mult = 0.08F;
        			
        			EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);
        			
        			droppedItem.motionX = (- 0.5F + world.rand.nextFloat()) * mult;
        			droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
        			droppedItem.motionZ = (- 0.5F + world.rand.nextFloat()) * mult;
        			
        			world.spawnEntityInWorld(droppedItem);
        		}
        	}
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, MyManor.instance, GuiHelper.guiID_Energy_generator, world, x, y, z);
		}
		return true;
	}
}
