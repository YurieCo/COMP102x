import java.util.Random;

import comp102x.ColorImage;
import comp102x.assignment.GameLogic;
import comp102x.assignment.GameRecord;
import comp102x.assignment.Goal;

public class StudentLogic implements GameLogic{
    
    /**
     * Method for generating an intermediate football image for the shooting animation
     * @param   depthImages                 Array of depthImage
     * @param   initialStep                 First step of the animation
     * @param   currentStep                 current step of the animation
     * @param   finalStep                   Last Step of the animation
     * @param   initialScale                Original scale of the image
     * @param   finalScale                  Final scale of the image
     * @param   initialX                    Initial Xposition of image
     * @param   finalX                      Final Xposition of image
     * @param   initialY                    Initial Yposition of image
     * @param   finalY                      Final Yposition of image
     * @return  the selected depthImage     
     */
    public ColorImage generateIntermediateFootballImage(ColorImage[] depthImages, int initialStep, int currentStep, int finalStep, double initialScale, double finalScale, int initialX, int finalX, int initialY, int finalY) {
        // initialize the image
        ColorImage footballImage = new ColorImage();
        
        /* calculate the imageIndex, position, scale */
        int imageIndex = (depthImages.length - 1) * (currentStep - initialStep) / (finalStep - initialStep);
        int xPosition = initialX + (finalX - initialX) * (currentStep - initialStep) / (finalStep - initialStep);
        int yPosition = initialY + (finalY - initialY) * (currentStep - initialStep) / (finalStep - initialStep);
        double scale = initialScale + (finalScale - initialScale) * (currentStep - initialStep) / (finalStep - initialStep);
        
        footballImage = depthImages[imageIndex];
        
        /* set the position of depthImage */
        footballImage.setX(xPosition);
        footballImage.setY(yPosition);
        
        /* set the scale of depthImage */
        footballImage.setScale(scale);
        
        return footballImage;
    }


    /**
     * 
     */
    public void updateGoalPositions(Goal[][] goals) {
       Goal tempGoal = new Goal(Goal.MOVABLE, true);
       Random rand = new Random();
       int numOfRows = goals.length;
       int numOfCols = goals[0].length;
       int[] memberOfRows = new int[3];
       int[] memberOfCols = new int[3];
       int swapRow;
       int swapCol;
       
       for(int i = 0; i < numOfRows; i++){
           for(int j = 0; j < numOfCols; j++){
               if(goals[i][j].getType() == Goal.STATIONARY){
                   if(goals[i][j].isHit()){
                       goals[i][j].setValue(1);
                   }
                }
                else{
                    if(i - 1 < 0){
                        if(j - 1 < 0){
                            memberOfCols[0] = j;
                            memberOfCols[1] = j + 1;
                            swapCol = memberOfCols[rand.nextInt(1)];
                        }
                        else if(j + 1 > numOfCols){
                            memberOfCols[0] = j - 1;
                            memberOfCols[1] = j;
                            swapCol = memberOfCols[rand.nextInt(1)];
                        }
                        else{
                            memberOfCols[0] = j - 1;
                            memberOfCols[1] = j;
                            memberOfCols[2] = j + 1;
                            swapCol = memberOfCols[rand.nextInt(2)];
                        }
                        memberOfRows[0] = i;
                        memberOfRows[1] = i + 1;
                        swapRow = memberOfRows[rand.nextInt(1)];
                    }
                    else if (i + 1 > numOfRows){
                        if(j - 1 < 0){
                            memberOfCols[0] = j;
                            memberOfCols[1] = j + 1;
                            swapCol = memberOfCols[rand.nextInt(1)];
                        }
                        else if(j + 1 > numOfCols){
                            memberOfCols[0] = j - 1;
                            memberOfCols[1] = j;
                            swapCol = memberOfCols[rand.nextInt(1)];
                        }
                        else{
                            memberOfCols[0] = j - 1;
                            memberOfCols[1] = j;
                            memberOfCols[2] = j + 1;
                            swapCol = memberOfCols[rand.nextInt(2)];
                        }
                        memberOfRows[0] = i - 1;
                        memberOfRows[1] = i;
                        swapRow = memberOfRows[rand.nextInt(1)];
                    }
                    else{
                        if(j - 1 < 0){
                            memberOfCols[0] = j;
                            memberOfCols[1] = j + 1;
                            swapCol = memberOfCols[rand.nextInt(1)];
                        }
                        else if(j + 1 > numOfCols){
                            memberOfCols[0] = j - 1;
                            memberOfCols[1] = j;
                            swapCol = memberOfCols[rand.nextInt(1)];
                        }
                        else{
                            memberOfCols[0] = j - 1;
                            memberOfCols[1] = j;
                            memberOfCols[2] = j + 1;
                            swapCol = memberOfCols[rand.nextInt(2)];
                        }
                        memberOfRows[0] = i - 1;
                        memberOfRows[1] = i;
                        memberOfRows[2] = i + 1;
                        swapRow = memberOfRows[rand.nextInt(2)];
                    }
                    
                    if(goals[swapRow][swapCol].getValue() == 1){
                        tempGoal = goals[i][j];
                        goals[i][j] = goals[swapRow][swapCol];
                        goals[swapRow][swapCol] = tempGoal;
                    }
                    
                   if(goals[i][j].isHit()){
                       goals[i][j].setValue(1);
                   }
                }
            }
        }  
    }

    /**
     * 
     */
    public GameRecord[] updateHighScoreRecords(GameRecord[] highScoreRecords, String name, int level, int score) {
        // write your code after this line
        
        
        
        
        
    }
    
    
}
