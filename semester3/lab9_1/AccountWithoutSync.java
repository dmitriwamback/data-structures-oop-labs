package lab9_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {

    private static Account account = new Account();
    
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executor.execute(new AddPennyTask(account));
        }

        executor.shutdown();

        while (!executor.isTerminated()) {}

        System.out.println(account.getBalance());
    }
}
