package a6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import supplies.Supplies;

abstract public class KnapsackIterator implements Iterator<Supplies>, Comparator<Supplies>{

	protected Iterator<Supplies> itr0;
	protected Iterator<Supplies> itr1;
	protected Iterator<Supplies> itr2;
	
	protected List<Supplies> next_items;
	
	public KnapsackIterator(
			Iterator<Supplies> itr0,
			Iterator<Supplies> itr1,
			Iterator<Supplies> itr2){
		this.itr0 = itr0;
		this.itr1 = itr1;
		this.itr2 = itr2;
		
		next_items = new ArrayList<Supplies>(3);

		next_items.add(itr0.hasNext()?itr0.next():null);
		next_items.add(itr1.hasNext()?itr1.next():null);
		next_items.add(itr2.hasNext()?itr2.next():null);
	}
	
	public boolean hasNext(){
		// check if list of next_items has only null values
		for(Supplies item:this.next_items){
			if(item != null) return true;
		}
		return false;
//		return itr0.hasNext() 
//			|| itr1.hasNext()
//			|| itr2.hasNext();
	}

	public Supplies next(){
		if(!hasNext()) throw new NoSuchElementException("Iterator is done");
		Supplies s0 = this.next_items.get(0);
		Supplies s1 = this.next_items.get(1);
		Supplies s2 = this.next_items.get(2);

		/**
		 * return a negative number if s1 should be ordered before s2, 
		 * a positive number if s1 should be ordered after s2, 
		 * and 0 if s1 and s2 are "the same" with respect to order
		 */
		if(compare(s0,s1)<0 && compare(s0,s2)<0) {
			this.next_items.set(0, itr0.hasNext()?itr0.next():null);
			return s0;
		}
		else if(compare(s1,s0)<0 && compare(s1,s2)<0){
			this.next_items.set(1, itr1.hasNext()?itr1.next():null);
			return s1;
		} 
		else {
			this.next_items.set(2, itr2.hasNext()?itr2.next():null);
			return s2;
		}
	}

	public void remove(){
		throw new UnsupportedOperationException();
	}

	/**
	 * note: should check null and set to be sentinel before actual comparison
	 */
	abstract public int compare(Supplies s1, Supplies s2);
}
