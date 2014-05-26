package com.lag.mymanor.magic.interfaces;

public interface IMagicEnergyStorage {
	
	int receiveEnergy(int maxReceive, boolean simulate);
	
	int extractEnergy(int maxExtract, boolean simulate);
	
	int getEnergyStored();
	
	int getMaxEnergyStored();
	
}
