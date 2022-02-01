package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

		
	}

	public void draw()
	{	
		noStroke();
		background(255,0,0);

		//line(10, 10, 200, 200);// x1,y1,x2,y2
		fill(255,255,0);
		circle(250, 300, 400); //cx,cy,r 
		noFill();
		fill(137, 207, 240);
		triangle(250, 20, 50, 450,450, 450); //x1,y1,x2,y2,x3,y3
		noFill();
		fill(244, 194, 194);
		ellipse(250, 250, 200, 90); // cx,cx,w,h
		noFill();
		fill(0);,
		circle(250, 250, 65); //cx,cy,r 
		noFill();

		/* stroke(0);
		fill(0,0,255);
		nofill();
		nostroke(); */

		/* rectMode(CENTER);
		rect(300,20,100,20); //tlx,tly,w,h

		rectMode(CORNER);
		rect(200,20,100,20); //tlx,tly,w,h

		point(20,300);
 */
		
	}
}
