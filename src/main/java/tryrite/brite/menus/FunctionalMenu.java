package tryrite.brite.menus;

import net.hypixel.api.reply.skyblock.BazaarReply;
//Function menues pull products based on predefined functions such as largest buy/sell margins, most volume etc. these can not currently be created by the user
public abstract class FunctionalMenu extends Menu{
	
	public int entryCount = 5;
	
	public FunctionalMenu(String name) {
		super(name);
	}
	
	public void setEntryCount(int newEntryCount) {
		this.entryCount = newEntryCount;
	}

}
