package a4novice;

public class FoodImpl extends SuppliesImpl implements Food {
	
	private int fill; // nutritional value of the food item
	private int expiration; // number of days until the food expires

	protected FoodImpl(int amount, int weight, 
	   		   		   int price, int fill, 
	   		   		   int expiration, String name){
		super(amount,weight,price,name);
		this.fill = fill;
		this.expiration = expiration;
	}
	
	public void consume() throws NoFoodException {
		if(this.amount == 0) throw new NoFoodException();
		this.amount--;
	}

	public int getDaysTillExpiration() {
		return this.expiration;
	}

	public void age() throws FoodExpiredException {
		if(this.expiration <= 0) throw new FoodExpiredException();
		this.expiration--;
		if(this.expiration == 0) throw new FoodExpiredException();
	}

	public int getFill() {
		return this.fill;
	}

}
