package clueGame;

import java.awt.Graphics;

public class BoardCell {
	
	Integer row, column;
	protected int width, height, x, y;

	public BoardCell() {
		row = 0;
		column = 0;
	}

	public BoardCell(Integer row, Integer column){
		this.row = row;
		this.column = column;
	}
	
	public void draw(Graphics g, Board b) {
		
	}
	
	public boolean isWalkway(){
		return false;
	}
	
	public boolean isRoom(){
		return false;
	}
	
	public boolean isDoorway(){
		return false;
	}
	
	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}

}
