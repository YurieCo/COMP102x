
/**
 * Write a description of class CS101Grade here.
 * 
 * @author Chanseok 
 * @version (a version number or a date)
 */
import comp102x.IO;

public class CS101Grade
{
    // static & instance variables
    private static final int examWeight = 70;
    private static final int labWeight = 20;
    private static final int hwWeight = 10;
    
    private double examScore;
    private double labScore;
    private double hwScore;
    private double finalGrade;
    private String studentName;
    
    /**
     * Constructor declaration
     */
    public CS101Grade(String name) {
        studentName = name;
    }
    
    /**
     * Method getScores obtains all scores for a student
     */
    public void getScores(){
        IO.output("Enter your Exam grade: ");
        examScore = IO.inputDouble();
        
        IO.output("Enter your Lab grade: ");
        labScore = IO.inputDouble();
        
        IO.output("Enter your homework grade: ");
        hwScore = IO.inputDouble();
    }
    
    /**
     * Compute final grade as the weighted sum of exam, lab, homework scores
     * 
     * To illustrate the use of the keyword "this" which can be used to make
     * make reference to the current object, that is, the object whose method 
     * or constructor is being called
     * 
     * @param   examScore   Exam score of student
     * @param   labScore    Lab score of student
     * @param   hwScore     Homework score of student
     * @return  Weighted sum of examScore, labScore and hwScore in double type
     */
    public double computeGrade(double examScore, double labScore, double hwScore){
        this.examScore = examScore * (examWeight / 100.0);
        this.labScore = labScore * (labWeight / 100.0);
        this.hwScore = hwScore * (hwWeight / 100.0);
        
        return this.examScore + this.labScore + this.hwScore;
    }
    
    /**
     * Set the finalGrade by calling computeGrade
     */
    public void setFinalGrade(){
        finalGrade = computeGrade(examScore, labScore, hwScore);
    }
    
    /**
     * Output the final results
     */
    public void outputResult(){
        IO.outputln("For " + studentName + ": examScore = " + examScore +
                    " labScore = " + labScore + " hwScore = " + hwScore +
                    " finalGrade = " + finalGrade);
    }
}
