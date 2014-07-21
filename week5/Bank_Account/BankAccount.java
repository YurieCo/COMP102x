
/**
 * A Bank account has a balance and an owner who can make
 * deposits to and withdrawals from the account
 * 
 * @author Chanseok  
 * @version original version from edx COMP102X
 */

import comp102x.IO;
public class BankAccount
{
    // instance variables - replace the example below with your own
    private double balance = 0.0;
    private String owner = "NoName";

    /**
     * Default Constructor for a bank account with zero balnce
     */
    public BankAccount()
    {
    }

    /**
     * Construct a balance account with a given inital balance and owner`s name
     * @param   initialBalance    the initial balance
     * @param   name              name of owner
     */
    public BankAccount(double initialBalance, String name)
    {
        balance = initialBalance;
        owner = name;
    }
    
    /**
     * Method for depositing money to the bank account
     * 
     * @param  dAmount   the amount to be deposited 
     */
    public void deposit(double dAmount)
    {
        balance = balance + dAmount;
    }
    
    /**
     * Method for withdrawing money from the bank account
     * @param wAmount   the amount to be withdrawn
     */
    public void withdraw(double wAmount){
        balance = balance - wAmount;
    }
    
    /**
     * Method for getting the current balance of the bank account
     * @return the current balance
     */
    public double getBalance(){
        return balance;
    }

}
