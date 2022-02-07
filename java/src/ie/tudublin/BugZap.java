package ie.tudublin;

import javax.print.attribute.TextSyntax;

import com.jogamp.nativewindow.util.Rectangle;

import processing.core.PApplet;

public class BugZap extends PApplet {
	float playerX,playerY,playerWidth;
	float bugX,bugY,bugWidth;
	float halfW = bugWidth / 2;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);

		smooth();
		playerX = width/2;
		playerY = height - 50;
		playerWidth = 50;

		resetBug();

	}

	private void resetBug() {
		bugX = random(bugWidth/2, width -(bugWidth/2));
		bugY = 50;
		bugWidth = 50;
	}

	void moveBug(){
		bugY++;
		bugX += random(-20,20);
	}

	void drawbug(float X,float Y,float W){
		stroke(255);
		noFill();
		triangle(X-halfW, Y+halfW, X, Y-halfW, X + halfW, Y + halfW);
	}
	void drawplayer(float x,float y,float w){

		stroke(255);
		noFill();
		rectMode(CENTER);
		rect(x, y,w, 20);
		line(x, y-10, x, y-20);
		
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			playerX --;
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
			playerX ++;
			System.out.println("Right arrow pressed");
		}
		if (keyCode == DOWN){
			playerY ++;
		}
		if (keyCode == UP){
			playerY --;
		}
		if (key == ' ')
		{
			float halfW = bugWidth/2;
			System.out.println("SPACE key pressed");
			if(playerX > bugX - halfW && playerX < bugX + halfW){
				score++;
				resetBug();
				line(playerX, playerY-10, playerX, bugY);
			}
			else{
				line(playerX, playerY-10, playerX, 0);
			}
		}

		
	}	
	int score = 0;


	
	public void draw() {
		background(0);
		strokeWeight(2);
		drawplayer(playerX, playerY, playerWidth);
		drawbug(bugX, bugY, bugWidth);
		if (frameCount % 20== 0){
			moveBug();
		}
		text("score:" +  score,50,50);


	}
}