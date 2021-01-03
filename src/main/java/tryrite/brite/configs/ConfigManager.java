package tryrite.brite.configs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import tryrite.brite.main.Brite;
import tryrite.brite.menus.MenuManager;

public class ConfigManager {
	File menuFile;
	File settingsFile;

	Brite brite;
	Gson gson;

	String menuPath = Brite.MODID+"menu.config";
	String settingsPath = Brite.MODID+"settings.config";

	public ConfigManager(Brite brite, File configFile) {
		this.brite = brite;

		this.menuFile = new File(configFile,menuPath);
		this.settingsFile = new File(configFile,settingsPath);

		try {
			menuFile.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}

		try {
			settingsFile.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}

		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public void loadConfig() {
		loadSettingsConfig();
		loadMenusConfig();
	}

	public void loadSettingsConfig() {
		ConfigSettings settings = null;
		try {
			settings = gson.fromJson(new FileReader(settingsFile), ConfigSettings.class);
		} catch(JsonSyntaxException e) {
			e.printStackTrace();
		} catch(JsonIOException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		if(settings==null) {
			settings = new ConfigSettings();
		}
		if(settings.playerSettings.get(brite.playerUUID)==null) {
			settings.createConfigEntry(brite.playerUUID);
		}
		brite.configSettings = settings;
		this.saveSettingsConfig();
	}

	public void loadMenusConfig() {
		MenuManager menuManager = null;
		try {
			menuManager = gson.fromJson(new FileReader(menuFile), MenuManager.class);
		} catch(JsonSyntaxException e) {
			e.printStackTrace();
		} catch(JsonIOException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		if(menuManager==null) {
			menuManager = new MenuManager();
		}
		brite.menuManager = menuManager;
		this.saveMenusConfig();
	}

	public void saveConfig() {
		saveSettingsConfig();
		saveMenusConfig();
	}

	public void saveSettingsConfig() {
		FileWriter write = null;
		try {
			write = new FileWriter(settingsFile);
			gson.toJson(brite.configSettings, write);
		} catch(JsonIOException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				write.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveMenusConfig() {
		FileWriter write = null;
		try {
			write = new FileWriter(menuFile);
			gson.toJson(brite.menuManager,write);
		} catch(JsonIOException e1) {
			e1.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				write.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
