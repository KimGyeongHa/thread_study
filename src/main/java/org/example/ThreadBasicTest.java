package org.example;

public class ThreadBasicTest {
    public static void main(String[] args) {
        CounterThread thread = new CounterThread();
        thread.start();
    }
    static class CounterThread extends Thread{
        static int cnt = 1;
        @Override
        public void run(){
            for (int i = 1 ; i <= 5 ; i++) {
                try{
                    Thread.sleep(1);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
