package a4adept;

import java.util.Random;

public class PersonImpl implements Person {
	
	private String name; // immutable
	private Person.Status status; // has getter/setter
	private int max_hp;  // immutable
	
	protected int current_hp;
	protected int java_skill;
	
	protected PersonImpl(String name, int minhp, int maxhp,
						 int minskill, int maxskill,
						 Person.Status status){
		if(name==null) throw new IllegalArgumentException();
		this.name = name;
		this.setStatus(status);
		max_hp = (new Random()).nextInt((maxhp-minhp)+1)+minhp;
		
		current_hp = this.getMaxHP();
		java_skill = (new Random()).nextInt((maxskill-minskill)+1)+minskill;
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

	public void special() {
		java_skill += 1;
	}

}
