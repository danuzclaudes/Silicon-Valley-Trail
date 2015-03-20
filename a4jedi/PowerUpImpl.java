package a4jedi;

abstract public class PowerUpImpl extends FoodImpl implements PowerUp {

	private int duration; // number of days the power-up lasts after being used
	
	public PowerUpImpl(int amount, int weight, int price,
						  int fill, int expiration, 
						  int duration, String name){
		super(amount,weight,price,fill,expiration,name);
		this.duration = duration;
	}
	
	public int getDuration() {
		return this.duration;
	}

}
