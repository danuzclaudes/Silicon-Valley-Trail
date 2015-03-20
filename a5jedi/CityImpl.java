package a5jedi;

import java.util.HashMap;
import java.util.Map;

public class CityImpl implements City {
	
	private String name;
	private Challenge challenge;
	private Store store;
	private boolean is_goal;
	private boolean is_cleared;
	
	Map<City, Integer> distance_map;
	
	public CityImpl(String name, Challenge challenge, 
				    Store store, boolean is_goal){
		this.name=name;
		this.challenge=challenge;
		this.store=store;
		this.is_goal=is_goal;
		this.is_cleared = false;
		
		distance_map = new HashMap<City, Integer>();
	}
	
	public int getDistance(City other) {
		if(!distance_map.containsKey(other)) 
			throw new IllegalArgumentException("no distance records found");
		return this.distance_map.get(other);
	}

	public void setDistance(City other, int distance) {
		this.distance_map.put(other,distance);
	}

	public String getName() {
		return this.name;
	}

	public boolean isCleared() {
		return this.is_cleared;
	}

	public boolean isGoal() {
		return this.is_goal;
	}

	public void challenge(Squad squad) {
		// challenge() should set the City's cleared property to true 
		// iff the Challenge was passed.
		if(challenge.start(squad)) this.is_cleared = true;
	}

	public void store(Squad squad) {
		// delegate to the enter() method of the encapsulated Store object
		store.enter(squad);

	}

}
