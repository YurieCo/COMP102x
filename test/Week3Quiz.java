
/**
 * Write a description of class Week3Quiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import comp102x.IO;

public class Week3Quiz
{
   private double x;
   
   public Week3Quiz(int i, double d) {
       x = i + d;
   }
   
   public Week3Quiz(double d, int i) {
       x = i - d;
   }
   
   public static void main(String[] args) {
   
       Week3Quiz q3 = new Week3Quiz(10.0, 10);
       Week3Quiz q4 = new Week3Quiz(10, 10.0);
       
       IO.outputln(q3.x);
       IO.outputln(q4.x);
   }
}
