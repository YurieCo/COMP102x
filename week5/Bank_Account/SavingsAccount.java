
/**
 * SavintsAccount is a subclass of BankAccount
 * 
 * @author Chanseok
 * @version original version from edx COMP102X
 */
import comp102x.IO;
public class SavingsAccount extends BankAccount
{
    double interestRate;

    /**
     * Constructor that makes use of the constructor from super class
     */
    public SavingsAccount(double initialBalance, String name, double rate)
    {
        super(initialBalance, name);
        interestRate = rate;
    }

    /**
     * compund interest computes the compound interest for a given duration
     * 
     * @param duration  the number of times the interest is to be compounded
     */
    public void compoundInterest(int duration){
        for(int i = 1; i <= duration; i++){
            double currentBalance = getBalance();
            deposit(currentBalance * interestRate);
        }
    }
    
    public void setInterestRate(double rate){
        interestRate = rate;
    }
}
