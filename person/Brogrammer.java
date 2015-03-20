package person;

import java.util.Random;

public class Brogrammer extends PersonImpl implements Person{
	
	public Brogrammer(String name){
		super(name);
		status = Person.Status.HEALTHY;
		max_hp = (new Random()).nextInt((180-110)+1)+110;
		current_hp = max_hp;
		java_skill = (new Random()).nextInt((40-10)+1)+10;
	}
	
	@Override
	public void special(){
		this.setStatus(Status.HEALTHY);
	}
}
