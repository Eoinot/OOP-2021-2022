package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings(){
        size(1024,500);
    }

    public void setup(){
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width,44100,16);
        ab = ai.mix;
        colorMode(HSB);
        float Y = height / 2;
    }
    public void draw(){
        background(0);
        stroke(255);
        float halfH= height/2;
        float average = 0;
        float sum = 0;

        for (int i = 0;i < ab.size();i++){
            float c = map(i,0,ab.size(),0,255);
            line(i,halfH,i,halfH + ab.get(i)*halfH);
            sum += abs(ab.get(i));
            
        }
        average = sum /(float)ab.size();
      

        stroke(255);
        fill(100,255,255);
        lerpeda= lerp(lerpeda,average,0.1f);
        circle(width/2,halfH,average * 100);
        circle(100,Y,50);
        Y += random(-10,10);
    }
    float Y;
    float lerpeda;

    
}
