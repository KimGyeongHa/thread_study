package org.example;

public class RunnableBasic {
    static int cnt = 0;
    public static void main(String[] args) {

        for (int i = 0; i < 100 ; i++) {
            Thread thread = new Thread(() -> System.out.println("Runnable start" + cnt++));
            thread.start();
        }
    }


}
