
/**
 * Write a description of class BankAccount here.
 * 
 * @author chanseok 
 * @version (a version number or a date)
 */

import comp102x.IO;

public class BankAccount
{
    // instance variables - replace the example below with your own
    private double balance = 0.0;
    private String owner = "NoName";

    /**
     * Default Constructor for objects of class BankAccount with zero balance
     */
    public BankAccount(){}
    
    /**
     * Construct a balnce Account with a given initial balance and owner`s name
     * 
     * @param initialBalance    the initial Balance
     * @param name              name of owner
     */
    
    public BankAccount(double initialBalance, String name){
        balance = initialBalance;
        owner = name;
    }

    /**
     * Method for depositing money to the bank account
     */
    public void deposit(double dAmount){
        balance = balance + dAmount;
    }
    
    public void withdraw(double wAmount){
        balance = balance - wAmount;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public static void main(String[] args){
        BankAccount testAccount = new BankAccount();
        
        testAccount.deposit(100);
        testAccount.withdraw(50);
        
        IO.outputln(testAccount.owner + "`s account has a balance of $" + testAccount.balance);
        
        BankAccount myAccount = new BankAccount(100, "cs");
        myAccount.deposit(100);
        myAccount.withdraw(50);
        IO.outputln(myAccount.owner + "`s account has a balance of $" + myAccount.balance);
        
        
    }
}
