package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPlayer extends Player {
	
	public HumanPlayer() {
		super();
	}
	
	public HumanPlayer(String name, int location) {
		super(name, location);
	}
	
	@Override
	public void draw(Graphics g, Board b) {
		int x = calcColumn(location, b)*GameBoardGUI.getBoardLength()/b.getNumColumns();
		int y = calcRow(location, b)*GameBoardGUI.getBoardHeight()/b.getNumRows();
		int width = GameBoardGUI.getBoardLength()/b.getNumColumns();
		int height = GameBoardGUI.getBoardHeight()/b.getNumRows();
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	
	public HumanPlayer(String name, int location, String color) {
		super(name, location, color);
	}
	
	public void createSuggestion(String person, String room, String weapon) {
		suggestion = new Suggestion(person, room, weapon);
	}
}
