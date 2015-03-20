package a5adept;

import java.util.Scanner;

import a5adept.Adventure.Difficulty;

public class Main {

	public static void main(String[] args) {
		
		// 1. select difficulty
		Scanner s = new Scanner(System.in);
		System.out.println("Select a hardness by entering an integer "
						 + "(1 = easy, 2 = medium, 3 = difficult)");
		int hardness = s.nextInt();
		
		// initialize mode according to user input
		Adventure.Difficulty mode;
		switch(hardness){
		case 1:
			mode = Difficulty.EASY;
			 
			break;
		case 2:
			mode = Difficulty.MEDIUM;
			
			break;
			
		case 3:
			mode = Difficulty.HARD;
			
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
			
			// prompt for selecting a city
			int index = 1;
			System.out.println("You are in "+current_city.getName()
							  +". Which city would you like to travel to? ");
			for(City city:cities){
				System.out.println(index+". "+city.getName()+" ");
				index++;
			}
			System.out.println("0. Exit");
			
			// user select from 1 to length [1..length] or 0
			selection = s.nextInt();
			
			// invalid input processing
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
