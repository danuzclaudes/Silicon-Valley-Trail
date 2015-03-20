package a5adept;

import java.util.List;
import java.util.ArrayList;
import supplies.Supplies;

public class ClothingPouch implements Pouch {

	private List<Supplies> items;
	
	public ClothingPouch() {
		items = new ArrayList<Supplies>();
	}
	
	public void add(Supplies item) {
		if (!(item instanceof supplies.Clothing)) {
			throw new IllegalArgumentException("Only clothing should go in a clothing pouch.");
		}
		
		items.add(item);
	}
	
	// Returns the total weight of all items in the pouch
	public int getTotalWeight() {
		int totalWeightOfAllItems = 0;
		for(Supplies item : items){
			totalWeightOfAllItems += item.getTotalWeight();
		}
		
		return totalWeightOfAllItems;
	}

	public Supplies[] getItems() {
		Supplies[] supplies_of_items = new Supplies[items.size()];
		
		int j=0;
		for(Supplies item : items){
			supplies_of_items[j++] = item;
		}
		
		return supplies_of_items;
	}
	
}
