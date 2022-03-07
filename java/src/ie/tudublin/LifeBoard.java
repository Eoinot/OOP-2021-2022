package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {

    boolean[][] board;

    int size;
    float cellsize;
    PApplet pa;
    

    public LifeBoard(int size , PApplet pa){

        board = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellsize = pa.width /(float) size;
    }

    public void randomise(){
        for(int row = 0; row < size; row++){

            for(int col = 0; col < size; col++){
                float dice = pa.random(1.0f);
                if(dice < 0.5f){
                    board[row][col] = pa.random(1.0f) > 0.5f;
                }
            }
        }

    }
    
}
