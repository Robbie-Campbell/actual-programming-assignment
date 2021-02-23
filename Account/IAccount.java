package Account;

// Interface for the Account class
public interface IAccount {
    
    // Return the balance
    public double getBalance();

    // Return the formatted balance
    public String getStringBalance();

    // Return the customer account number
    public String getAccountNumber();

    // Return the customer name
    public String getCustomerName();

    // Return the account type
    public AccountType getAccountType();

    // Return all relevant information
    public String getAllInfo();

    // Set the customer balance
    public void setBalance(double balance);

    // Subtract from the customer balance
    public void withdraw(double withdrawAmount);

    // Add to the customer balance
    public void deposit(double depositAmount);

}
