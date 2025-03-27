package thread.example.cas.spinlock;

import java.util.ArrayList;
import java.util.List;

public class SpinLockMain {

    private static final int THREAD_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    spinLock.lock();
                    System.out.println("로직실행");
                }finally {
                    spinLock.unlock();
                }
            }
        };

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < THREAD_SIZE; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

    }


}
