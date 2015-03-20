package a4novice;

public class ClothingImpl extends SuppliesImpl implements Clothing {
	
	private int warmth;
	
	protected ClothingImpl(int amount, int weight, 
	   		   int price, int warmth, String name){
		super(amount,weight,price,name);
		if(warmth<1 || warmth>3) throw new IllegalArgumentException(
								 "Warmth should be in the range of 1-3!");
		this.warmth = warmth;
	}
	
	public int getWarmth() {
		return this.warmth;
	}

}
