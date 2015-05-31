package a6;

import java.util.Iterator;
import supplies.Supplies;

public class KnapsackAmountIterator extends KnapsackIterator {

	public KnapsackAmountIterator(
			Iterator<Supplies> foodAmountItr,
			Iterator<Supplies> powerupAmountItr,
			Iterator<Supplies> clothingAmountItr){
		super(foodAmountItr, powerupAmountItr, clothingAmountItr);
	}
	
	@Override
	public int compare(Supplies s1, Supplies s2) {
		// sentinel value of Integer is 0
		// System.out.println(s1+" "+s2); // for debugging
		// inspects null before comparison: if null, set to be sentinel
		int a1 = (s1!=null)?s1.getAmount():0;
		int a2 = (s2!=null)?s2.getAmount():0;
		
		return a2-a1;	
	}

}
