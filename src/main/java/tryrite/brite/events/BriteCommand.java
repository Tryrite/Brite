package tryrite.brite.events;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import net.hypixel.api.HypixelAPI;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import tryrite.brite.main.Brite;

public class BriteCommand implements ICommand {

	BriteEventHandler handler;
	Brite brite;

	public BriteCommand(Brite brite) {
		this.brite = brite;
		this.handler = brite.handler;
	}

	@Override
	public String getCommandName() {
		return "brite";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerSP player = (EntityPlayerSP) sender;
		if(args.length==0) {
			if (brite.isConfigured()) {
				handler.displayMenuFlag = true;
			} else {
				throw new CommandException("API key has not been set, use \"/brite setKey APIKEY\" to set the api key");
			}
		} else if(args[0].equals("enable")) {
			if (!brite.isEnabled() && brite.isConfigured()) {
				player.addChatMessage(new ChatComponentText("enabling mod"));
				brite.requestManager.scheduleRequests();
				brite.setEnabled(true);
				brite.configManager.saveSettingsConfig();
			} else if(!brite.isEnabled()){
				throw new CommandException("API key has not been set, use \"/brite setKey APIKEY\" to set the api key");
			} else if(brite.isConfigured())
				throw new CommandException("The mod is already enabled");
		} else if(args[0].equals("disable")) {
			if (brite.isEnabled()) {
				player.addChatMessage(new ChatComponentText("disabling mod"));
				brite.requestManager.cancelSchedule();
				brite.setEnabled(false);
				brite.configManager.saveSettingsConfig();
			} else {
				throw new CommandException("The mod is already disabled");
			}
		} else if(args[0].equals("toggle")) {
			if(args.length>=2) {
				String name = concatonateStrings(Arrays.copyOfRange(args, 1, args.length));
				if(brite.menuManager.doesMenuWithNameExist(name)) {
					brite.menuManager.switchMenuEnableStatus(name);
					brite.configManager.saveMenusConfig();
				} else {
					throw new CommandException("A Menu with that name does not exist");
				}
			}
		} else if(args[0].equals("setkey")) {
			if(args.length>1) {
				brite.hypixel = new HypixelAPI(UUID.fromString(args[1]));
				player.addChatMessage(new ChatComponentText("You have set your key to " + args[1] + " by using this key you acknowledge that this key is your key for this account. Do not use a key from a different account."));
				brite.setAPIKey(UUID.fromString(args[1]));
				brite.configManager.saveSettingsConfig();
				if(brite.menuManager.menus.isEmpty()) {
					brite.menuManager.createDefault();
					brite.configManager.saveMenusConfig();
				}
			}
		} else if(args[0].equals("scale")) {
			double scale;
			if(args.length==2) {
				scale = Double.parseDouble(args[1]);
				brite.menuManager.setAllMenuScale(scale);
			} else if(args.length>=3) {
				String name = concatonateStrings(Arrays.copyOfRange(args, 2, args.length));
				scale = Double.parseDouble(args[1]);
				if(brite.menuManager.doesMenuWithNameExist(name)) {
					brite.menuManager.setMenuScale(name, scale);
					brite.configManager.saveMenusConfig();
				} else {
					throw new CommandException("A Menu with that name does not exist");
				}
			}
			brite.configManager.saveMenusConfig();
		} else {
			throw new CommandException("Incorrect use of Command");
		}
	}
	
	public String concatonateStrings(String... strings) {
		String finalString = "";
		for(int i=0;i<strings.length-1;i++) {
			finalString += strings[i] + " ";
		}
		finalString += strings[strings.length-1];
		return finalString;
	}

	@Override
	public int compareTo(ICommand o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		return new LinkedList<String>();
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return new LinkedList<String>();
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
}
