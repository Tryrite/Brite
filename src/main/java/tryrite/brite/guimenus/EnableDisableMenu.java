package tryrite.brite.guimenus;

import java.io.IOException;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import tryrite.brite.configs.ConfigSettings;
import tryrite.brite.main.Brite;
import tryrite.brite.menus.Menu;
import tryrite.brite.menus.MenuManager;

public class EnableDisableMenu extends GuiScreen{

	Brite brite;
	MenuManager menuManager;
	int scrolledY = 0;
	int buttonHeight;

	public EnableDisableMenu(Brite brite) {
		this.brite = brite;
		this.menuManager = brite.menuManager;
	}

	public void initGui() {
		int totalButtons = menuManager.menus.size();
		buttonHeight = this.fontRendererObj.FONT_HEIGHT+(ConfigSettings.GuiButtonHeightBorderWidth*2);
		int startX = this.width/2 - ConfigSettings.GuiButtonDefaultWidth/2;

		String display = "Save and exit";
		int textWidth = this.fontRendererObj.getStringWidth(display);
		this.buttonList.add(new GuiButton(0, 0, this.height-(this.fontRendererObj.FONT_HEIGHT+10), textWidth+10, buttonHeight, display));

		for(int i=0;i<menuManager.menus.size();i++)
			this.buttonList.add(new GuiButton(i+1, startX, (buttonHeight)*i, ConfigSettings.GuiButtonDefaultWidth, buttonHeight, menuManager.menus.get(i).name));
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.drawRect(0, 0, this.width, this.height, 0x33000000);
		int color;
		GuiButton button;
		for(int i=1; i<this.buttonList.size(); i++) {
			button = this.buttonList.get(i);
			if(menuManager.menus.get(i-1).enabled) {
				color = 0x7700ff00;
			} else {
				color = 0x77ff0000;
			}
			this.drawRect(button.xPosition, button.yPosition, button.xPosition+button.width, button.yPosition+button.height, color);
		}
	}

	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		int amount = Mouse.getEventDWheel();

		if (amount != 0) {
			if (amount > 0) {
				amount = -1;
			} else if (amount < 0) {
				amount = 1;
			}
			int scrolledAmount = Math.round((amount * 20)/4f);
			this.scrolledY += scrolledAmount;
			if(this.scrolledY<0) {
				scrolledAmount = 0;
				this.scrolledY = 0;
			} else if(this.scrolledY>this.buttonHeight*(this.buttonList.size()-1)-this.height) {
				scrolledAmount = 0;
				this.scrolledY = this.buttonHeight*(this.buttonList.size()-1)-this.height;
			}
			this.updateButtonLocation(scrolledAmount);
		}
	}

	private void updateButtonLocation(int scrollAmount) {
		for(int i=1;i<this.buttonList.size();i++) {
			this.buttonList.get(i).yPosition-=scrollAmount;
		}
	}	

	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id==0) {
			this.mc.displayGuiScreen((GuiScreen)null);
		} else {
			Menu clickedMenu = menuManager.menus.get(button.id-1);
			if(clickedMenu.enabled) {
				clickedMenu.enabled = false;
			} else {
				clickedMenu.enabled = true;
			}
		}
	}

	public void onGuiClosed() {
		brite.configManager.saveMenusConfig();
	}

	public boolean doesGuiPauseGame() {
		return false;
	}
}
