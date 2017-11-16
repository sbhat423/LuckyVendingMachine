import java.util.Random;
/**
 * A LuckyGuessGenerator object will be used to generate a random number between 1-5.
 * This is used by the program to generate the random number for the player to guess.
 * 
 * @author Sharat Bhat 
 * @version 0.1 (2017-08-18)
 */
public class LuckyGuessGenerator
{
    private int randomNumber;

    /**
     * Constructor for objects of class LuckyGuessGenerator
     */
    public LuckyGuessGenerator()
    {
        randomNumber = 0;
    }
    
    /**
     * This method returns a random number between 1 - 5
     */
    int generateRandomNumber()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(5) + 1; /* used to get a random number between 1 to 5
        randomNumber = rand.nextInt(rnumber), range is 0<= randomNumber <rnumber */
        return randomNumber;
    }
}
