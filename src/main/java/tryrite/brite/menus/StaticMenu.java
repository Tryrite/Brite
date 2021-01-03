package tryrite.brite.menus;

import java.util.LinkedList;

import net.hypixel.api.reply.skyblock.BazaarReply;

// a list of items that the user specifies to appear in the menu
public class StaticMenu extends Menu{

	public LinkedList<String> productIds = new LinkedList<String>();
	
	public StaticMenu() {
		
	}

	public StaticMenu(String name) {
		super(name);
	}

	public void addIdToMenu(String productId) {
		productIds.add(productId);
		menuEntries++;
		this.recalculateMenuDimensions();
	}
	
	public void removeIdFromMenu(String productId) {
		productIds.remove(productId);
		menuEntries--;
		this.recalculateMenuDimensions();
	}
	
	public void removeLastIdFromMenu() {
		productIds.removeLast();
		menuEntries--;
		this.recalculateMenuDimensions();
	}

	@Override
	public void setproducts(BazaarReply reply) {
		this.products.clear();
		for(int i=0;i<productIds.size();i++) {
			this.products.add(i, reply.getProduct(productIds.get(i)));
		}
	}
}