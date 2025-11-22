package lab9_1;

public class AddPennyTask implements Runnable {

    private Account account;

    public AddPennyTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.deposit(1);
    }
    
}
