package tryrite.brite.configs;

import java.util.HashMap;
import java.util.UUID;
/*
 * This class holds the configuration settings for each player, note each account will need to set their own key
 */
public class ConfigSettings {
	
	public HashMap<UUID,ConfigEntry> playerSettings = new HashMap<UUID,ConfigEntry>();
	
	public static transient final int GuiButtonHeightBorderWidth = 5;
	public static transient final int GuiButtonDefaultWidth = 100;
	
	public void createConfigEntry(UUID playerUUID) {
		playerSettings.put(playerUUID, new ConfigEntry());
	}
	
	public void setKey(UUID playerUUID,UUID key) {
		playerSettings.get(playerUUID).key = key;
	}
	
	public UUID getKey(UUID playerUUID) {
		return playerSettings.get(playerUUID).key;
	}
	
	public void setEnabled(UUID playerUUID,boolean enabled) {
		playerSettings.get(playerUUID).enabled = enabled;
	}
	
	public boolean getEnabled(UUID playerUUID) {
		return playerSettings.get(playerUUID).enabled;
	}
	
	public class ConfigEntry{
		public UUID key = null;
		public boolean enabled = false;
	}
}
