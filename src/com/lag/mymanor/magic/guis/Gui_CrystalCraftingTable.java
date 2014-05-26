package com.lag.mymanor.magic.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.lag.mymanor.Reference;
import com.lag.mymanor.magic.containers.Container_CrystalCraftingTable;
import com.lag.mymanor.magic.tileentities.TileEntity_CrystalCraftingTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Gui_CrystalCraftingTable extends GuiContainer{

	public Gui_CrystalCraftingTable(InventoryPlayer invPlayer, TileEntity_CrystalCraftingTable table){
		super(new Container_CrystalCraftingTable(invPlayer, table)); //vytvoreni kontejneru, ktery obsahuje data
		xSize = 176;
		ySize = 166;
				
	}

	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/crystal_crafting_table.png"); // modid, umisteni textury
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y){
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture); //pripojeni textury
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize); //misto na obrazovce od leva, shora, zacatek textury v *.png, velikost textury x, y
	}
}
