package a4adept;

public class Student extends PersonImpl implements Person{
	
	// 80 <= Max HP <= 120
	// 30 <= Java Skill <= 70
	public Student(String name){
		super(name,80,120,30,70,Person.Status.HEALTHY);
	}
	
	@Override
	public void special() {
		super.special();
	}

}
