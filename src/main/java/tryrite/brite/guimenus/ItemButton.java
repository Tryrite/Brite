package tryrite.brite.guimenus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import tryrite.brite.apimapping.BazaarItemMapping;
import tryrite.brite.apimapping.BazaarItemMapping.Entry;

public class ItemButton extends GuiButton{

	public Entry entry;

	public ItemButton(int buttonId, int x, int y, int widthIn, int heightIn, Entry buttonEntry) {
		super(buttonId, x, y, widthIn, heightIn, buttonEntry.itemName);
		this.entry = buttonEntry;
	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		super.drawButton(mc, mouseX, mouseY);
		RenderHelper.enableGUIStandardItemLighting();
		try {
			mc.getRenderItem().renderItemIntoGUI(entry.stack,this.xPosition+2,this.yPosition+2);
		} catch(Exception e) {
			System.out.println("WE could not draw " + entry.apiName);
		}
		RenderHelper.disableStandardItemLighting();
	}

}
