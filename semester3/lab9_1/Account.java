package lab9_1;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {

        try {
            Thread.sleep(5);
        } 
        catch (Exception e) {}

        if (amount >= 0) balance += amount;
    }
}
