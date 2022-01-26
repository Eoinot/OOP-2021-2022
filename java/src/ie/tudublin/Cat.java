package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;
    public int lives(){
        return numLives;
    }

    public Cat(String name)
    {
        super(name);
        numLives = 9;
    }

    public void Kill(int newLives)
    {

        numLives = newLives;
        while (numLives > 0)
        {
            if (numLives > 0)
            {
                numLives = numLives - 1;
                System.out.println("Ouch");
            } 
        }  
        System.out.println("Dead"); 

    }   
}
