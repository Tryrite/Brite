package tryrite.brite.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import tryrite.brite.guimenus.BriteMainMenu;
import tryrite.brite.main.Brite;
import tryrite.brite.menus.Menu;
import tryrite.brite.menus.MenuManager;
import tryrite.brite.render.MenuRenderer;

import static java.util.concurrent.TimeUnit.*;

public class BriteEventHandler {

	Brite brite;
	MenuManager menuManager;
	boolean displayMenuFlag = false;

	public BriteEventHandler(Brite brites) {
		this.brite = brites;
		this.menuManager = brites.menuManager;
	}

	@SubscribeEvent
	public void onRenderEvent(RenderGameOverlayEvent.Text event) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		ItemStack playeritem = player.getHeldItem();
		if(brite.isConfigured() && brite.isEnabled())
			for(Menu menu: menuManager.menus) {
				if(menu.enabled)
					MenuRenderer.RenderMenu(menu);
			}
	}

	@SubscribeEvent
	public void onTick(ClientTickEvent event) {
		if(this.displayMenuFlag) {
			Minecraft.getMinecraft().displayGuiScreen(new BriteMainMenu(brite));
			this.displayMenuFlag = false;
		}
	}

	@SubscribeEvent
	public void onPlayerFirstJoin(FMLNetworkEvent.ClientConnectedToServerEvent event) {
		if(brite.isConfigured() && brite.isEnabled())
			brite.requestManager.scheduleRequests();
	}

	@SubscribeEvent
	public void onPlayerDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
		brite.requestManager.cancelSchedule();
	}
}