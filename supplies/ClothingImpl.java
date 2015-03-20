package supplies;

abstract public class ClothingImpl extends SuppliesImpl implements Clothing {

	private Clothing.Warmth warmth;

	public ClothingImpl(int amount, int weight, 
						   int price, Clothing.Warmth warmth, 
						   String name){
		super(amount,weight,price,name);

		if(!isWarmth(warmth)) throw new IllegalArgumentException(
				"Warmth should be in the range of LIGHT, MEDIUM, WARM!");
		this.warmth = warmth;
	}

	public Clothing.Warmth getWarmth() {
		return this.warmth;
	}

	private static boolean isWarmth(Warmth warmth){
		for(Warmth i : Warmth.values()){
			if((i.toString().equals(warmth.toString()))) return true;
		}
		return false;
	}
}
