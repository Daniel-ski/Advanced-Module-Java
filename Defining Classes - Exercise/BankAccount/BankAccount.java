package DefiningClasses_Exercise.BankAccount;

public class BankAccount {
    private static int nextID = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = nextID;
        nextID ++;

    }

    public int getId() {
        return id;
    }

    public static void setInterestRate (double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest (int years){
        return balance * years * interestRate;
    }

    public void deposit (double amount){
        balance += amount;
    }
}
