package a5jedi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. select difficulty
		Scanner s = new Scanner(System.in);
		// 1.1 prompt for selecting difficulty
		System.out.println("Select a hardness by entering an integer "
						 + "(1 = easy, 2 = medium, 3 = difficult)");
		int hardness = s.nextInt();
		
		// 1.2 initialize mode according to user input
		Adventure.Difficulty mode;
		switch(hardness){
		case 1:
			mode = Adventure.Difficulty.EASY;
			break;
		case 2:
			mode = Adventure.Difficulty.MEDIUM;
			break;
		case 3:
			mode = Adventure.Difficulty.HARD;
			break;
		default:
			throw new RuntimeException("Invalid choice of hardness");
		}
		
		// 2. initialize squad
		Squad squad = null;
		
		// 3. create an appropriate Adventure object
		Adventure adventure = new Adventure(mode, squad);
		
		// 4. choose next city to travel to until user exists by entering 0:
		int selection = -1;
		City[] cities = adventure.getCities();
		
		do{
			City current_city = adventure.getCurrentCity();
			
			// 4.1 prompt for selecting a city
			int index = 1;
			System.out.println("You are in "+current_city.getName()
							  +". Which city would you like to travel to? ");
			for(City city:cities){
				System.out.println(index+". "+city.getName()+" ");
				index++;
			}
			System.out.println("0. Exit");
			
			// 4.2 user selects from 1 to length [1..length] or 0
			selection = s.nextInt();
			
			// 4.3 invalid input processing
			if(selection > cities.length || selection < 0) continue;
			
			if(selection <= cities.length && selection > 0){
				City next_city = cities[selection-1];
				adventure.travel(next_city);
			}
			// else [if(selection == 0)] break; 
			// note: if user selects 0, should exit immediately
			
		}while(selection != 0);		
	}
}
