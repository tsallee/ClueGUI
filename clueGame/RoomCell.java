package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class RoomCell extends BoardCell {
	public enum DoorDirection{UP, DOWN, LEFT, RIGHT, NONE}
	
	DoorDirection doorDirection;
	private char initial;
	private boolean flag = true;
	
	public RoomCell(Integer row, Integer column, char initial, DoorDirection doorDirection){
		super(row, column);
		this.initial = initial;
		this.doorDirection = doorDirection;
	}
	
	@Override
	public boolean isRoom(){
		return true;
	}
	
	@Override
	public boolean isDoorway(){
		if(doorDirection != DoorDirection.NONE){
			return true;
		}
		else return false;
	}
	
	public DoorDirection getDoorDirection() {
		return doorDirection;
	}

	public char getInitial() {
		return initial;
	}

	@Override
	public void draw(Graphics g, Board b) {
		
		x = column*GameBoardGUI.getBoardLength()/b.getNumColumns();
		y = row*GameBoardGUI.getBoardHeight()/b.getNumRows();
		width = GameBoardGUI.getBoardLength()/b.getNumColumns();
		height = GameBoardGUI.getBoardHeight()/b.getNumRows();
		
		if ( isDoorway() ) {
			g.setColor(Color.BLUE);
			int div = 4;
			if ( doorDirection.equals(DoorDirection.LEFT) ) {
				g.fillRect(x, y, width/div, height);
			} else if ( doorDirection.equals(DoorDirection.RIGHT) ) {
				g.fillRect(x + (div - 1)*width/div, y, width/div, height);
			} else if ( doorDirection.equals(DoorDirection.UP) ) {
				g.fillRect(x, y, width, height/div);
			} else if ( doorDirection.equals(DoorDirection.DOWN) ) {
				g.fillRect(x, y + (div - 1)*height/div, width, height/div);
			}
		}
		
		
	}

}
