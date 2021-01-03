package tryrite.brite.menus;

import java.util.ArrayList;
import java.util.LinkedList;
import net.hypixel.api.reply.skyblock.BazaarReply;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public abstract class Menu extends Gui{	
	public int menuEntries = 0;
	
	public int xstart = 0;
	public int ystart = 0;
	
	public int xend = 100;
	public int yend = 100;
	
	public boolean enabled = true;
	
	public double scale = 1.0;
	
	public transient ArrayList<BazaarReply.Product> products = new ArrayList<BazaarReply.Product>();
	
	public String name = "";
	
	public Menu() {
		
	}
	
	public Menu(String name) {
		this.name = name;
	}	
	
	public void setMenuUpperLeft(int x, int y) {
		this.xstart = x;
		this.ystart = y;
		
		this.recalculateMenuDimensions();
	}
	
	public void recalculateMenuDimensions() {
		this.xend = this.xstart+95;
		this.yend = this.ystart+menuEntries*(2*Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT+2)+Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT+8;
	}
	
	public abstract void setproducts(BazaarReply reply);

}
