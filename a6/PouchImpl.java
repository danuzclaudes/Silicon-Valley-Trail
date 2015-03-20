package a6;

import java.util.ArrayList;
import java.util.List;

import supplies.Supplies;

public class PouchImpl<S extends Supplies> implements Pouch<S> {

	private List<S> items;

	public PouchImpl(){
		items = new ArrayList<S>();
	}

	public void add(S item) {
		items.add(item);
	}

	public int getTotalWeight() {
		int totalWeightOfAllItems = 0;
		for(S item : items){
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
