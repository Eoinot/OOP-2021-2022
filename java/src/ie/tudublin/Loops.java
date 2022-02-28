package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	float magicMap(float a, float b, float c, float d, float e)
	{
		float output;
		a -= b;
		c -= b;
		e-= d;

		output = ((a/c)*e) + d;

		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e-d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

	float offset = 0;
	public void draw()
	{

		
		switch(mode)	
		{
			case 0:
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float)bars;	
				for(int i = 0 ; i < bars ; i ++)
				{
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break; 
			case 1:

				background(0);
				int squares = (int) (mouseX / 25.0f);
				float h = width / (float)squares;	
				for(int i = 0 ; i < squares ; i ++)
				{
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i,0,squares,0,width);
					rect(x,x,h,h);
					//rect((width-h)-x,x,h,h);

				}
			
				break;
			case 2:

				background(0);
				int circles = (int) (mouseX / 25.0f);
				float c = width / (float)circles;	
				for(int i = 0 ; i < circles ; i ++)
				{
					noStroke();
					fill(map(i, 0, circles, 0, 255), 255, 255);
					float x = map(i,0,circles,0,width);
					ellipse(250, 250, c,c);
					

				}
			
				break;
			
				case 3:
				background(255);
				int circles2 = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float) circles2;
				for (int j = 0; j < circles2; j++) {
					for (int i = 0; i < circles2; i++) {
						noStroke();
						float c1 = map((i + j + offset), 0, circles2 * 2, 0, 255) % 256;
						fill(c1, 255, 255);
						float x = map(i, 0, circles2 - 1, d / 2.0f, width - (d / 2.0f)); 
						float y = map(j, 0, circles2 - 1, d / 2.0f, width - (d / 2.0f)); 
						circle(x, y, d);
					}
				}
				break;
			
			
			case 4:
				background(0);
				colorMode(RGB);
				float border = width * 0.1f;
				for (int i = -5;i<=5;i++)
				{
					float x = map(i,-5,5,border,width-border);
					stroke(0,255,0);
					line(x, border,x,height-border);
					line(border,x,width-border,x);
					fill(255);
					text(i,x,border *0.5f);
					text(i,border*0.5f,x);
				}
				break;

			case 5:
				background(0);
				colorMode(RGB);
				stroke(255);
				float cx = width/2;
				float cy = height/2;
				float radius = 200;
				int sides = (int)map(mouseX,1,width,1,10);
				for (int i = 0;i <= sides;i++)
				{
					float theta = map(i-1,0,sides,0,TWO_PI);
					float x = cx + sin(theta) * radius;
					float y = cy + cos(theta) * radius;
					circle(x,y,20);

					float theta2 = map(i,0,sides,0,TWO_PI);
					float x2 = cx + sin(theta2) * radius;
					float y2 = cy + cos(theta2) * radius;
					line(x,y,x2,y2);
				}
				break;

				
			

				

				
				

		}
	}

    
}
