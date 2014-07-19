import comp102x.ColorImage;
import comp102x.Canvas; 

/**
 * The Choice class represents a choice made by the player or the computer.
 * It can be either "rock", "paper", or "scissors".
 */
public class Choice
{
    private int type; //stores the choice type: 0=rock, 1=paper, 2=scissors
    private ColorImage choiceImage; //stores the image to be displayed on the canvas
    
    /**
     * The constructor
     * 
     * @param   type   the choice type to be represented by this Choice object
     */
    public Choice(int type)
    {
        //initialize the "type" instance varialble
        this.type = type;
    }
    
    /**
     * Get a number that represents the choice type
     * 
     * @return  a number that represents the choice type: 0=rock, 1=paper, 2=scissors
     */
    public int getType()
    {
        return type;
    }
    
    /**
     * Compare "this" with anotherChoice
     * 
     * @param   anotherChoice   the choice to be compared
     * @return  either 1, -1, or 0 which indicates the comparison result: 1 means "this" wins anotherChoice; -1 means "this" loses to anotherChoice; 0 means "this" and anotherChoice are the same
     */
    public int compareWith(Choice anotherChoice)
    {
        int result;
        // if the type is same as another`s, then result will be 0
        if(this.type == anotherChoice.getType()) result = 0;
        else{
            // if user`s type is rock
            if(this.type == 0){
                if(anotherChoice.getType() == 1) result = -1;
                else result = 1;
            }
            // if user`s type is paper
            else if(this.type == 1){
                if(anotherChoice.getType() == 2) result = -1;
                else result = 1;
            }
            // if user`s type is scissor
            else{
                if(anotherChoice.getType() == 0) result = -1;
                else result = 1;
            }
        }
        return result;
    }
    
    /**
     * Draw the choice image (rock/paper/scissors) on the given canvas
     * 
     * @param   canvas      the canvas to draw on
     * @param   x           the x-position of the choice image to be drawn
     * @param   y           the y-position of the choice image to be drawn
     * @param   rotation    the rotation of the choice image to be drawn
     */ 
    public void draw(Canvas canvas, int x, int y, int rotation)
    {
       ColorImage choiceImage;
       
       // find the appropriate image for the type
       switch(this.type){
           case 0:
            choiceImage = new ColorImage("rock.png");
            break;
           
           case 1:
            choiceImage = new ColorImage("paper.png");
            break;
           
           default:
            choiceImage = new ColorImage("scissors.png");
            break;
       }
       
       // define image`s position & rotation
       choiceImage.setX(x);
       choiceImage.setY(y);
       choiceImage.setRotation(rotation);
       canvas.add(choiceImage);
    }
}
