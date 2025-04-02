package thread.example.executor;

import thread.example.task.SleepRunnable;
import java.util.concurrent.*;

import static thread.example.executor.utils.ExecutorUtils.printStatue;

public class ExecutorMaxThreadTask {

    public static void main(String[] args) {

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MICROSECONDS, blockingQueue);

        printStatue(threadPoolExecutor);

        threadPoolExecutor.submit(new SleepRunnable(10), "task-1");
        printStatue(threadPoolExecutor, "task-1");

        threadPoolExecutor.submit(new SleepRunnable(10), "task-2");
        printStatue(threadPoolExecutor, "task-2");

        threadPoolExecutor.submit(new SleepRunnable(10), "task-3");
        printStatue(threadPoolExecutor, "task-3");

        threadPoolExecutor.submit(new SleepRunnable(10), "task-4");
        printStatue(threadPoolExecutor, "task-4");

        threadPoolExecutor.submit(new SleepRunnable(10), "task-5");
        printStatue(threadPoolExecutor, "task-5");

        threadPoolExecutor.submit(new SleepRunnable(10), "task-6");
        printStatue(threadPoolExecutor, "task-6");


        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        try {
            threadPoolExecutor.submit(new SleepRunnable(10), "task-7");
            printStatue(threadPoolExecutor, "task-7");
        }catch (RejectedExecutionException e){
            System.out.println("task-7 rejected " + e);
        }

        threadPoolExecutor.shutdown();

    }


}
