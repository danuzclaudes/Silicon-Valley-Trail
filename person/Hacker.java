package person;

import java.util.Random;

import supplies.Food;
import supplies.NoFoodException;

public class Hacker extends PersonImpl implements Person{
	
	boolean beast_mode;
	
	public Hacker(String name){
		super(name);
		status = Person.Status.HEALTHY;
		max_hp = (new Random()).nextInt((100-60)+1)+60;
		current_hp = max_hp;
		java_skill = (new Random()).nextInt((100-60)+1)+60;
		
		beast_mode = false;
	}
	
	@Override
	public void eat(Food food) throws NoFoodException {
		if(food == null) throw new IllegalArgumentException();
		
		food.consume();
//		try{food.consume();} catch(NoFoodException e){}
		
		current_hp = this.getCurrentHP() - food.getFill(); // current < 0???
		if(this.getCurrentHP()>max_hp) current_hp = max_hp;
		if(this.getCurrentHP()<0) current_hp = 0;
	}
	
	@Override 
	public void special(){
		beast_mode = true;
	}
}
