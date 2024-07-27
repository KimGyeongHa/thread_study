package org.example;

public class ThreadBasic {

    public static void main(String[] args) {
        System.out.println("main_method_start1");
        new Thread_test().start();
        System.out.println("main_method_start2");
    }

}
class Thread_test extends Thread{
    @Override
    public void run() {
        System.out.println("thread_test_run");
    }
}



