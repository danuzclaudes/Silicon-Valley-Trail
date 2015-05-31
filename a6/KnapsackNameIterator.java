package a6;

import java.util.Iterator;
import supplies.Supplies;

public class KnapsackNameIterator extends KnapsackIterator{
	
	public KnapsackNameIterator(
			Iterator<Supplies> foodNameItr,
			Iterator<Supplies> powerupNameItr,
			Iterator<Supplies> clothingNameItr){
		super(foodNameItr, powerupNameItr, clothingNameItr);
	}
	
	@Override
	public int compare(Supplies s1, Supplies s2) {
		// sentinel value of String to be "{"
		String n1 = (s1!=null)?s1.getName():"{"; 
		String n2 = (s2!=null)?s2.getName():"{";
		return n1.compareToIgnoreCase(n2);
	}
	

}
