package a7;

public class StoreImpl implements Store {

	private StoreImpl(){
		
	}
	
	/**
	 * Factory method that returns a Store instance
	 * 
	 * note:
	 * StoreImpl is also decorated by additional city information
	 */
	public static Store makeStore(City c){
		return new StoreDecoratorImpl(new StoreImpl(),c);
	}
	
	
	@Override
	public void enter(Squad squad) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		switch(item_name){
		case "bison jerky": 
			return 2.00;
		case "burrito":
			return 4.00;
		case "button-up":
			return 10.00;
		case "coffee":
			return 2.50;
		case "fleece":
			return 12.00;
		case "ramen noodles":
			return 0.50;
		case "Red Bison":
			return 3.25;
		case "sushi":
			return 3.75;
		case "t-shirt":
			return 5.00;
		default:
			throw new ItemNotForSaleException();
		}
	}
	
	@Override
	public String[] getItemNames() {
		String[] names = {
				"bison jerky",
				"burrito",
				"button-up",
				"coffee",
				"fleece",
				"ramen noodles",
				"Red Bison",
				"sushi",
				"t-shirt"
		};
		return names;
	}
}
