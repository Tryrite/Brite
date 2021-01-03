package tryrite.brite.render;

import net.hypixel.api.reply.skyblock.BazaarReply;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import tryrite.brite.menus.Menu;

public class MenuRenderer {
	public static void RenderMenu(Menu menu) {
		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.translate(menu.xstart, menu.ystart, 0);
		GlStateManager.scale(menu.scale,menu.scale,menu.scale);
		GlStateManager.translate(-menu.xstart, -menu.ystart, 0);
		
		menu.drawRect(menu.xstart, menu.ystart, menu.xend, menu.yend, 0x77000000);
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
		String displayName;
		if(menu.products.isEmpty() && menu.menuEntries>0)
			displayName = "Loading...";
		else
			displayName = menu.name;
		int nameWidth = fontRenderer.getStringWidth(displayName);
		fontRenderer.drawString(displayName, menu.xstart+((menu.xend-menu.xstart-nameWidth)/2), menu.ystart+2, 0xffffffff);
		menu.drawRect(menu.xstart+5, menu.ystart+fontRenderer.FONT_HEIGHT+2, menu.xend-5, menu.ystart+fontRenderer.FONT_HEIGHT+3, 0xffffffff);
		
		for(int i=0;i<menu.products.size();i++)
			ProductRenderer.RenderProduct(menu.products.get(i),menu.xstart+5,menu.ystart+i*(fontRenderer.FONT_HEIGHT*2+2)+6+fontRenderer.FONT_HEIGHT);
		//GlStateManager.translate(menu.xstart, menu.ystart, 0);
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
	}
}
