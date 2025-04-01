package thread.example.future;

import thread.example.Utils.ThreadSleepUtils;

public class SumTask {

    public static void main(String[] args) throws InterruptedException {

        sumRunnable sumRunnable1 = new sumRunnable(1, 50);
        sumRunnable sumRunnable2 = new sumRunnable(51, 100);

        Thread thread1 = new Thread(sumRunnable1);
        Thread thread2 = new Thread(sumRunnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("[총합] : " + (sumRunnable1.sum + sumRunnable2.sum));
    }

    static class sumRunnable implements Runnable {

        private int sum, startNum, endNum;

        public sumRunnable(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        public void run() {
            while (startNum <= endNum) {
                sum += startNum++;
                ThreadSleepUtils.sleep(10);
            }
        }
    }

}
