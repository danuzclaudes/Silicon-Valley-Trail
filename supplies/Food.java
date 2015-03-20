package supplies;

public interface Food extends Supplies{
//	int getAmount();
//	void setAmount(int amount);
//	
//	int getPoundsPerItem();
//	int getTotalWeight();
//	
//	int getPricePerItem();
//	String getName();
	
	void consume() throws NoFoodException;
	int getDaysTillExpiration();
	void age() throws FoodExpiredException;
	int getFill();

}