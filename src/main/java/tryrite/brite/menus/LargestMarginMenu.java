package tryrite.brite.menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import net.hypixel.api.reply.skyblock.BazaarReply;
import net.hypixel.api.reply.skyblock.BazaarReply.Product;

public class LargestMarginMenu extends FunctionalMenu{

	public LargestMarginMenu(String name) {
		super(name);
	}

	@Override
	public void setproducts(BazaarReply reply) {
		LinkedList<BazaarReply.Product> productList = new LinkedList<BazaarReply.Product>();
		boolean added = false;
		for(BazaarReply.Product product: reply.getProducts().values()) {
			added = false;
			double value = product.getQuickStatus().getSellPrice()-product.getQuickStatus().getBuyPrice();
			for(int i=0;i<productList.size();i++)
				if(value<(productList.get(i).getQuickStatus().getSellPrice()-productList.get(i).getQuickStatus().getBuyPrice())) {
					added = true;
					productList.add(i, product);
				}
			if(!added)
				productList.add(product);
		}

		/*productList.sort(new Comparator<BazaarReply.Product>(){
			@Override
			public int compare(BazaarReply.Product one, BazaarReply.Product two) {
				double value = (one.getQuickStatus().getSellPrice()-one.getQuickStatus().getBuyPrice())-(two.getQuickStatus().getSellPrice()-two.getQuickStatus().getBuyPrice());
						if(value>0)
							return 1;
						else if(value<0)
							return -1;
						else
							return 0;
			}
		});*/
		
		this.products = (ArrayList<Product>) productList.subList(0, this.entryCount);
	}
}