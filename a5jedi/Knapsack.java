package a5jedi;

import supplies.*;

public interface Knapsack {
	void add(Food item);
	void add(PowerUp item);
	void add(Clothing item);
	void add(Supplies item);
	int getTotalWeight();
	Supplies[] getSupplies();
	Food[] getEdibleSupplies();
}
