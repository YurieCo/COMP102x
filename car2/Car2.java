
/**
 * A class of Car object that can move forward, backward and turn
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import comp102x.ColorImage;
import comp102x.Canvas;
import comp102x.IO;

public class Car2
{
    // instance variables - replace the example below with your own
    private String owner = "NoName";
    private ColorImage carImage = new ColorImage("download.jpg");
    private double gasMileage = 10.0;
    private double gasInTank = 10.0;

    /**
     * Default Constructor for objects of class Car2
     */
    public Car2(){}

    public Car2(String nameOfOwner)
    {
        owner = nameOfOwner;
        carImage = new ColorImage();
    }
    
    public Car2(String nameOfOwner, double newGasMileage)
    {
        owner = nameOfOwner;
        carImage = new ColorImage();
        gasMileage = newGasMileage;
    }
    
    public void moveForward(int dist)
    {
        carImage.setX(carImage.getX() + dist);
        
        double gasUsed = dist / 100.0 * gasMileage;
        gasInTank = gasInTank - gasUsed;
        IO.outputln("Amount of gas used: " + gasUsed + ", gas remained: " + gasInTank);
    }
   
    public void makeTurn(int angle){
        carImage.setRotation(carImage.getRotation() + angle);
    }
    
    public void addGas(double gasToAdd){
        gasInTank = gasInTank + gasToAdd;
    }
    
    public void Car2Demo(){
        Canvas canvas = new Canvas();
        canvas.add(carImage, 200, 200);
    }
}
