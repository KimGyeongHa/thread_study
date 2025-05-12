package thread.example.executor;

import thread.example.task.SleepRunnable;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorReject {

    public static void main(String[] args) {

        try(ThreadPoolExecutor ec = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new SynchronousQueue<>(), new CustomRejectExecutionPolicy())){
            ec.submit(new SleepRunnable(10));
            ec.submit(new SleepRunnable(10));
            ec.submit(new SleepRunnable(10));

            ec.shutdown();
        }catch (RejectedExecutionException e){
            System.out.println(e);
        }


    }

    static class CustomRejectExecutionPolicy implements RejectedExecutionHandler {

        AtomicInteger count = new AtomicInteger(0);

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("[요청 거절된 개수] : " + count.incrementAndGet());
        }
    }


}
