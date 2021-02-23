package Task1.Account;

public class SavingsAccount extends Account
{
    
    // Extend the Account custructor method
    public SavingsAccount(String accountNumber, String customerName)
    {
        super(accountNumber, customerName);
        this.accountType = AccountType.SAVINGS;
    }

    // Add a 20% interest to the account
    public void addInterest()
    {
        deposit(this.getBalance() * 0.2);
    }

    // Check to see if the amount input into the method can be withdrawn
    @Override
    public boolean canWithdraw(double amount)
    {
        if (amount < 0)
        {
            System.out.println("Cannot overdraw a savings account");
            return false;
        }
        else
        {
            return true;
        }
    }
}
