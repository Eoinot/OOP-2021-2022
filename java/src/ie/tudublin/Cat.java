package ie.tudublin;

public class Cat extends Animal
{
    public Cat(String name) {
        super(name);
        this.numLives = 9;
        //TODO Auto-generated constructor stub
    }

    private int numLives;

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
        
    }

   

    public void Kill()
    {

        
            if (numLives > 0)
            {
                
                System.out.println("Ouch");
            } else{
                System.out.println("Dead");
            }
            numLives = numLives - 1;
      

    }   
}
