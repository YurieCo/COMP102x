import comp102x.IO;
import comp102x.Canvas; 

/**
 * The Player class represents the human player in the game
 * It asks for the player's choice on the text terminal
 */
public class Player
{
    private Choice choice; //stores the player's choice
    
    /**
     * Ask the player for the choice and then create the corresponding Choice object
     */
    public void makeChoice()
    {
        IO.outputln("Please input your choice (0=rock, 1=paper, 2=scissors)");
        int type = IO.inputInteger(); 
        choice = new Choice(type);
    }
    
    /**
     * Draw an image that represents the player's choice on the given canvas
     * 
     * @param   canvas      the canvas to draw on
     */
    public void showChoice(Canvas canvas)
    {
        choice.draw(canvas, 0, 480, 0);
    }
    
    /**
     * Get the choice object that represents the player's choice
     * 
     * @return  the choice object that represents the player's choice
     */
    public Choice getChoice()
    {
        return choice;
    }
    
    /**
     * Asks if the player wants to play the game again.
     * 
     * This method output a message on the terminal window to ask if the player wants to play again.
     * A character input is then read from the player. If the character is 'Y' or 'y', the method returns true.
     * If the character is 'N' or 'n', the method returns false. For other characters, the method repeats the same 
     * message on the terminal window to ask if the player wants to play again.
     * 
     * @return Whether the player wants to play again.
     */
    public boolean playAgain()
    {    
        char playerChoice;
        boolean result = false;
        
        // get an input from user
        IO.outputln("Would you want to play game again(y or n)? ");
        playerChoice = IO.inputCharacter();
        
        // until the input is not correct answer. get answer
        while(playerChoice != 'Y' && playerChoice != 'y' && playerChoice != 'N' && playerChoice != 'n'){
            IO.outputln("Would you want to play game again(y or n)? ");
            playerChoice = IO.inputCharacter();
        }
        
        // return the appropriate result
        if( playerChoice == 'y' || playerChoice == 'Y') result = true;
        else if ( playerChoice == 'n' || playerChoice == 'N') result = false;
        
        return result;
    }
}
