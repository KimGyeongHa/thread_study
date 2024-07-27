package org.example;

public class CounterRunnable {
    static int cnt = 1;

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                for (int i = 0 ; i < 5 ; i++) {
                    System.out.println(cnt++);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setName("counter");
        thread.start();
        }
    }

