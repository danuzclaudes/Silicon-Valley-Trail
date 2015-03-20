package a5adept;

import supplies.Clothing;
import supplies.Food;
import supplies.PowerUp;
import supplies.Supplies;

public class KnapsackImpl implements Knapsack {
	
	private FoodPouch food_pouch;
	private PowerUpPouch powerup_pouch;
	private ClothingPouch clothing_pouch;
	
	public KnapsackImpl(){
		food_pouch = new FoodPouch();
		clothing_pouch = new ClothingPouch();
		powerup_pouch = new PowerUpPouch();
	}
	
	public void add(Food item) {
		if(item instanceof PowerUp) powerup_pouch.add(item);
		else food_pouch.add(item);
	}

	public void add(PowerUp item) {
		powerup_pouch.add(item);
	}

	public void add(Clothing item) {
		clothing_pouch.add(item); 	
	}

	public void add(Supplies item) {
		if(item instanceof Clothing) clothing_pouch.add(item);
		else if(item instanceof PowerUp) powerup_pouch.add(item);
		else food_pouch.add(item);
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

}
