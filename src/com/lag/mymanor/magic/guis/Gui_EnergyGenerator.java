package com.lag.mymanor.magic.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.lag.mymanor.Reference;
import com.lag.mymanor.magic.containers.Container_EnergyGenerator;
import com.lag.mymanor.magic.init.MItems;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyGenerator;

public class Gui_EnergyGenerator extends GuiContainer{
	
	private Tileentity_MagicEnergyGenerator tileentity;

	public Gui_EnergyGenerator(InventoryPlayer inventoryPlayer, Tileentity_MagicEnergyGenerator tileentity_MagicEnergyGenerator) {
		super(new Container_EnergyGenerator(inventoryPlayer, tileentity_MagicEnergyGenerator));
		
		this.tileentity = tileentity_MagicEnergyGenerator;
		
		xSize = 176;
		ySize = 166;
	}
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/magic/energyGenerator.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		
		if(tileentity.getStackInSlot(0) != null){
			int i = tileentity.getEnergyStoredScaled(62);
			
			int barPositionX = 0;
			int barPositionY = 0;
			
			if(tileentity.getStackInSlot(0).getItem() == MItems.energy_crystal_AIR){
				barPositionX = 176;
				barPositionY = 62;
			}else if(tileentity.getStackInSlot(0).getItem() == MItems.energy_crystal_DARKNESS){
				barPositionX = 176;
			}else if(tileentity.getStackInSlot(0).getItem() == MItems.energy_crystal_EARTH){
				barPositionX = 224;
			}else if(tileentity.getStackInSlot(0).getItem() == MItems.energy_crystal_FIRE){
				barPositionX = 208;
			}else if(tileentity.getStackInSlot(0).getItem() == MItems.energy_crystal_LIGHT){
				barPositionX = 192;
			}else{
				barPositionX = 240;
			}
			
			drawTexturedModalRect(guiLeft + 152, guiTop + 8 + 62 - i, barPositionX, barPositionY, 16, i);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_){
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(I18n.format("Magic Energy Generator", new Object[0]), this.xSize / 2 - this.fontRendererObj.getStringWidth("Magic Energy Generator") / 2, 8, 4210752);
	}
}
