package tryrite.brite.guimenus;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import tryrite.brite.main.Brite;
import tryrite.brite.menus.Menu;
import tryrite.brite.menus.MenuManager;

public class DeleteMenu extends GuiScreen implements GuiYesNoCallback{
	
	Brite brite;
	MenuManager menuManager;
	Menu selectedMenu;
	
	public DeleteMenu(Brite brite) {
		this.brite = brite;
		this.menuManager = brite.menuManager;
	}
	
	public void initGui() {
		String display = "Save and exit";
		int textWidth = this.fontRendererObj.getStringWidth(display);
		this.buttonList.add(new GuiButton(0, 0, this.height-(this.fontRendererObj.FONT_HEIGHT+10),textWidth+10,this.fontRendererObj.FONT_HEIGHT+10, display));
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawRect(0, 0, this.width, this.height, 0x33000000);
		String display = "Click on a Menu to delete it (be aware clicking on a location";
		String display2 = "where multiple menus overlap may delete the one you didn't mean to)";
		int textWidth = this.fontRendererObj.getStringWidth(display);
		int textWidth2 = this.fontRendererObj.getStringWidth(display2);
		this.drawString(this.fontRendererObj, display, (this.width-textWidth)/2, this.height/16, 0xffffffff);
		this.drawString(this.fontRendererObj, display2, (this.width-textWidth2)/2, this.height/16+this.fontRendererObj.FONT_HEIGHT, 0xffffffff);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		if(menuManager.doesCoordIntersectMenu(mouseX,mouseY)) {
			selectedMenu = menuManager.getFirstIntersectedMenu(mouseX,mouseY);
			GuiYesNo yesNoMenu = new GuiYesNo(this, "Are you sure you want to delete the menu \""+selectedMenu.name+"\"?", "", 0);
			this.mc.displayGuiScreen(yesNoMenu);
			//
			yesNoMenu.setButtonDelay(10);
		}
	}
	
	public void confirmClicked(boolean result, int id) {
        if (result) {
        	menuManager.deleteMenu(selectedMenu);
        }
        this.mc.displayGuiScreen(this);
    }
	
	public void onGuiClosed(){
		brite.configManager.saveMenusConfig();
    }
	
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id){
		case 0:
			this.mc.displayGuiScreen((GuiScreen)null);
			break;
		}
	}
	
	public boolean doesGuiPauseGame() {
        return false;
    }

}
