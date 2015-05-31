package a6;

import java.util.Iterator;

import supplies.Clothing;
import supplies.Food;
import supplies.PowerUp;
import supplies.Supplies;

public class KnapsackImpl implements Knapsack {
	
	private PouchImpl<Food> food_pouch;
	private PouchImpl<PowerUp> powerup_pouch;
	private PouchImpl<Clothing> clothing_pouch;
	
	public KnapsackImpl(){
		food_pouch = new PouchImpl<Food>();
		powerup_pouch = new PouchImpl<PowerUp>();
		clothing_pouch = new PouchImpl<Clothing>();
	}
	
	public void add(Food item) {
		if(item instanceof PowerUp) powerup_pouch.add((PowerUp)item);
		else food_pouch.add(item);
	}

	public void add(PowerUp item) {
		powerup_pouch.add(item);
	}

	public void add(Clothing item) {
		clothing_pouch.add(item); 	
	}
	
	
	// good example of Generic parameter+Parent parameter
	public void add(Supplies item) { 
					// ---> Parent type parameters accept either Parent or Children parameter
		if(item instanceof Clothing) clothing_pouch.add((Clothing) item);
		else if(item instanceof PowerUp) powerup_pouch.add((PowerUp) item);
										// ---> PouchImpl<S>.add(S item)
										// => PouchImpl<PowerUp>.add(PowerUp item)
										// => Children type won't accept Parent [Supplies] Type
										// => b/c Supplies may not be the specific Children
		else food_pouch.add((Food) item);
	}

	public int getTotalWeight() {
		return food_pouch.getTotalWeight()+
			   clothing_pouch.getTotalWeight()+
			   powerup_pouch.getTotalWeight();
	}
	
	// returns an array of all of the supplies in the knapsack.
	public Supplies[] getSupplies() {
		Supplies[] food_supplies = food_pouch.getItems();
		Supplies[] powerup_supplies = powerup_pouch.getItems();
		Supplies[] clothing_supplies = clothing_pouch.getItems();
		
		Supplies[] all_supplies = new Supplies[food_supplies.length+
		                                       powerup_supplies.length+
		                                       clothing_supplies.length];
		int j = 0;
		for(Supplies item:food_supplies){
			all_supplies[j++] = item;
		}
		for(Supplies item:powerup_supplies){
			all_supplies[j++] = item;
		}
		for(Supplies item:clothing_supplies){
			all_supplies[j++] = item;
		}
		
		return all_supplies;
	}

	public Food[] getEdibleSupplies() {
		Supplies[] food_supplies = food_pouch.getItems();
		Supplies[] powerup_supplies = powerup_pouch.getItems();
		
		Food[] edibles = new Food[food_supplies.length+powerup_supplies.length];
		
		int j = 0;
		for(Supplies item:food_supplies){
			edibles[j++] = (Food) item;
		}
		for(Supplies item:powerup_supplies){
			edibles[j++] = (Food) item;
		}
		return edibles;
	}

	/**
	 * keeping track of the next item provided by 
	 * each of the pouch iterators and 
	 * returning the appropriate one when asked for the next item overall. 
	 * 
	 * Then, depending on which pouch it came from, 
	 * replace that item with the next item from the corresponding pouch. 
	 * 
	 * Eventually all of the pouch iterators will run out of items.
	 */
	public Iterator<Supplies> nameIterator() {
		return new KnapsackNameIterator(
				food_pouch.nameIterator(), 
				powerup_pouch.nameIterator(), 
				clothing_pouch.nameIterator());
	}

	public Iterator<Supplies> amountIterator() {
		return new KnapsackAmountIterator(
				food_pouch.amountIterator(), 
				powerup_pouch.amountIterator(), 
				clothing_pouch.amountIterator());
	}

	public Iterator<Supplies> weightIterator() {
		return new KnapsackWeightIterator(
				food_pouch.weightIterator(), 
				powerup_pouch.weightIterator(), 
				clothing_pouch.weightIterator());
	}

}
