package org.example;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new runnableMethod(30,50),"thread-1");
        Thread thread2 = new Thread(new runnableMethod(30,50),"thread-2");

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();
    }



    static class runnableMethod implements Runnable{
        int total;
        int sumValue1;
        int sumValue2;
        int sleepTimes;

        public runnableMethod(int sumValue1, int sumValue2) {
            this.sumValue1 = sumValue1;
            this.sumValue2 = sumValue2;
        }

        @Override
        public void run() {
            total += sumValue1 + sumValue2;
        }
    }

}
