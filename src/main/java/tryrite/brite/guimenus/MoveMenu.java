package tryrite.brite.guimenus;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import tryrite.brite.main.Brite;
import tryrite.brite.menus.Menu;
import tryrite.brite.menus.MenuManager;

public class MoveMenu extends GuiScreen{

	Brite brite;
	MenuManager menuManager;
	Menu selectedMenu;
	int startx;
	int starty;

	public MoveMenu(Brite brite) {
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
		String display = "Click on a Menu and drag it to move it to a new location";
		int textWidth = this.fontRendererObj.getStringWidth(display);
		this.drawString(this.fontRendererObj, display, (this.width-textWidth)/2, this.height/16, 0xffffffff);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		if(menuManager.doesCoordIntersectMenu(mouseX,mouseY)) {
			selectedMenu = menuManager.getFirstIntersectedMenu(mouseX, mouseY);
			startx = mouseX-selectedMenu.xstart;
			starty = mouseY-selectedMenu.ystart;
		}
		
	}

	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		if(selectedMenu!=null) {
			selectedMenu.setMenuUpperLeft(mouseX-startx, mouseY-starty);
		}
	}

	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if(selectedMenu!=null) {
			selectedMenu = null;
			startx = 0;
			starty = 0;
		}
	}

	public void onGuiClosed() {
		brite.configManager.saveMenusConfig();
	}

	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 0:
			this.mc.displayGuiScreen((GuiScreen)null);
			break;
		}
	}
	
	public boolean doesGuiPauseGame() {
        return false;
    }
}
