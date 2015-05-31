package a8.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import a8.model.Adventure;
import a8.model.Knapsack;
import a8.model.Squad;
import a8.model.TravelObserver;

public class MiscInfoView extends JPanel implements Observer{
	
	private Adventure adventure;
	private Knapsack knapsack;
	private Squad squad;
	
	private JLabel label;
	
	public MiscInfoView(Adventure adv){
		this.adventure = adv;
		this.squad = adventure.getSquad();
		this.knapsack = squad.getKnapsack();
		knapsack.addObserver(this);
		
		this.setLayout(new GridLayout(1,1));
		
		JPanel budget_panel = new JPanel();
		budget_panel.add(label = new JLabel("Balance: "+squad.getBalance()));
		this.add(budget_panel);

	}

	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if(squad.getBalance() < 1000){
					label.setText("Balance: "+squad.getBalance());
				}
			}
		});
		
		
	}


}
