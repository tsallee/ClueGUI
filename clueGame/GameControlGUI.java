package clueGame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameControlGUI extends JFrame {

	public GameControlGUI() {
		//Set up frame.
		setSize(800, 200);
		setTitle("Game Control GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 0));
		
		//Set up north panel.
		ControlTopPanel panelNorth = new ControlTopPanel();
		add(panelNorth);
		
		//Set up south panel.
		ControlBottomPanel panelSouth = new ControlBottomPanel();
		add(panelSouth);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		GameControlGUI gameControl = new GameControlGUI();
	}

}
