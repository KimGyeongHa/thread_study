package thread.example.LockSupport;

import thread.example.Utils.ThreadSleepUtils;

import java.util.concurrent.locks.LockSupport;

import static thread.example.Utils.ThreadSleepUtils.*;

public class SupportExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new supportTestRunnable());
        thread1.start();
        sleep(100);
        System.out.println(thread1.getState());
        //thread1.interrupt();
        LockSupport.unpark(thread1);
        System.out.println(thread1.getState());
    }


    static class supportTestRunnable implements Runnable{
        @Override
        public void run() {
            LockSupport.park();
        }
    }


}
