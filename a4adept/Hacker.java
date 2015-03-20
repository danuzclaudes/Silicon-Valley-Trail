package a4adept;

public class Hacker extends PersonImpl implements Person{
	
	boolean beast_mode;
	
	// 60 <= Max HP <= 100
	// 60 <= Java Skill <= 100
	public Hacker(String name){
		super(name,60,100,60,100,Person.Status.HEALTHY);
	}
	
	@Override
	public void eat(Food food) throws NoFoodException {
		if(food == null) throw new IllegalArgumentException();
		
		food.consume();
//		try{food.consume();} catch(NoFoodException e){}
		
		current_hp = this.getCurrentHP() - food.getFill(); // current < 0???
		if(this.getCurrentHP()>this.getMaxHP()) current_hp = this.getMaxHP();
		if(this.getCurrentHP()<0) current_hp = 0;
	}
	
	@Override 
	public void special(){
		beast_mode = true;
	}
}
