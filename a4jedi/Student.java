package a4jedi;

import java.util.Random;

public class Student extends PersonImpl implements Person{
	
	public Student(String name){
		super(name);
		status = Person.Status.HEALTHY;
		Random random = new Random();
		max_hp = random.nextInt((120-80)+1)+80;
		current_hp = max_hp;
		java_skill = random.nextInt((70-30)+1)+30;
	}
	
	@Override
	public void special() {
		java_skill += 1;
	}

}
