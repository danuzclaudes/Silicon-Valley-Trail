package a6;

public class Adventure {
	public enum Difficulty{ EASY, MEDIUM, HARD }
	
	private Adventure.Difficulty mode;
	private Squad squad;
	
	// cities corresponding to game mode
	private City[] cities;
	
	private City current_city;
	private int current_day_num;
	
	// distance table between cities
	private int[][] distance_table;

	public Adventure(Difficulty mode, Squad squad){
		this.mode = mode;
		this.squad = squad;
		
		// initialize current city as Chapel Hill;
		current_city = new CityImpl("Chapel Hill",null,null,false);
		
		// initialize current day number as 0;
		current_day_num = 0;
		
		// initialize distance table
		distance_table = new int[][]{
				{0,	140,	380,	271,	500,	784,	1300,	1194,	2849,	2813,	2787},
				{140,	0,	200,	398,	625,	756,	1164,	1166,	2795,	2708,	2682},
				{380,	200,	0,	639,	864,	717,	921,	1112,	2636,	2472,	2446},
				{271,	398,	639,	0,	225,	699,	1524,	1106,	2761,	2817,	2844},
				{500,	625,	864,	225,	0,	790,	1742,	1197,	2852,	2569,	2562},
				{784,	756,	717,	699,	790,	0,	1120,	404,	2064,	2131,	2158},
				{1300,	1164,	921,	1524,	1742,	1120,	0,	1173,	2127,	1759,	1733},
				{1194,	1166,	1112,	1106,	1197,	404,	1173,	0,	1656,	1977,	2004},
				{2849,	2795,	2636,	2761,	2852,	2064,	2127,	1656,	0,	808,	835 },
				{2813,	2708,	2472,	2817,	2569,	2131,	1759,	1977,	808,	0,	33  },
				{2787,	2682,	2446,	2844,	2562,	2158,	1733,	2004,	835,	33,	0  }};
		
		// initialize cities
		switch(mode){
		case EASY:
			// create cities based on easy mode
			cities = new City[]{current_city,
								new CityImpl("Charlotte",null,null,false),
								new CityImpl("Atlanta",null,null,false),
								new CityImpl("Washington, D.C.",null,null,true)}; 
			
			// initialize distance between cities
			initialize_distance(cities, distance_table);
			break;
			
		case MEDIUM:
			// create cities based on easy mode
			cities = new City[]{current_city,
								new CityImpl("Charlotte",null,null,false),
								new CityImpl("Atlanta",null,null,false),
								new CityImpl("Washington, D.C.",null,null,false),
								new CityImpl("New York",null,null,false),
								new CityImpl("Chicago",null,null,false),
								new CityImpl("Austin",null,null,true)};
			// initialize distance between cities
			initialize_distance(cities,distance_table);
			break;
			
		case HARD:
			// create cities based on easy mode
			cities = new City[]{current_city,
								new CityImpl("Charlotte",null,null,false),
								new CityImpl("Atlanta",null,null,false),
								new CityImpl("Washington, D.C.",null,null,false),
								new CityImpl("New York",null,null,false),
								new CityImpl("Chicago",null,null,false),
								new CityImpl("Austin",null,null,false),
								new CityImpl("Minneapolis",null,null,false),
								new CityImpl("Seattle",null,null,false),
								new CityImpl("San Francisco",null,null,false),
								new CityImpl("Palo Alto",null,null,true)};
			
			// initialize distance between cities
			initialize_distance(cities,distance_table);
			break;
			
		default:
			throw new RuntimeException("Invalid mode.");
		}
	}
	
	private void initialize_distance(City[] cities, int[][] distance_table){
		for(int i=0; i<cities.length; i++){
			City current_city = cities[i];
			for(int j=0; j<cities.length; j++){
				current_city.setDistance(cities[j], 
										 distance_table[i][j]);
			}
		}
	}
	
	// implementation of travel functionality from current to next
    public void travel(City next_city){  	
    	// return current day number X
    	int dayX = this.getDay(); 
    	// return distance Y from current city to destination
    	int milesY = this.getCurrentCity().getDistance(next_city);
    	
    	while(milesY>0){
    		System.out.println("Day "+dayX+": You are "+milesY+
    						   " miles away from "+next_city.getName());
    		// updates the day x and the miles y until reach the City
    		dayX++;
    		milesY -= 20;    		
    	}
    	
    	// When you reach the City, update your current City. 
    	this.current_city = next_city; 
    	
    	this.current_day_num = dayX;
    }
    
    public City getCurrentCity(){
    	return this.current_city;
    }
    
    // return the game mode set by constructor
    public Difficulty getDifficulty(){
    	return this.mode;
    }
    
    public int getDay(){
    	return this.current_day_num;
    }
    
    // return all cities corresponding to game mode
    public City[] getCities(){
    	return this.cities;
    }

}
