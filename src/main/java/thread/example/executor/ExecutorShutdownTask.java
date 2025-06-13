package thread.example.executor;

import thread.example.task.SleepRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownTask {

    public static void main(String[] args) {
        try{
            ExecutorService es = Executors.newFixedThreadPool(4);

            es.execute(new SleepRunnable());
            es.execute(new SleepRunnable());
            es.execute(new SleepRunnable());
            es.execute(new SleepRunnable(30000));

            awaitTermination(es);

            es.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void awaitTermination(ExecutorService es) throws InterruptedException {
        es.shutdown();
        if (!es.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("[강제종료 실행]");

            es.shutdownNow();
            if (!es.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("[실행중인 프로세스가 종료되지 않았습니다.]");
            }
        }
    }


}
