package a5novice;

import java.util.List;
import java.util.ArrayList;
import supplies.Supplies;

public class PowerUpPouch implements Pouch {

	private List<Supplies> items;

	public PowerUpPouch() {
		items = new ArrayList<Supplies>();
	}

	public void add(Supplies item) {
		if (!(item instanceof supplies.PowerUp)) {
			throw new IllegalArgumentException("Only power-ups should go in a power-up pouch.");
		}

		items.add(item);
	}

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
