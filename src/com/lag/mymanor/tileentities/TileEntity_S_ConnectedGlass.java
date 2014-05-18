package com.lag.mymanor.tileentities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.lag.mymanor.init.MBlocks;

public class TileEntity_S_ConnectedGlass extends TileEntity{
	private byte[] textures = new byte[3]; 
	
	public TileEntity_S_ConnectedGlass(){
		for(int i = 0; i < textures.length; i++){
			textures[i] = 0;
		}
	}

	@Override
	public void updateEntity(){
		Block[][][] surroundings = new Block[3][3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(this.getWorldObj().getBlock(xCoord+i-1, yCoord+j-1, zCoord+k-1) == MBlocks.connectedTextureGlass){
						surroundings[i][j][k] = this.getWorldObj().getBlock(xCoord+i-1, yCoord+j-1, zCoord+k-1);//-1 opravuje pozici blocku
					}else{
						surroundings[i][j][k] = null;
					}
				}
			}
		}
		//side 0;1
		textures[0] = getClearTexture(surroundings, 0);
		//side 2,3
		textures[1] = getClearTexture(surroundings, 1);
		//side 4,5
		textures[2] = getClearTexture(surroundings, 2);
	}
	//zajistuje jakou texturu pouzit
	public byte getClearTexture(Block[][][] surroundings, int side){
		switch(side){
			case 0:{
				/* Old, ale funkcni
				//vsechno cisty
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 0;
				//4strany cisty; 3rohy cisty
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 1;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 2;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 3;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 4;
				//4strany cisty; 2rohy cisty, u sebe
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 5;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 6;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 7;
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 8;
				//4strany cisty; 2rohy cisty, na proti sobe
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 9;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 10;
				//4strany cisty; 1roh cisty,
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 11;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 12;
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 13;
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 14;
				//3strany cisty
				if(surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 15;
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 16;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 17;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null) return 18;
				//3strany cisty; 1ostatni roh ne-cisty
				if(surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 23;
				if(surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 24;
				if(surroundings[0][1][1] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 25;
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 26;
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 27;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[2][1][1] != null) return 28;
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null) return 29;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null) return 30;
				//3strany cisty; 2ostatni rohy ne-cisty
				if(surroundings[1][1][0] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 19;
				if(surroundings[0][1][1] != null && surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 20;
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[2][1][1] != null) return 21;
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null && surroundings[1][1][2] != null) return 22;
				//2strany u sebe
				if(surroundings[1][1][0] != null && surroundings[2][1][0] != null && surroundings[2][1][1] != null) return 31;
				if(surroundings[0][1][0] != null && surroundings[0][1][1] != null && surroundings[1][1][0] != null) return 32;
				if(surroundings[0][1][1] != null && surroundings[0][1][2] != null && surroundings[1][1][2] != null) return 33;
				if(surroundings[1][1][2] != null && surroundings[2][1][1] != null && surroundings[2][1][2] != null) return 34;
				//2strany u sebe; roh na proti
				if(surroundings[1][1][0] != null && surroundings[2][1][1] != null) return 35;
				if(surroundings[0][1][1] != null && surroundings[1][1][0] != null) return 36;
				if(surroundings[0][1][1] != null && surroundings[1][1][2] != null) return 37;
				if(surroundings[1][1][2] != null && surroundings[2][1][1] != null) return 38;
				//2strany na proti
				if(surroundings[1][1][0] != null && surroundings[1][1][2] != null) return 39;
				if(surroundings[0][1][1] != null && surroundings[2][1][1] != null) return 40;
				
				//1strana cista
				if(surroundings[1][1][0] != null) return 41;
				if(surroundings[0][1][1] != null) return 42;
				if(surroundings[1][1][2] != null) return 43;
				if(surroundings[2][1][1] != null) return 44;
				//0stran
				return 45;
				*/
				//podle stran
				if (surroundings[0][1][1] != null){
					if(surroundings[1][1][0] != null){	
						if(surroundings[0][1][0] != null){
							if(surroundings[0][1][2] != null){
								if(surroundings[1][1][2] != null) return 18; 
							}
							if(surroundings[2][1][1] != null){
								if(surroundings[1][1][2] != null){
									if(surroundings[2][1][2] != null) return 10;
								}
								return 28;
							}
							return 32;
						}
						if(surroundings[1][1][2] != null){
							if(surroundings[0][1][0] != null){
								if(surroundings[2][1][1] != null) return 12;
								return 30;
							}
							if(surroundings[0][1][2] != null){
								if(surroundings[2][1][1] != null){
									if(surroundings[0][1][0] != null){
										if(surroundings[2][1][0] != null){
											if(surroundings[2][1][2] != null) return 0;
											return 4;
										}
										if(surroundings[2][1][2] != null) return 3;
										return 7;
									}
									if(surroundings[2][1][0] != null){
										if(surroundings[2][1][2] != null) return 1;
										return 9;
									}
									if(surroundings[2][1][2] != null) return 8;
									return 13;
								}
								return 29;
							}
							if(surroundings[2][1][1] != null){
								if(surroundings[2][1][2] != null){
									if(surroundings[2][1][0] != null){
										if(surroundings[0][1][0] != null) return 2;
										return 5;
									}
									return 14;
								}
							}
							return 22;
						}
						if(surroundings[2][1][1] != null){
							if(surroundings[2][1][0] != null){
								if(surroundings[1][1][2] != null) return 11;
								if(surroundings[0][1][0] != null) return 17;
								return 27;
							}
							return 21;
						}
						return 36;
					}
					if(surroundings[1][1][2] != null){
						if(surroundings[2][1][1] != null){
							if(surroundings[2][1][0] != null){
								if(surroundings[1][1][0] != null){
									if(surroundings[0][1][0] != null) return 6;
								}
							}
							if(surroundings[2][1][2] != null){
								if(surroundings[0][1][2] != null) return 16;
								return 24;
							}
							return 20;
						}
						if(surroundings[0][1][2] != null) {
							if(surroundings[2][1][1] != null) return 26;
							if(surroundings[1][1][2] != null) return 33;
						}
						return 37;
					}
					if(surroundings[2][1][1] != null) return 40;
					return 42;
				}
				/////////////////////////////////////////////////////////////////
				if (surroundings[1][1][0] != null){
					if(surroundings[1][1][2] != null){
						if(surroundings[2][1][1] != null){
							if(surroundings[2][1][0] != null){
								if(surroundings[2][1][2] != null) return 15;
								return 23;
							}
							if(surroundings[2][1][2] != null) return 24;
							return 19;
						}
						return 39;
					}
					if(surroundings[2][1][1] != null){
						if(surroundings[2][1][0] != null) return 31;
						return 35;
					}
					return 41;
				}
				if (surroundings[1][1][2] != null){
					if(surroundings[2][1][1] != null){
						if(surroundings[2][1][2] != null) return 34;
						return 38;
					}
					return 43;
				}
				if (surroundings[2][1][1] != null){
					
					
					return 44;
				}
				//podle rohu
				
				//konec
				return 45;
			}
			case 1:{
				
				return 0;
			}
			case 2:{
				return 0;
			}
			default: return 0;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);

		compound.setByteArray("textures", textures);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		textures = compound.getByteArray("textures");
	}
	
	public int getTextureID(int side){
		return (int)textures[side];
	}
}
