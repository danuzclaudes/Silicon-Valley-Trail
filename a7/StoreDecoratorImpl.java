package a7;

public class StoreDecoratorImpl implements Store{

	private Store original_store;
	private City city;
	
	public StoreDecoratorImpl(Store store, City city){
		this.original_store = store;
		this.city = city;
	}
	
	@Override
	public void enter(Squad squad) {
		original_store.enter(squad);
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		String store_city = this.city.getName();
		
		// decide if current city sells this item
		String[] on_sales = this.getItemNames();
		boolean doSale = false;
		for(String sale:on_sales){
			if(item_name.equals(sale)) doSale = true;
		}
		if(!doSale) throw new ItemNotForSaleException();
		
		// decide if item is type of clothing: fleece, t-shirt, button-up
		boolean isClothing = false;
		if( item_name.equals("fleece")  ||
			item_name.equals("t-shirt") ||
			item_name.equals("button-up")){
			isClothing = true;
		}
		
		// delegate base price to original store
		double base_price = original_store.getPrice(item_name);
		
		// decide additional price and tax by city
		double city_tax=0.00, state_tax=0.00;
		
		switch(this.city.getName()){
		case "Chapel Hill":
		case "Charlotte":
			base_price += 0;
			city_tax = 0;
			state_tax = isClothing?0.04:0;
			break;
		case "Atlanta":
			base_price += 0;
			city_tax = 0.03;
			state_tax = isClothing?0.03:0;
			break;
		case "Washington, D.C.":
			base_price += 1.50;
			city_tax = 0.05;
			state_tax = 0;
			break;
		case "New York":
			base_price += 1.50;
			city_tax = 0.05;
			state_tax = isClothing?0.05:0;
			break;
		case "Chicago":
			base_price += 0;
			city_tax = 0.05;
			state_tax = 0;
			break;
		case "Austin":
		case "Minneapolis":
			base_price += 0;
			city_tax = 0;
			state_tax = 0;
			break;
		case "Seattle":
			base_price += 1.50;
			city_tax = 0.04;
			state_tax = 0;
			break;
		case "San Francisco":
			base_price += 1.50;
			city_tax = 0.08;
			state_tax = isClothing?0.05:0;
			break;
		case "Palo Alto":
			base_price += 1.50;
			city_tax = 0;
			state_tax = isClothing?0.05:0;
			break;
		default:
		}
		
		// compute price
		return base_price * ((state_tax+city_tax) + 1);
	}

	@Override
	public String[] getItemNames() {
		String store_city = this.city.getName();

		// four cities do not sell fleece
		if( store_city.equals("Charlotte")||
			store_city.equals("Atlanta")  ||
			store_city.equals("Austin")) {
			return new String[]{
					"bison jerky",
					"burrito",
					"button-up",
					"coffee",
					//"fleece",
					"ramen noodles",
					"Red Bison",
					"sushi",
					"t-shirt"
			};
		} else if (store_city.equals("Seattle")) {
			// Seattle only sells coffee
			return new String[]{"coffee"};
		} else {
			return original_store.getItemNames();
		}
	}

}
