package a5novice;

import person.Person;

public class SquadImpl implements Squad {
	private Person[] players;
	private Knapsack knapsack;
	private int num_players;
	
	public SquadImpl(int num_players, Knapsack knapsack){
		if(num_players < 1 || knapsack == null) 
			throw new IllegalArgumentException(
			"Illegal argument for SquadImpl.");
		
		this.players = new Person[num_players];
		this.knapsack = knapsack;
		
		this.num_players = num_players;
	}
	
	public int getNumPlayers() {
		return this.num_players;
	}

	public Person getPlayer(int num) {
		if(num < 0 || num > getNumPlayers()-1)
			throw new IllegalArgumentException(
			"Error index for getPlayer.");
		return this.players[num];
	}

	public void setPlayer(int num, Person player) {
		if(num < 0 || num > getNumPlayers()-1)
			throw new IllegalArgumentException(
			"Error index for getPlayer.");
		this.players[num] = player;
	}

	public Knapsack getKnapsack() {
		return this.knapsack;
	}

}
