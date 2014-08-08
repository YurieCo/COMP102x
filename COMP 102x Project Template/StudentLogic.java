import java.util.Random;
import comp102x.IO;

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
                
        /* calculate the imageIndex, position, scale */
        int imageIndex = (depthImages.length - 1) * (currentStep - initialStep) / (finalStep - initialStep);
        int xPosition = initialX + (finalX - initialX) * (currentStep - initialStep) / (finalStep - initialStep);
        int yPosition = initialY + (finalY - initialY) * (currentStep - initialStep) / (finalStep - initialStep);
        double scale = initialScale + (finalScale - initialScale) * (currentStep - initialStep) / (finalStep - initialStep);
        
        ColorImage footballImage = depthImages[imageIndex];
        
        /* set the position of depthImage */
        footballImage.setX(xPosition);
        footballImage.setY(yPosition);
        
        /* set the scale of depthImage */
        footballImage.setScale(scale);
        
        return footballImage;
    }
    /**
     * Method for changing position between adjacent goals
     * @param goals         whole Goal information
     * @param currentRow    current goal`s Row position
     * @param currentColumn current goal`s Column position
     * @param targetRows    list of possible adjacent goal`s row position 
     * @param targetCols    list of possible adjacent goal`s column position
     * @param swapMap       handle the swapmap to contact each goal just once
     */
    public void swapGoals(Goal[][] goals, int currentRow, int currentColumn, int[] targetRows, int[] targetCols, int[][] swapMap){
        Goal tempGoal = new Goal(0, true);
        Random rand = new Random();
        
        // find the target Row/columns from the list using random generator
        int swapRow = targetRows[rand.nextInt(targetRows.length - 1)];
        int swapColumn = targetCols[rand.nextInt(targetCols.length - 1)];
        
        // if the target position is same to current position, redo.
        while ( swapRow != currentRow && swapColumn != currentColumn){
            swapRow = targetRows[rand.nextInt(targetRows.length - 1)];
            swapColumn = targetCols[rand.nextInt(targetCols.length - 1)];
        }
        
        // if current/target goal can move to another position and being hit, swap the position
        if(goals[swapRow][swapColumn].isHit() && swapMap[swapRow][swapColumn] == 0){
            tempGoal = goals[swapRow][swapColumn];
            goals[swapRow][swapColumn] = goals[currentRow][currentColumn];
            goals[currentRow][currentColumn] = tempGoal;
            swapMap[currentRow][currentColumn] = 1;
            swapMap[swapRow][swapColumn] = 1;
        }
    }

    /**
     * Method for update goalposition and check the boundary of array, made the possible move position list of each goal
     * @param goals whole goal information
     */
    public void updateGoalPositions(Goal[][] goals) {
       int numOfRows = goals.length;
       int numOfCols = goals[0].length;
       
       int[] memberOfRows = new int[3];
       int[] memberOfCols = new int[3];
       
       int[][] swapMap = new int[numOfRows][numOfCols];
       
       // Initialize the swap Map to check the goal is already moved.
       for(int i = 0; i < numOfRows; i++){
           for(int j = 0; j < numOfCols; j++){
               swapMap[i][j] = 0;
           }
       }
       
       // For all goals, check the boundary and made the list of position
       for(int i = 0; i < numOfRows; i++){
           for(int j = 0; j < numOfCols; j++){
           if(goals[i][j].getType() == Goal.STATIONARY){
                   // do nothing
               }
               else{
                   if(i -1 < 0){
                       if (j - 1 < 0){
                           memberOfCols[0] = j;
                           memberOfCols[1] = j + 1;
                       }
                       else if(j + 1 > numOfCols){
                           memberOfCols[0] = j - 1;
                           memberOfCols[1] = j;
                       }
                       else{
                           memberOfCols[0] = j - 1;
                           memberOfCols[1] = j;
                           memberOfCols[2] = j + 1;
                       }
                       memberOfRows[0] = i;
                       memberOfRows[1] = i + 1;
                   }
                   else if( i + 1 > numOfRows){
                       if (j - 1 < 0){
                           memberOfCols[0] = j;
                           memberOfCols[1] = j + 1;
                       }
                       else if(j + 1 > numOfCols){
                           memberOfCols[0] = j - 1;
                           memberOfCols[1] = j;
                       }
                       else{
                           memberOfCols[0] = j - 1;
                           memberOfCols[1] = j;
                           memberOfCols[2] = j + 1;
                       }
                       memberOfRows[0] = i - 1;
                       memberOfRows[1] = i;
                   }
                   else{
                       if (j - 1 < 0){
                           memberOfCols[0] = j;
                           memberOfCols[1] = j + 1;
                       }
                       else if(j + 1 > numOfCols){
                           memberOfCols[0] = j - 1;
                           memberOfCols[1] = j;
                       }
                       else{
                           memberOfCols[0] = j - 1;
                           memberOfCols[1] = j;
                           memberOfCols[2] = j + 1;
                       }
                       memberOfRows[0] = i - 1;
                       memberOfRows[1] = i;
                       memberOfRows[2] = i + 1;
                   }
                   
                   // swap the position using the list which is made previous step
                   swapGoals(goals, i, j, memberOfRows, memberOfCols, swapMap);
               }
           }
       }  
    }
    
    /**
     * Method for sorting the scoreboard using bubble sort
     * @param  highScoreRecords     contain the information of gamescore for previous players
     */
    public void sortingScoreLevelDesc(GameRecord[] highScoreRecords){
        GameRecord tempRecord = new GameRecord("", 0, 0);
        
        /* Sorting records in terms of score by descending order */
        for(int i = 0; i < highScoreRecords.length; i++){
            for(int j = i; j < highScoreRecords.length; j++){
                if(highScoreRecords[i].getScore() < highScoreRecords[j].getScore()){
                    tempRecord = highScoreRecords[j];
                    highScoreRecords[j] = highScoreRecords[i];
                    highScoreRecords[i] = tempRecord;
                }
            }
        }
        
        /* Sorting records in terms of level by descending order */
        for(int i = 0; i < highScoreRecords.length; i++){
            for(int j = i; j < highScoreRecords.length; j++){
                if(highScoreRecords[i].getScore() == highScoreRecords[j].getScore()){
                    if(highScoreRecords[i].getLevel() < highScoreRecords[j].getLevel()){
                        tempRecord = highScoreRecords[j];
                        highScoreRecords[j] = highScoreRecords[i];
                        highScoreRecords[i] = tempRecord;
                    }
                }
            }
        }
    }
    
    /**
     * Method for checking the condition of inserting current player`s record
     * @param   highScoreRecords    contain the information of gamescore for previous players
     * @param   currentGameRecord   current player`s record
     * @param   mode                the variable to check the condition of inserting current player`s record
     */
    public void InsertHighScoreRecords(GameRecord[] highScoreRecords, GameRecord currentGameRecord, int mode){

        switch(mode){    
            /* when the player`s name doesn`t exist in records & previous records length is equal to 10 */
            case 2:
                sortingScoreLevelDesc(highScoreRecords);
                if(highScoreRecords[highScoreRecords.length-1].getScore() < currentGameRecord.getScore()){
                    highScoreRecords[highScoreRecords.length-1] = currentGameRecord;
                }
                
                break;
            
            /* when the player`s name doesn`t exist in records & previous records length is less than 10 */
            case 1:
            /* when the player`s name exists in records*/
            case 3:
                break;
            
            /* default case */
            default:
                // do nothing
                break;
        }
        
        /* sort the gamerecord basd on the record board */
        sortingScoreLevelDesc(highScoreRecords);
    }
    
    /**
     * Method for update the current player`s game record
     * @param   highScoreRecords    contain the information of gamescore for previous players
     * @param   name                current player`s name
     * @param   level               current player`s level
     * @param   score               current player`s score
     * @return  GameRecord being updated
     */
    public GameRecord[] updateHighScoreRecords(GameRecord[] highScoreRecords, String name, int level, int score) {
        // initialize the current Game Record for current player
        GameRecord currentGameRecord = new GameRecord(name, level, score);
        int mode = 0;
        
        if(highScoreRecords.length == 0){
            /* if the highScoreRecord is null, then just insert the current player`s data*/
            GameRecord[] newRecords = new GameRecord[1];
            newRecords[0] = currentGameRecord;
            return newRecords;
        }
        else{
            /* check the name list whether the current name is inside, */
            for(int i = 0; i < highScoreRecords.length; i++){
                if(highScoreRecords[i].getName().equals(name)){
                   /* if the current data`s score is larger than the previous, update the score */
                   if(highScoreRecords[i].getScore() < currentGameRecord.getScore()){
                       highScoreRecords[i] = currentGameRecord;
                   }
                   mode = 3;
                }
            }
            /* if the name does not include in the list and highScoreRecords data is less than 10*/ 
            if(mode != 3 && highScoreRecords.length < 10)  {
                /* made new GameRecord array with additional space */ 
                GameRecord[] updateRecords = new GameRecord[highScoreRecords.length + 1];
                for(int i = 0; i < highScoreRecords.length; i++){
                    updateRecords[i] = highScoreRecords[i];
                }
                
                /* update currentGameRecord in new array */
                updateRecords[highScoreRecords.length] = currentGameRecord;
                mode = 1;
                InsertHighScoreRecords(updateRecords, currentGameRecord, mode);
                return updateRecords;
            }
            else if(mode != 3 && highScoreRecords.length == 10)  mode = 2;
            
            /* insert the current list */
            InsertHighScoreRecords(highScoreRecords, currentGameRecord, mode);
        }
        return highScoreRecords;
    } 
}