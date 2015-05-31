package a8.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import a8.person.Person;

public class SquadStatusListView extends JPanel {
	private PersonView pv;
	
	public SquadStatusListView(Person[] players){

		setLayout(new GridLayout(0,1));
		
		for(Person player:players){
			pv = new PersonView(player);
			add(pv);
		}
	}
}
