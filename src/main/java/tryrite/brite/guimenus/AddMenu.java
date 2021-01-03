package tryrite.brite.guimenus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import tryrite.brite.apimapping.BazaarItemMapping;
import tryrite.brite.apimapping.BazaarItemMapping.Entry;
import tryrite.brite.main.Brite;
import tryrite.brite.menus.MenuManager;
import tryrite.brite.menus.StaticMenu;
import tryrite.brite.render.MenuRenderer;

public class AddMenu extends GuiScreen{

	Brite brite;
	MenuManager menuManager;

	int scrolledY = 0;
	int buttonHeight;
	ArrayList<ItemButton> itemList = new ArrayList<ItemButton>();
	ArrayList<ItemButton> visibleItems = new ArrayList<ItemButton>();
	StaticMenu menu = new StaticMenu();

	GuiTextField menuTitle;
	GuiTextField searchField;

	int startx;
	int starty;
	String errorString = "";

	boolean movingMenu = false;

	public AddMenu(Brite brite) {
		this.brite = brite;
		this.menuManager = brite.menuManager;
	}

	public void initGui(){
		menu.setMenuUpperLeft((this.width)/4+12, 0);

		Keyboard.enableRepeatEvents(true);
		this.menuTitle = new GuiTextField(1000, this.fontRendererObj, 4, this.height/16+this.fontRendererObj.FONT_HEIGHT, 110, 16);
		this.menuTitle.setMaxStringLength(16);
		this.menuTitle.setEnableBackgroundDrawing(true);
		this.menuTitle.setFocused(true);
		this.menuTitle.setCanLoseFocus(true);

		this.searchField = new GuiTextField(1001, this.fontRendererObj, 4, (this.height/16)*4+this.fontRendererObj.FONT_HEIGHT, 110, 16);
		this.searchField.setMaxStringLength(50);
		this.searchField.setEnableBackgroundDrawing(true);
		this.searchField.setFocused(false);
		this.searchField.setCanLoseFocus(true);

		itemList.clear();
		this.visibleItems.clear();
		this.scrolledY = 0;
		buttonHeight = this.fontRendererObj.FONT_HEIGHT+10;
		this.buttonList.add(new GuiButton(0, 4, (this.height/16)*8,110,buttonHeight, "Create Menu"));
		this.buttonList.add(new GuiButton(1, 4, (this.height/16)*6,110,buttonHeight, "Remove Last Entry"));
		this.buttonList.add(new GuiButton(2, 4, (this.height/16)*10,110,buttonHeight, "Quit Menu Creation"));
		LinkedList<Entry> entries = new LinkedList<Entry>(BazaarItemMapping.itemMap.values());
		for(int i=0;i<entries.size();i++) {
			this.itemList.add(new ItemButton(i+3, this.width-208, (buttonHeight)*i,208,buttonHeight,entries.get(i)));
		}
		this.visibleItems.addAll(itemList);
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawRect(0, 0, this.width, this.height, 0xaa000000);

		String menuNameLabel = "Menu Name:";
		this.drawString(this.fontRendererObj, menuNameLabel, 4, this.height/16, 0xffffffff);

		String searchLabel = "Search Items:";
		this.drawString(this.fontRendererObj, searchLabel, 4, (this.height/16)*4, 0xffffffff);

		for(GuiButton button: this.buttonList) {
			button.drawButton(this.mc, mouseX, mouseY);
		}
		for(ItemButton button: this.visibleItems) {
			button.drawButton(this.mc, mouseX, mouseY);
		}

		if(brite.requestManager.rep!=null) {
			menu.setproducts(brite.requestManager.rep);
		}
		MenuRenderer.RenderMenu(menu);

		this.searchField.drawTextBox();
		this.menuTitle.drawTextBox();

		if(!this.errorString.isEmpty()) {
			this.drawString(this.fontRendererObj, errorString, 4, (this.height/16)*8+22, 0xffff0000);
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
			} else if(this.scrolledY>this.buttonHeight*this.visibleItems.size()-this.height) {
				scrolledAmount = 0;
				this.scrolledY = this.buttonHeight*this.visibleItems.size()-this.height;
			}
			this.updateButtonLocation(scrolledAmount);
		}
	}

	private void updateButtonLocation(int scrollAmount) {
		for(GuiButton button: this.visibleItems) {
			button.yPosition-=scrollAmount;
		}
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		if(mouseButton == 0) {
			for(ItemButton button: this.visibleItems) {
				if(button.mousePressed(this.mc, mouseX, mouseY)) {
					button.playPressSound(this.mc.getSoundHandler());
					this.actionPerformed(button);
				}
			}
		}
		this.searchField.mouseClicked(mouseX, mouseY, mouseButton);
		this.menuTitle.mouseClicked(mouseX, mouseY, mouseButton);

		if(mouseX>=menu.xstart && mouseX<=menu.xend && mouseY>=menu.ystart && mouseY<=menu.yend) {
			movingMenu = true;
			startx = mouseX-menu.xstart;
			starty = mouseY-menu.ystart;
		}
	}

	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		if(movingMenu) {
			menu.setMenuUpperLeft(mouseX-startx, mouseY-starty);
		}
	}

	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if(movingMenu) {
			movingMenu = false;
			startx = 0;
			starty = 0;
		}
	}

	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(this.menuTitle.isFocused() && (Character.isLetter(typedChar) || Character.isDigit(typedChar) || Character.isSpaceChar(typedChar) || keyCode == 14)) {
			this.menuTitle.textboxKeyTyped(typedChar, keyCode);
			this.menu.name = this.menuTitle.getText().trim();
		} else if(this.searchField.isFocused() && (Character.isLetter(typedChar) || Character.isDigit(typedChar) || Character.isSpaceChar(typedChar) || keyCode == 14)) {
			this.searchField.textboxKeyTyped(typedChar, keyCode);
			this.setVisibleItems(this.searchField.getText().trim());
		}
	}

	public void setVisibleItems(String regex) {
		this.scrolledY = 0;
		this.visibleItems.clear();
		Pattern pattern = Pattern.compile(regex.toLowerCase());
		Matcher match;
		for(ItemButton button: this.itemList) {
			match = pattern.matcher(button.entry.itemName.toLowerCase());
			if(match.find()) {
				visibleItems.add(button);
			}
		}
		for(int i=0;i<visibleItems.size();i++) {
			visibleItems.get(i).yPosition = (buttonHeight)*i;
		}
	}

	public void onGuiClosed() {
		brite.configManager.saveMenusConfig();
	}

	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id==0) {
			if(menu.name.isEmpty()) {
				errorString = "Menu name cannot be empty";
			} else if(brite.menuManager.doesMenuWithNameExist(menu.name)) {
				errorString = "Menu name is already taken";
			} else if(menu.productIds.isEmpty()) {
				errorString = "Menu must have at least one entry";
			} else {
				brite.menuManager.addMenu(menu);
				this.mc.displayGuiScreen((GuiScreen)null);
			}
		} else if(button.id==1) {
			if(!menu.productIds.isEmpty()) {
				menu.removeLastIdFromMenu();
			}
		} else if(button.id==2) {
			this.mc.displayGuiScreen((GuiScreen)null);
		}
		if(button instanceof ItemButton) {
			ItemButton itemButton = (ItemButton)button;
			menu.addIdToMenu(itemButton.entry.apiName);
		}
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	public void updateScreen() {
		if(this.menuTitle.isFocused()) {
			this.menuTitle.updateCursorCounter();
		} else if(this.searchField.isFocused()) {
			this.searchField.updateCursorCounter();
		}
	}

}