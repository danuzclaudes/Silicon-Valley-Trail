package a4adept;

import java.util.Random;

public class Brogrammer extends PersonImpl implements Person{
	
	//	110 <= Max HP <= 180
	//	10 <= Java Skill <= 40
	public Brogrammer(String name){
		super(name,110,180,10,40,Person.Status.HEALTHY);
	}

	@Override
	public void special(){
		this.setStatus(Status.HEALTHY);
	}
}
