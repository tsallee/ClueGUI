package clueGame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ControlBottomPanel extends JPanel {
		private JTextField rollField;
	public ControlBottomPanel()
	{
		setLayout(new GridLayout(0, 3));
		
		JPanel die = new JPanel();
		JLabel roll = new JLabel("Roll");
		rollField = new JTextField(10);
		rollField.setEditable(false);
		die.add(roll);
		die.add(rollField);
		die.setBorder(new TitledBorder (new EtchedBorder(), "Die"));
		add(die);
		
		JPanel guess = new JPanel();
		guess.setBorder(new TitledBorder (new EtchedBorder(), "Guess"));
		JLabel guessText = new JLabel("Guess");
		guess.add(guessText);
		JTextField guessField = new JTextField(10);
		guessField.setEditable(false);
		guess.add(guessField);
		add(guess);
		
		JPanel result = new JPanel();
		result.setBorder(new TitledBorder (new EtchedBorder(), "Guess Result"));
		JLabel resultText = new JLabel("Response");
		result.add(resultText);
		JTextField resultField = new JTextField(10);
		resultField.setEditable(false);
		result.add(resultField);
		add(result);
		
	}
	
	public void setRoll(int roll) {
		rollField.setText(Integer.toString(roll));
	}

}
