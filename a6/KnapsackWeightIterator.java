package a6;

import java.util.Iterator;

import supplies.Supplies;

public class KnapsackWeightIterator extends KnapsackIterator{

	public KnapsackWeightIterator(
			Iterator<Supplies> foodWeightItr,
			Iterator<Supplies> powerupWeightItr,
			Iterator<Supplies> clothingWeightItr){
		super(foodWeightItr, powerupWeightItr, clothingWeightItr);
	}

	@Override
	public int compare(Supplies s1, Supplies s2){
		// sentinel value of Integer is 0
		int a1 = (s1!=null)?s1.getTotalWeight():0;
		int a2 = (s2!=null)?s2.getTotalWeight():0;

		return a2-a1;	
	}
}
