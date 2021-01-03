package tryrite.brite.render;

import net.hypixel.api.reply.skyblock.BazaarReply;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import tryrite.brite.apimapping.BazaarItemMapping;

public class ProductRenderer {
	public static void RenderProduct(BazaarReply.Product product, int x, int y) {
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
		RenderItem itemr = Minecraft.getMinecraft().getRenderItem();
		RenderHelper.enableGUIStandardItemLighting();
		itemr.renderItemIntoGUI(BazaarItemMapping.getItemStack(product.getProductId()),x,y);
		RenderHelper.disableStandardItemLighting();
		if(!product.getBuySummary().isEmpty() && !product.getSellSummary().isEmpty()) {
			fontRenderer.drawString(String.format("%,.2f",product.getBuySummary().get(0).getPricePerUnit()), x+20, y, 0xffa1ffa1);
			fontRenderer.drawString(String.format("%,.2f",product.getSellSummary().get(0).getPricePerUnit()), x+20, y+fontRenderer.FONT_HEIGHT, 0xffffa1a1);
		}
	}
}
