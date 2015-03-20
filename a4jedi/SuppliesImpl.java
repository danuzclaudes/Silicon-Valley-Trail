package a4jedi;

abstract public class SuppliesImpl implements Supplies {

	protected int amount;
	
	private int weight;
	private int price;
	private String name;
	
	public SuppliesImpl(int amount, int weight, int price, String name){
		if(amount < 0) throw new IllegalArgumentException(
					   "Negative amounts is not allowed!");
		this.amount = amount;
		
		this.weight = weight;
		this.price = price;
		this.name = name;
	}	
	
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		if(amount < 0) throw new IllegalArgumentException(
				"Negative amounts is not allowed");
		this.amount = amount;
	}

	public int getPoundsPerItem() {
		return this.weight;
	}

	public int getTotalWeight() {
		return this.getPoundsPerItem() * this.amount;
	}

	public int getPricePerItem() {
		return price;
	}

	public String getName() {
		return name;
	}

}
