package thread.example.task;

import static thread.example.Utils.ThreadSleepUtils.*;

public class SleepRunnable implements Runnable {

    private int sleepTime;

    public SleepRunnable(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public SleepRunnable() {
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "]");
        sleep(sleepTime);
    }
}
