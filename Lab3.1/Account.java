
import java.util.Date;

public class Account {
    
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0.0;
        annualInterestRate = 4.5;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 4.5;
        dateCreated = new Date();
    }

    //------------------------------------------------//
    // Getters
    //------------------------------------------------//

    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    //------------------------------------------------//
    // Setters
    //------------------------------------------------//

    public void setId(int id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    /**
     * @return the monthly interest rate (annual interest rate / 12)
     */
    public double getMonthlyInterestRate() {
        return annualInterestRate/12.0;
    }

    /**
     * @return the monthly interest by multiplying the balance by the monthly interest
     */
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100.0;
    }

    /**
     * this function withdraws money (i.e. deducts from balance)
     * checks if the amount is bigger than the balance
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > balance) return;
        balance -= amount;
    }

    /**
     * this function deposits money (i.e. adds to the balance)
     * @param amount the amount of money to deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }
}
