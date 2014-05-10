package com.lag.mymanor.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.lag.mymanor.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagicInfuseGround extends MyManorBlock{

	public MagicInfuseGround(String name) {
		super(name, Material.ground);
		setStepSound(soundTypeGrass);
		setHardness(2.0F);
		setResistance(3.0F);
	}
	
	public static final String[] names = new String[]{"GroundAir", "GroundDarkness", "GroundEarth", "GroundFire", "GroundLight", "GroundWater"};
	
	@SideOnly(Side.CLIENT)
	IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta){
		switch(meta){
			case 0:
			{
				switch(side){
				case 0: return icons[0];
				case 1: return icons[1];
				default: return icons[2];
				}
			}
			case 1:
			{
				switch(side){
				case 0: return icons[3];
				case 1: return icons[4];
				default: return icons[5];
				}
			}
			case 2:
			{
				switch(side){
				case 0: return icons[6];
				case 1: return icons[7];
				default: return icons[8];
				}
			}
			case 3:
			{
				switch(side){
				case 0: return icons[9];
				case 1: return icons[10];
				default: return icons[11];
				}
			}
			case 4:
			{
				switch(side){
				case 0: return icons[12];
				case 1: return icons[13];
				default: return icons[14];
				}
			}
			case 5:
			{
				switch(side){
				case 0: return icons[15];
				case 1: return icons[16];
				default: return icons[17];
				}
			}
			default:
			{
				switch(side){
				case 0: return icons[0];
				case 1: return icons[1];
				default: return icons[2];
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		icons = new IIcon[names.length*3];
		for (int i = 0; i < icons.length; i++){
			icons[i] = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + i);
		}
	}
	
	@Override
	public int damageDropped(int p_149692_1_){
        return p_149692_1_;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_){
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 4));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 5));
    }
	
	//specialni veci co tenhle block dela
	@Override //air; darkness
	public void onEntityWalking(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_){
		if(this.getDamageValue(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_)==0){
			p_149724_5_.motionX *= 1.2D;
			p_149724_5_.motionZ *= 1.2D;
		}else if(this.getDamageValue(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_)==1){
			p_149724_5_.attackEntityFrom(DamageSource.generic, 1);
		}
	}
	
	@Override
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z){
		return false;
	}
	
	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z){
		return false;
	}
	@Override //earth //!chyba neoveruje potrebu vody
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable){
		if(this.getDamageValue((World)world, x, y, z)==2){
			return true;
		}else{
			return false;
		}
	}
	@Override //fire
	public boolean isBurning(IBlockAccess world, int x, int y, int z){
		if(this.getDamageValue((World)world, x, y, z)==3){
			return true;
		}else{
			return false;
		}
	}
	@Override //fire
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side){
		if(this.getDamageValue((World)world, x, y, z)==3){
			if (side == ForgeDirection.UP) return true;
			return false;
		}else{
			return false;
		}
	}
	
	@Override //earth //!chyba chova se jako block u kteryho je voda...
	public boolean isFertile(World world, int x, int y, int z){
		if(this.getDamageValue((World)world, x, y, z)==2){
			return true;
		}else{
			return false;
		}
	}
	@Override //stezitelnost
	public boolean isToolEffective(String type, int meta){
		if(type == "shovel")return true;
		return false;
	}
}
