package tryrite.brite.menus;

import java.util.LinkedList;

public class MenuManager {
	
	public LinkedList<StaticMenu> menus = new LinkedList<StaticMenu>();
	
	public MenuManager() {
	}
	
	public void createDefault() {
		StaticMenu one = new StaticMenu("Example");
		one.addIdToMenu("ENCHANTED_WATER_LILY");
		one.addIdToMenu("WATER_LILY");
		one.addIdToMenu("FUMING_POTATO_BOOK");
		one.addIdToMenu("GREEN_CANDY");
		one.setMenuUpperLeft(0, 0);
		menus.add(one);
	}
	
	public void createStaticMenu(String name) {
		menus.add(new StaticMenu(name));
	}
	
	public void addMenu(StaticMenu menu) {
		this.menus.add(menu);
	}
	
	public boolean doesCoordIntersectMenu(int x, int y) {
		for(Menu menu: this.menus) {
			if(menu.enabled && x>=menu.xstart && x<=menu.xend && y>=menu.ystart && y<=menu.yend) {
					return true;
			}
		}
		return false;
	}
	
	//This will return the first menu, so if the user stacks menues for some reason they will eventually get to the one they want
	public Menu getFirstIntersectedMenu(int x, int y) {
		for(Menu menu: this.menus) {
			if(menu.enabled && x>=menu.xstart && x<=menu.xend && y>=menu.ystart && y<=menu.yend) {
					return menu;
			}
		}
		return null;//This shouldn't happen, maybe create a custom exception for this?
	}
	
	public void setAllMenuScale(double scale) {
		for(Menu menu: this.menus) {
			menu.scale = scale;
		}
	}
	
	public void setMenuScale(String name, double scale) {
		Menu selectedMenu = this.getMenuByName(name);
		selectedMenu.scale = scale;
	}
	
	public void switchMenuEnableStatus(String name) {
		Menu selectedMenu = this.getMenuByName(name);
		selectedMenu.enabled = !selectedMenu.enabled;
	}
	
	public boolean doesMenuWithNameExist(String name) {
		for(Menu menu: this.menus) {
			if(menu.name.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public Menu getMenuByName(String name) {
		for(Menu menu: this.menus) {
			if(menu.name.equalsIgnoreCase(name)) {
				return menu;
			}
		}
		return null;
	}

	public void deleteMenu(Menu menu) {
		menus.remove(menu);
	}
}
