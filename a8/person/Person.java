package a8.person;

import java.util.Observer;

import a8.supplies.Food;
import a8.supplies.NoFoodException;

public interface Person {
	int getCurrentHP();
	int getMaxHP();
	int getSkill();
	
	void eat(Food food) throws NoFoodException;
	void age();
	
	Person.Status getStatus();
	void setStatus(Person.Status new_status);
	
	String getName();
	
	void addObserver(Observer o);
	
	public enum Status {HEALTHY, NOROVIRUS, DYSENTERY}
}