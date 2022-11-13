package model;

class Pawn {
	private int posX = 0;
	private int posY = 0;
	private int i;
	private int j;
	
	private int pawnNumber;
	
	public Pawn() {
		
	}
	
	public Pawn(int pawnNumber) {
		this.pawnNumber = pawnNumber;
	}
	
	public int[] getCoordinates() {
		int[] position = {this.posX, this.posY};
		return position;
	}
	
	int[] getPosition() {
		int[] position = {this.i, this.j};
		return position;
				
	}
	
	int getPawnNumber() {
		return this.pawnNumber;
	}
	
	public void setCoordinates(int x, int y) {
		this.posX = x;
		this.posY = y;
		return;
	}
	
	public void setPosition(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	

}