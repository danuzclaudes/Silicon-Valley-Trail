package a7;

import java.util.ArrayList;
import java.util.List;

import supplies.Supplies;

public class PouchImpl<S extends Supplies> implements Pouch<S> {

	private List<S> items;

	public PouchImpl(){
		items = new ArrayList<S>();
	}

	@Override
	public void add(S item) {
		items.add(item);
	}

	@Override
	public int getTotalWeight() {
		int totalWeightOfAllItems = 0;
		for(S item : items){
			totalWeightOfAllItems += item.getTotalWeight();
		}

		return totalWeightOfAllItems;
	}

	@Override
	public Supplies[] getItems() {
		Supplies[] supplies_of_items = new Supplies[items.size()];

		int j=0;
		for(Supplies item : items){
			supplies_of_items[j++] = item;
		}

		return supplies_of_items;
	}

	@Override
	public void remove(S item) {
		items.remove(item);
	}

}
