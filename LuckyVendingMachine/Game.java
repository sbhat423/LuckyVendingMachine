import java.util.Scanner;
/**
 * A Game object will be responsible for displaying the menus, accepting guess, 
 * checking guess and displaying player information. 
 * It will make use of 1 Player object and 1 LuckyGuessGenerator object.
 * 
 * @author (Sharat Bhat) 
 * @version (version 1, 18/08/2017)
 */
public class Game
{
    private LuckyGuessGenerator generator;
    private boolean isEndOfLoop;
    private boolean isPlayerSetUp;
    private char menuOption;
    private Player player;
    private Scanner scan = new Scanner(System.in);
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        isEndOfLoop = false;
        isPlayerSetUp = false;
        menuOption = '0';
    }

    /**
     * Update the prize amount won based on guessedPrize after finning the guess
     */
    private void addPrizeMoney(char guessedPrize)
    {
        switch (guessedPrize)
        {
            case '1':   player.addItem("Pen");
                        player.addPrizeAmount(10);
                        System.out.print("You have won a Pen, worth $10.");
                        break;
            case '2':   player.addItem("Book");
                        player.addPrizeAmount(20);
                        System.out.print("You have won a Book, worth $20.");
                        break;
            case '3':   player.addItem("DVD");
                        player.addPrizeAmount(30);
                        System.out.print("You have won a DVD, worth $30.");
                        break;
            case '4':   player.addItem("Mouse");
                        player.addPrizeAmount(40);
                        System.out.print("You have won a Mouse, worth $40.");
                        break;
            case '5':   player.addItem("Keyboard");
                        player.addPrizeAmount(50);
                        System.out.println("You have won a Keyboard, worth $50.");
                        break;
        }
    }
    
    /**
     * Update the spent amount after each guess
     */
    private void addSpentMoney(char guessedPrize)
    {
        switch (guessedPrize)
        {
            case '1':   player.addSpentAmount(1);
                        break;
            case '2':   player.addSpentAmount(2);
                        break;
            case '3':   player.addSpentAmount(3);
                        break;
            case '4' :  player.addSpentAmount(4);
                        break;
            case '5':   player.addSpentAmount(5);
                        break;
        }
    }
    
    /**
     * This method is to scan the guessed number, generate a random number, check the guess and to
     * decide to decide what should be done after winning or loosing the guess
     */
    private void checkGuess()
    {
        if (isPlayerSetUp)  // player must be set up before guessing 
        {
            System.out.println();
            System.out.println("Guess a number between 1-5 : ");
            boolean isValidInputFlag = false;
            while ( ! isValidInputFlag)
            {    
                String guessedNumber = scan.next();
                if ( ! isValidNumber(guessedNumber))    // check for validity of the number
                    System.out.println("Enter a number between 1 - 5");
                else
                {
                    isValidInputFlag = true;
                    char guessedPrize = guessedNumber.trim().charAt(0);
                    int guessedPrizeInt = Character.getNumericValue(guessedPrize);
                    System.out.println("\t\t Your Guess : " + guessedPrize);
                    generator = new LuckyGuessGenerator();
                    int luckyPrize = generator.generateRandomNumber();
                    System.out.println("\t\t My Guess : " + luckyPrize);
                    if (guessedPrizeInt != luckyPrize)
                        System.out.println("What a shame! You have won absolutely NOTHING! Please try again.");
                    else
                    {
                        System.out.print("Congradulations!\t");
                        addPrizeMoney(guessedPrize);
                    }
                    addSpentMoney(guessedPrize);
                }
            }
        }
        else
            System.out.println("Error : Player has not been setup!");
        System.out.println();
    }
    
    /**
     * Create a new player with the input name
     */
    private Player createNewPlayer()
    {
        System.out.println();
        System.out.println("Enter Player's Name: ");
        String name = scan.next();
        Player newPlayer = new Player(name);
        return newPlayer;
    }
    
    /**
     * Displays information regarding how the game should be played
     */
    private void displayGameHelp()
    {
        System.out.println("\n\nSteps to play the game :");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1) Setup a Player : Choose option 1 and enter the player name to set up a player.");
        System.out.println("2) Guess a number : Enter a number between 1 to 5. Refer the following table for more information.\n");
        System.out.println("________________________________________________________________");
        System.out.println("| Number Generated | Prize Won   | Prize Worth | Cost to Player |");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|       1          |    Pen      |    $10      |      $1        |");
        System.out.println("|       2          |    Book     |    $20      |      $2        |");
        System.out.println("|       3          |    DVD      |    $30      |      $3        |");
        System.out.println("|       4          |    Mouse    |    $40      |      $4        |");
        System.out.println("|       5          |    Keyboard |    $50      |      $5        |");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Each time player has to spent certain amount to guess, based on the table");
        System.out.println("If the guess is correct you will win the Item but if the guess");
        System.out.println("is wrong you won't win anything. A player has to be set before guessing.");
        System.out.println("\n3) See the items won : Enter 3 to display items won if any and");
        System.out.println("to display the total prize worth and the total cost to player.");
        System.out.println("A player has to be set up before displaying the items won.");
        System.out.println("4) Exit: Enter 5 to exit out of the game.");
        System.out.println("\n\t\t\t\t\t\tEnjoy!!!!");
    }
    
    /**
     * Displays what all items player has won if any, total amount won and total amount spent  
     */
    private void displayItems()
    {
        if (isPlayerSetUp)  // player must be set before showing items won
        {
            int prizeAmount = player.getPrizeAmount();
            if (prizeAmount != 0)
            {
                System.out.println("Player " + player.getPlayerName() + " has won these prizes :");
                player.displayItemsWon();
            }
            else
                System.out.println("Player " + player.getPlayerName() + " has not won anything till now!");
            System.out.println("Worth a total : " + prizeAmount);
            int spentAmount = player.getSpentAmount();
            System.out.println("Total amount spent : " + spentAmount);
        }
        else
            System.out.println("Error : Player has not been setup!");
        System.out.println();
    }
    
    /**
     * Displays menu contents
     */
    private void displayMenu()
    {
        System.out.println("Welcome to the Lucky Vending Machine");
        System.out.println("====================================");
        System.out.println("(1) Set Up New Player");
        System.out.println("(2) Guess A Prize");
        System.out.println("(3) What Have I Won So Far?");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.println("Choose an option");
    }
    
    /**
     * Returns true if the enteredOption is a single digit number and is greater than 
     * or equals to 1 and less than or equals to 5
     */
    private boolean isValidNumber(String enteredOption)
    {
        enteredOption = enteredOption.trim();
        if (enteredOption.length() == 1 && enteredOption.charAt(0) >= '1' && enteredOption.charAt(0) <= '5')    /* number should
        be of single digit and from 1 - 5 */
            return true;
        else
            return false;
    }
    
    /**
     * Method prompts for input as long as the entered number is between 1 - 5
     */
    private char readInputOption()
    {
        boolean isValidInput = false;
        String inputOption = "";
        while ( ! isValidInput)     // User should be prompted till he/she enters a valid input
        {
            inputOption = scan.next();
            if (! isValidNumber(inputOption))   // check if a number is valid
                System.out.println("Enter a number between 1 - 5");
            else
                isValidInput = true;
        }
        return inputOption.trim().charAt(0);
    }
    
    /**
     * Game starts from here and it contains the game logic
     */
    public void startGame()
    {
        while ( ! isEndOfLoop)
        {
            switch (menuOption)
            {
                case '0':   displayMenu();
                            menuOption = readInputOption();
                            break;
                case '1':   player = createNewPlayer();
                            isPlayerSetUp = true;
                            menuOption = '0';   // menu should be displayed after creating a new player
                            break;
                case '2':   checkGuess();
                            menuOption = '0';   // menu should be displayed after guessing a number
                            break;
                case '3':   displayItems();
                            menuOption = '0';   // menu should be displayed after displaying items
                            break;
                case '4':   displayGameHelp();
                            System.out.println();
                            menuOption = '0';   // menu should be displayed after the game help
                            break;
                case '5':   System.out.println("Goodbye. Thank you for playing.\n");
                            isEndOfLoop = true;     // while loop should be ended to terminate the program
                            break;
            }
        }
    }
}
