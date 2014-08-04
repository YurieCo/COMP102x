
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
       
       //IO.outputln(q3.x);
       //IO.outputln(q4.x);
       
       char[] array = {'H', 'K', 'U', 'S', 'T'};
       change(array, 1, 3);
       
       IO.outputln(array[0]);
       IO.outputln(array[1]);
       IO.outputln(array[2]);
       IO.outputln(array[3]);
       IO.outputln(array[4]);
       
       int i = 0;
       int j = 0;

    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            if (j == 1) break;
        }
    }

IO.outputln(i + " " + j);
   }
   
   public static void change(char[] array, int index1, int index2) { 
  
       char temp = array[index2];
       array[index1] = array[index2];
       array[index2] = temp;
  
}
}
