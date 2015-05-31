package a8.supplies;

public interface Clothing extends Supplies {
	Clothing.Warmth getWarmth();
	
	public enum Warmth {LIGHT, MEDIUM, WARM}
}