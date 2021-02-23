/** 
@author Robbie Campbell
*/

package Account;

// The super class account
public abstract class Account implements IAccount{

    // Initialise the variables
    private String accountNumber, customerName;
    private double balance;
    protected AccountType accountType;
    
    // Create the constructor method
    public Account(String accountNumber, String customerName)
    {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }

    // Get the balance of the account
    @Override
    public double getBalance()
    {
        return this.balance;
    }

    // Get the balance of the the account, formatted for the user
    @Override
    public String getStringBalance()
    {
        return String.format("£%.2f", this.balance);
    }

    // Set the initial balance of the account
    @Override
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    // Get the type of account from the user
    @Override
    public AccountType getAccountType()
    {
        return this.accountType;
    }

    // Withdraw money from the account if possible
    @Override
    public void withdraw(double withdrawAmount)
    {
        if (this.canWithdraw(this.balance - withdrawAmount))
        {
            System.out.println("Successfully Withdrawn");
            this.balance -= withdrawAmount;
        }
    }

    // Deposit money into the account
    @Override
    public void deposit(double depositAmount)
    {
        this.balance += depositAmount;
    }

    // Get the account number of the customer
    @Override
    public String getAccountNumber() 
    {
        return this.accountNumber;
    }

    // Get the name of the customer
    @Override
    public String getCustomerName() 
    {
        return this.customerName;
    }

    // Get all neccessary info of the customer
    @Override
    public String getAllInfo() 
    {
        return String.format("Customer: %s\nAcc Number: %s\nBalance: %s", this.customerName, this.accountNumber, this.getStringBalance());
    }

    // Override this method in child classes, check to see if withdrawing is possible
    protected abstract boolean canWithdraw(double amount);

}
