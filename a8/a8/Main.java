package a8.a8;

import javax.swing.JFrame;
import a8.view.AdventureConsole;
import a8.view.AdventureView;
import a8.model.Adventure;
import a8.model.Squad;
import a8.model.SquadImpl;


public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Adventure");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Squad s = SquadImpl.generateSquad(5);		
		Adventure a = new Adventure(Adventure.Difficulty.HARD, s);

		AdventureConsole c = new AdventureConsole(a);
		c.start();

		AdventureView v = new AdventureView(a);
		main_frame.setContentPane(v);

		main_frame.pack();
		main_frame.setVisible(true);	
		
		try {
			c.join();
		} catch (InterruptedException e) {
		}
		System.exit(0);
	}
}
