
/**
 * The class represents a player in Lucky Vending Machine simulator.
 * a Player object will remember his own name, what prizes he has won and how much he has spent.
 * 
 * @author Sharat Bhat
 * @version 0.1 (2017-08-18)
 */
public class Player
{
    private String[] individualItems;
    private String playerName;
    private String prizesWon;
    private int spentAmount;
    private int totalWorth;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        playerName = name;
        prizesWon = "";
        totalWorth = 0;
        spentAmount = 0;
    }
    
    /**
     * Adds an item to the string prizeWon
     */
    public void addItem(String item)
    {
        prizesWon = prizesWon + " " + item;
    }
    
    /**
     * Adds amount of the prize won to the integer totalWorth
     */
    public void addPrizeAmount(int amount)
    {
        totalWorth = totalWorth + amount;
    }
    
    /**
     * Adds amount spent to the integer spentAmount
     */
    public void addSpentAmount(int amountSpent)
    {
        spentAmount = spentAmount + amountSpent;
    }
    
    /**
     * Displays all the items in the String items seperated by space
     */
    public void displayItemsWon()
    {
        prizesWon = prizesWon.trim();
        individualItems = prizesWon.split(" ");     /* String prizeWon will be split at " " and each splitted
        string is stored in an array of Strings individualItems */
        for (String items : individualItems)
        {
            System.out.print(items + " ");  // each item is displayed seperated by space
        }
        System.out.println();
    }
    
    /**
     * Method to get the name of the player
     */
    public String getPlayerName()
    {
        return playerName;
    }
    
    /**
     * Method to get the total worth
     */
    public int getPrizeAmount()
    {
        return totalWorth;
    }
    
    /**
     * Method to get the amount spent
     */
    public int getSpentAmount()
    {
        return spentAmount;
    }
    
    /**
     * Method to set the name of the player
     */
    public void setPlayerName(String name)
    {
        playerName = name;
    }
}
