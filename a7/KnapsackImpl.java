package a7;

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
	
	@Override
	public void add(Food item) {
		if(item instanceof PowerUp) powerup_pouch.add((PowerUp)item);
		else food_pouch.add(item);
	}

	@Override
	public void add(PowerUp item) {
		powerup_pouch.add(item);
	}

	@Override
	public void add(Clothing item) {
		clothing_pouch.add(item); 	
	}
	
	/**
	 * good example of Generic parameter+Parent parameter:
	 * 
	 * // ---> Parent type parameters accept either Parent or Children parameter
	 * // ---> Child type parameters won't accept parent or other child type para
	 * 
	 * since it's now PouchImpl<S>.add(S item)
	 * when S is PowerUp type,
	 * => PouchImpl<PowerUp>.add(PowerUp item)
	 * => Children type won't accept Parent [Supplies] Type
	 * => b/c Supplies may not be the specific Children
	 * => Contravariant cast
	 */
	@Override
	public void add(Supplies item) { 
					
		if(item instanceof Clothing) clothing_pouch.add((Clothing) item);
		else if(item instanceof PowerUp) powerup_pouch.add((PowerUp) item); 
		else food_pouch.add((Food) item);
		
		// this.add(item); // note: polymorphism won't work!!!
		// this.add((Clothing) item) or this.add((Food) item) works
	}

	@Override
	public int getTotalWeight() {
		return food_pouch.getTotalWeight()+
			   clothing_pouch.getTotalWeight()+
			   powerup_pouch.getTotalWeight();
	}
	
	/**
	 *  returns an array of all of the supplies in the knapsack.
	 */
	@Override
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

	@Override
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

	@Override
	public void remove(Food item) {
		food_pouch.remove(item);
	}

	@Override
	public void remove(PowerUp item) {
		powerup_pouch.remove(item);
	}

	@Override
	public void remove(Clothing item) {
		clothing_pouch.remove(item);
	}

	@Override
	public void remove(Supplies item) {
		// food_pouch.remove accept only Food type,
		// item is Supplies type, needs casting
		if (item instanceof Food) food_pouch.remove((Food) item);
		else if(item instanceof PowerUp) powerup_pouch.remove((PowerUp) item);
		else clothing_pouch.remove((Clothing) item);
		
		// this.remove(item); // polymorphism won't work! (needs casting item)
	}

	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {
		// when notified a day of travel, all food items are aged
		for(Food f : this.getEdibleSupplies()){
			try{
				f.age();
			} catch(supplies.FoodExpiredException e){
				// if any food items spoil, remove from Knapsack
				this.remove(f);
			}
		}
		
	}

}
