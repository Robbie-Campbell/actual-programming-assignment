import Account.*;

// Run the main method
public class Main
{
    public static void main(String[] args)
    {

        // Test the Savings Account class
        SavingsAccount savings = new SavingsAccount("01234567", "rab");
        savings.setBalance(200);
        System.out.println(savings.getAccountType());
        System.out.println(savings.getStringBalance());
        savings.addInterest();
        System.out.println(savings.getStringBalance());
        savings.withdraw(250);
        System.out.println(savings.getAllInfo());
        System.out.println("-----------------------------------------");
        
        // Test the Checking Account class
        CheckingAccount checking = new CheckingAccount("01234567", "Jack");
        checking.setBalance(200);
        System.out.println(checking.getAccountType());
        System.out.println(checking.getStringBalance());
        checking.withdraw(250);
        System.out.println(checking.getAllInfo());
        System.out.println(checking.isOverdrawn());
        checking.deposit(200);
        System.out.println(checking.getStringBalance());
        System.out.println(checking.isOverdrawn());
    }
}