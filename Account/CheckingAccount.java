package Account;

public class CheckingAccount extends Account
{

    // Extend the Account constructor method
    public CheckingAccount(String accountNumber, String customerName) 
    {
        super(accountNumber, customerName);
        this.accountType = AccountType.CHECKING;
    }

    // Check to see if the amount entered would take the balance below £2000
    // overdrawn 
    @Override
    public boolean canWithdraw(double amount)
    {
        // Check if withdrawal is possible
        if (amount > -2000)
        {
            return true;
        }
        else
        {
            System.out.println("Cannot go more than £2000.00 overdrawn.");
            return false;
        }
    }

    public String isOverdrawn()
    {
        if (this.getBalance() < 0)
            return String.format("You are £%.2f overdrawn", this.getBalance() * -1);
        else
            return "You are not overdrawn";
    }

}
