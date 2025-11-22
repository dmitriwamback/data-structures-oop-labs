package lab9_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizeThreadsTest {
    
    public static void main(String[] args) {
        
        int sum = 0;
        AtomicInteger sumReference = new AtomicInteger(sum); // passing Integer does nothing

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            service.execute(new AddInteger(sumReference));
        }

        service.shutdown();
        while (!service.isTerminated()) {}

        System.out.println(sumReference.get());
    }

    private static class AddInteger implements Runnable {
        
        private final AtomicInteger integer;

        public AddInteger(AtomicInteger integer) {
            this.integer = integer;
        }

        @Override
        public void run() {
            integer.addAndGet(1);
        }
    }
}
