package com.lag.mymanor.magic.interfaces;

import com.lag.mymanor.magic.utils.MagicEnergyNetworkConnection;

public interface IMagicEnergyNetworkNod {
	public int getStoredEnergy();
	
	public int getMaxStoredEnergy();
	
	public IMagicEnergyNetworkNod[] getConnectedDevices();
	
	public void addConnection(MagicEnergyNetworkConnection connection);
	public void removeConnection(MagicEnergyNetworkConnection connection);
	
	public int getTransferRate();
	
	public boolean hasFreeConnection();
	
}
