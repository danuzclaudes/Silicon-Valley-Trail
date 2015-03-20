package a4jedi;

import java.util.Random;

abstract public class PersonImpl implements Person {

	protected Person.Status status;
	
	protected int current_hp;
	protected int max_hp;
	
	protected int java_skill;
	
	private String name;
	
	public PersonImpl(String name){	
		if(name==null) throw new IllegalArgumentException();
		this.name = name;
	}
	
	public int getCurrentHP() {
		return current_hp;
	}

	public int getMaxHP() {
		return max_hp;
	}

	public int getSkill() {
		return java_skill;
	}

	public void eat(Food food) throws NoFoodException {
		if(food == null) throw new IllegalArgumentException("Illegal argument");
		food.consume();
//		try{food.consume();} catch(NoFoodException e){}
		
		current_hp = this.getCurrentHP() + food.getFill(); // current > max hp???
		if(this.getCurrentHP()>max_hp) current_hp = max_hp;
		if(this.getCurrentHP()<0) current_hp = 0;
	}

	public Person.Status getStatus() {
		return status;
	}

	public void setStatus(Person.Status new_status) {
		status = new_status;
	}

	public String getName() {
		return name;
	}

	abstract public void special();

}
