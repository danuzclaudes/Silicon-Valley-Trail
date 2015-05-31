package a6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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

	/**
	 * create a copy of the list of items stored in the Pouch as a new List<Supplies> object, 
	 * sort the new list using the library method Collections.sort(), 
	 * and then simply return the iterator provided by the List<Supplies> object's 
	 * iterator() method.
	 */
	public Iterator<Supplies> nameIterator() {
		// 1. copy list of items in Pouch
		List<Supplies> copyPouch = new ArrayList<Supplies>();
		for(Supplies item:items){
			copyPouch.add(item);
		}

		// 2. sort the list by name using Collections.sort()
		Collections.sort(copyPouch, new Comparator<Supplies>(){
			public int compare(Supplies s1, Supplies s2){
				// note: Upper and lowercase letters should be treated the same
				// => String.compareToIgnoreCase
				return (s1.getName().compareToIgnoreCase(s2.getName()) < 0) ? -1 :
					(s1.getName().compareToIgnoreCase(s2.getName()) > 0) ? 1 : 0;
			}
		});

		// 3. return iterator provided by List's iterator() method
		return copyPouch.iterator();
	}

	public Iterator<Supplies> amountIterator() {
		List<Supplies> copyPouch = new ArrayList<Supplies>();
		for(Supplies item:items){
			copyPouch.add(item);
		}

		Collections.sort(copyPouch, new Comparator<Supplies>(){
			public int compare(Supplies s1, Supplies s2){
				// Returns a negative integer, zero, or a positive integer as the first 
				// argument is less than, equal to, or greater than the second. [increasing]
				return s2.getAmount() - s1.getAmount();
			}
		});

		return copyPouch.iterator();
	}

	public Iterator<Supplies> weightIterator() {
		List<Supplies> copyPouch = new ArrayList<Supplies>();
		for(Supplies i:this.items){
			copyPouch.add(i);
		}
		
		Collections.sort(copyPouch, new Comparator<Supplies>(){
			public int compare(Supplies s1, Supplies s2){
				return s2.getTotalWeight() - s1.getTotalWeight();
			}
		});
		
		return copyPouch.iterator();
	}

}
