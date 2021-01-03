package tryrite.brite.guimenus;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import tryrite.brite.main.Brite;

public class BriteMainMenu extends GuiScreen{
	
	Brite brite;
	
	public BriteMainMenu(Brite brite) {
		this.brite = brite;
	}
	
	public void initGui() {
		int top = this.height/2-40;
        this.buttonList.add(new GuiButton(0, this.width/2-100, top, "Add Menu"));
        this.buttonList.add(new GuiButton(1, this.width/2-100, top+20, "Delete Menu"));
        this.buttonList.add(new GuiButton(2, this.width/2-100, top+40, "Move Menus"));
        this.buttonList.add(new GuiButton(3, this.width/2-100, top+60, "Enable/Disable Menus"));
        //this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 4 - 8, "Edit Menu"));Will add ability to edit menus soon
    }

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 0:
                Minecraft.getMinecraft().displayGuiScreen(new AddMenu(brite));
                break;
            case 1:
                Minecraft.getMinecraft().displayGuiScreen(new DeleteMenu(brite));
                break;
            case 2:
            	Minecraft.getMinecraft().displayGuiScreen(new MoveMenu(brite));
                break;
            case 3:
            	Minecraft.getMinecraft().displayGuiScreen(new EnableDisableMenu(brite));
                break;
            case 4:
            	System.out.println("not done yet");
                break;
        }
    }
	
	public boolean doesGuiPauseGame() {
        return false;
    }
}
