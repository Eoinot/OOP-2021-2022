package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
	
	LifeBoard board;

	public void mouseDragged(){

		int col = (int)map(mouseX,0,width,0,board.size);
		int row = (int)map(mouseY,0,width,0,board.size);

		board.setAlive(row,col,true);

	}

	public void settings() {
		size(750, 750);
		board = new LifeBoard(250, this);
		/* board.randomise(); */
		println(board.countCellsAround(1, 1));
		
	}

	public void setup() {
		colorMode(RGB);

	}

	
	public void draw() {
		board.render();
		board.update();
	}
}
