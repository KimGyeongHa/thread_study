package thread.example.cas.atomicInteger;

import java.util.ArrayList;
import java.util.List;

import static thread.example.Utils.ThreadSleepUtils.*;

public class AutomaticMain {

    private static final int THREAD_SIZE = 1000;

    public static void main(String[] args) throws InterruptedException {
        increment(new AtomicIncrementInteger());
        //increment(new MyAtomicInteger());
    }

    public static void increment(AtomicIncrementInteger atomicInteger) throws InterruptedException {

        Runnable runnable = new Runnable() {
            public void run() {
                atomicInteger.increment();
            }
        };

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < THREAD_SIZE; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            sleep(10);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(atomicInteger.get());

    }



}
