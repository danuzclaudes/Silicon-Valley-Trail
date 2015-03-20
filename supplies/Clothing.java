package supplies;

public interface Clothing extends Supplies{
//	int getAmount();
//	void setAmount(int amount);
//	
//	int getPoundsPerItem();
//	int getTotalWeight();
//	
//	int getPricePerItem();
//	String getName();
	
	Clothing.Warmth getWarmth();
	
	public enum Warmth {LIGHT, MEDIUM, WARM}
}