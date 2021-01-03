package tryrite.brite.main;

import net.hypixel.api.HypixelAPI;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tryrite.brite.configs.ConfigManager;
import tryrite.brite.configs.ConfigSettings;
import tryrite.brite.events.BriteCommand;
import tryrite.brite.events.BriteEventHandler;
import tryrite.brite.menus.MenuManager;
import tryrite.brite.requests.RequestManager;

import java.util.LinkedList;
import java.util.UUID;

import com.google.gson.Gson;

@Mod(modid = Brite.MODID, version = Brite.VERSION, name = "Brite", clientSideOnly = true, acceptedMinecraftVersions = "[1.8.8,1.8.9]")
public class Brite {
	public static final String MODID = "brite";
	public static final String VERSION = "1.0.0";
	public ConfigManager configManager;
	public MenuManager menuManager;
	public ConfigSettings configSettings;
	public BriteEventHandler handler;
	public HypixelAPI hypixel; 
	public RequestManager requestManager = new RequestManager(this);
	public UUID playerUUID;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		playerUUID = Minecraft.getMinecraft().getSession().getProfile().getId();
		configManager = new ConfigManager(this,event.getModConfigurationDirectory());
		configManager.loadConfig();
		if(configSettings.playerSettings.get(playerUUID)!=null)
			hypixel = new HypixelAPI(configSettings.getKey(playerUUID));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		handler = new BriteEventHandler(this);
		ClientCommandHandler.instance.registerCommand(new BriteCommand(this));
		MinecraftForge.EVENT_BUS.register(handler);
	}
	
	public boolean isConfigured() {
		return this.configSettings.getKey(playerUUID) != null ? true : false;
	}
	
	public void setAPIKey(UUID apikey) {
		this.configSettings.setKey(playerUUID, apikey);
	}
	
	public boolean isEnabled() {
		return this.configSettings.getEnabled(playerUUID);
	}
	
	public void setEnabled(boolean value) {
		this.configSettings.setEnabled(playerUUID,value);
	}
}
