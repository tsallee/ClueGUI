package clueGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class RoomCell extends BoardCell {
	public enum DoorDirection{UP, DOWN, LEFT, RIGHT, NONE}
	
	DoorDirection doorDirection;
	private char initial;
	private String name;
	Font f = new Font("SansSerif", Font.BOLD, 14);
	
	public RoomCell(Integer row, Integer column, char initial, DoorDirection doorDirection){
		super(row, column);
		this.initial = initial;
		this.doorDirection = doorDirection;
		this.name = "";
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isNameCell() {
		if ( name.equals("") )
			return false;
		else
			return true;
	}

	@Override
	public void draw(Graphics g, Board b) {
		/*
		x = (int) Math.round((double) (column - 1)*b.getWidth()/(double) b.getNumColumns());
		y = (int) Math.round((double) (row - 1)*b.getHeight()/(double) b.getNumRows());
		width = (int) getxDimension();
		height = (int) getyDimension();
		*/
		
		x = (column - 1)*b.getWidth()/b.getNumColumns();
		y = (row - 1)*b.getHeight()/(b.getNumRows());
		width = xDimension;
		height = yDimension;
		
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
		if ( isNameCell() ) {
			g.setFont(f);
			g.setColor(Color.BLUE);
			g.drawString(name, x, y);
		}
		
		
	}

}
