package com.lag.mymanor.magic.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.lag.mymanor.Reference;
import com.lag.mymanor.magic.containers.Container_EnergyGenerator;
import com.lag.mymanor.magic.tileentities.Tileentity_MagicEnergyGenerator;

public class Gui_EnergyGenerator extends GuiContainer{

	public Gui_EnergyGenerator(InventoryPlayer inventoryPlayer, Tileentity_MagicEnergyGenerator tileentity_MagicEnergyGenerator) {
		super(new Container_EnergyGenerator(inventoryPlayer, tileentity_MagicEnergyGenerator));
		
		xSize = 176;
		ySize = 166;
	}
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/magic/energyGenerator.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_){
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(I18n.format("Magic Energy Generator", new Object[0]), this.xSize / 2 - this.fontRendererObj.getStringWidth("Magic Energy Generator") / 2, 8, 4210752);
	}
}
