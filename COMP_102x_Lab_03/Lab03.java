import comp102x.ColorImage;
import comp102x.Canvas;

public class Lab03
{  
    
    public void loadAnImage() 
    {
        // Please write your code after this line
        ColorImage image = new ColorImage("A.jpg");
        Canvas canvas = new Canvas(image.getWidth(), image.getHeight());
        canvas.add(image);
    }
    
    public void loadTwoImagesOnTheSameCanvas()
    {
        // Please write your code after this line
        ColorImage imageA = new ColorImage("A.jpg");
        ColorImage imageB = new ColorImage("B.jpg");
        
        Canvas canvas = new Canvas(imageA.getWidth() + imageB.getWidth(), imageA.getHeight());
        canvas.add(imageA, 0, 0);
        canvas.add(imageB, imageA.getWidth(), 0);
    }
    
    public void imageAddition() 
    {    
        // Please write your code after this line
        ColorImage imageA = new ColorImage("A.jpg");
        ColorImage imageB = new ColorImage("B.jpg");
        
        Canvas canvas = new Canvas(imageA.getWidth() * 3 + 20, imageA.getHeight());
        canvas.add(imageA, 0, 0);
        canvas.add(imageB, imageA.getWidth() + 10, 0);
        canvas.add(ColorImage.add(imageA, imageB), imageA.getWidth() * 2 + 20, 0);
    }
   
    public void imageMultiplication() 
    {
        // Please write your code after this line
        ColorImage imageA = new ColorImage("A.jpg");
        ColorImage imageB = new ColorImage("B.jpg");
        
        Canvas canvas = new Canvas(imageA.getWidth() * 3 + 20, imageA.getHeight());
        canvas.add(imageA, 0, 0);
        canvas.add(imageB, imageA.getWidth() + 10, 0);
        canvas.add(ColorImage.multiply(imageA, imageB), imageA.getWidth() * 2 + 20, 0);
    }
    
    public void changeColor()
    {
        ColorImage image = new ColorImage();
        image.increaseRed(40);
        Canvas canvas = new Canvas(image.getWidth(), image.getHeight());
        canvas.add(image);
        
        //image.save();
    }
}
