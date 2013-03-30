package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class WalkwayCell extends BoardCell {
	
	public WalkwayCell(Integer row, Integer column) {
		super(row, column);
	}

	@Override
	public boolean isWalkway() {
		return true;
	}

	@Override
	public void draw(Graphics g, Board b) {
		x = column*GameBoardGUI.getBoardLength()/b.getNumColumns();
		y = row*GameBoardGUI.getBoardHeight()/b.getNumRows();
		width = GameBoardGUI.getBoardLength()/b.getNumColumns();
		height = GameBoardGUI.getBoardHeight()/b.getNumRows();
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
	}
	

}
