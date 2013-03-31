package clueGame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GameBoardGUI extends JFrame {
	private ClueGame game;
	private final static int BOARD_LENGTH = 600;
	private final static int BOARD_HEIGHT = 600;
	
	public GameBoardGUI() {
		//Instantiate the board
		game = new ClueGame();
		try {
			game.loadConfigFiles();
		} catch ( Exception e) {
			System.out.println(e.getMessage());
		}
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		setLayout(new BorderLayout() );
		setSize(670, 710);
		setTitle("Clue Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(game, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void draw() {
		game.repaint();
	}

	public static void main(String[] args) {
		GameBoardGUI gameBoard = new GameBoardGUI();
		gameBoard.draw();
	}
	
	private JMenu createFileMenu()
	{
	  JMenu menu = new JMenu("File");
	  menu.add(createDetectiveNotesItem());
	  menu.add(createFileExitItem());
	  return menu;
	}
	
	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	private JMenuItem createDetectiveNotesItem() {
		JMenuItem item = new JMenuItem("Detective Notes");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetectiveNotesDialog detectiveDialog = new DetectiveNotesDialog();
				detectiveDialog.setVisible(true);
			}
	    });
		return item;
	}
	
	public static int getBoardLength() {
		return BOARD_LENGTH;
	}

	public static int getBoardHeight() {
		return BOARD_HEIGHT;
	}

}
