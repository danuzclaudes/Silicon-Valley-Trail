package a4adept;

public class ClothingImpl extends SuppliesImpl implements Clothing {

	private Clothing.Warmth warmth;

	protected ClothingImpl(int amount, int weight, 
						   int price, Clothing.Warmth warmth, 
						   String name){
		super(amount,weight,price,name);
		/* check inputs validity*/ 
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
