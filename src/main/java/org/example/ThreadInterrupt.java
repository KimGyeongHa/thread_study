package org.example;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadInterrupt {

    public static void main(String[] args) {
        ThreadRunnable thread_method = new ThreadRunnable();

        Scanner sc = new Scanner(System.in);

        Thread thread = new Thread(thread_method);
        thread.start();

        while (true){
            String input = sc.nextLine();
            thread_method.inputs.add(input);

            if (input.equals("q")){
                thread.interrupt();
                break;
            }
        }
    }
}

class ThreadRunnable implements Runnable{

    volatile boolean status = true;
    Queue<String> inputs = new ConcurrentLinkedDeque<>();

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                if (!inputs.isEmpty()){
                    System.out.println(inputs.toString());
                    System.out.println("출력중");
                    Thread.sleep(2000);
                    System.out.println(inputs.poll());
                    System.out.println(inputs.toString());
                }
            } catch (InterruptedException e) {
                System.out.println("쓰레드 인터럽트 상태 : " +  Thread.currentThread().isInterrupted());
                System.out.println("쓰레드 종료");
                return;
            }
        }
    }
}

