package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ddf.minim.analysis.WindowFunction;
import ddf.minim.ugens.Frequency;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    FFT fft;

    float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
        ap = minim.loadFile("heroplanet.mp3", 1024);
        // ap.play();
        // ab = ap.mix;
        colorMode(RGB);

        fft = new FFT(1024,44100);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        float halfh = height/2;
        for ( int i = 0 ;i < ab.size();i++){

            line(i,halfh,i,halfh + ab.get(i) * halfh);
        }


        fft.window(FFT.HAMMING);
        fft.forward(ab);

        stroke(0,255,0);

        for (int i = 0;i < fft.specSize();i++){

            line(i,0,i,fft.getBand(i) * 10);

        }

        int maxIndex = 0;

        for ( int i = 0 ;i < fft.specSize();i++){

            if(fft.getBand(maxIndex) < fft.getBand(i)){
                maxIndex = i;
            }
        }


        float freq = fft.indexToFreq(maxIndex);

        textSize(20);
        fill(255);
        text("Freq:" + freq,100,200);


    }        
}
