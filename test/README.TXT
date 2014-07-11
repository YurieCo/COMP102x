------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:
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
   
       Week3Quiz q3 = new Week3Quiz(10.0, 10.0);
       Week3Quiz q4 = new Week3Quiz(10, 10);
       
       IO.outputln(q3.x);
       IO.outputln(q4.x);
   }
}