package com.lag.mymanor.magic.utils;

import com.lag.mymanor.magic.interfaces.IMagicEnergyNetworkNod;

public class MagicEnergyNetworkConnection {
	
	private IMagicEnergyNetworkNod device1;
	private IMagicEnergyNetworkNod device2;
	
	public MagicEnergyNetworkConnection(IMagicEnergyNetworkNod tileentity1, IMagicEnergyNetworkNod tileentity2){
		this.device1 = tileentity1;
		this.device2 = tileentity2;
	}
	
	public IMagicEnergyNetworkNod getDeviceNotThis(IMagicEnergyNetworkNod tileentity){
		if(device1.hashCode() == tileentity.hashCode()){
			return device2;
		}
		return device1;
	}

}
