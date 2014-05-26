package com.lag.mymanor.magic.tileentities;

import java.util.Random;

import com.lag.mymanor.core.interfaces.IInfo;
import com.lag.mymanor.magic.interfaces.IMagicEnergyStorage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class Tileentity_NatureBattery extends TileEntity implements IMagicEnergyStorage, IInfo{
	
	private Random rand = new Random();
	
	private int storedEnergy;
	
	public Tileentity_NatureBattery(){
		this.storedEnergy = 5000 + rand.nextInt(5000);
	}
	
	public int getTexture(){
		double temp = storedEnergy / 1000;
		temp = Math.round(temp);
		return (int)temp;
	}
	//neuklada NBT
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setInteger("StoredEnergy", storedEnergy);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		this.storedEnergy = compound.getInteger("StoredEnergy");
	}
	
	/*IMagicEnergyStorage*/
	public int receiveEnergy(int maxReceive, boolean simulate) {
		return 0;
	}
	public int extractEnergy(int maxExtract, boolean simulate) {
		if(storedEnergy >= maxExtract){
			if(!simulate){
				this.storedEnergy -= maxExtract;
				return maxExtract;
			}
			return maxExtract;
		}
		int temp = storedEnergy;
		this.storedEnergy = 0;
		return temp;
	}
	public int getEnergyStored() {
		return storedEnergy;
	}
	public int getMaxEnergyStored() {
		return 0;
	}
	/*IInfo*/
	public String getInfo() {
		String ret = getClass().getName() + ";" + storedEnergy; 
		return ret;
	}
	
}
