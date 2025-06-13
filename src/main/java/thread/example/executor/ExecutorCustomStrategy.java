package thread.example.executor;

import thread.example.executor.utils.ExecutorUtils;
import thread.example.task.SleepRunnable;

import java.util.TimeZone;
import java.util.concurrent.*;

import static thread.example.executor.utils.ExecutorUtils.*;

public class ExecutorCustomStrategy {

    private final static int THREAD_POOL_SIZE = 1000;
    private final static int THREAD_MAX_POOL_SIZE = 1200;
    private final static int THREAD_OVER_POOL_SIZE = 1201;


    public static void main(String[] args)  {

        try{
            ThreadPoolExecutor ec = new ThreadPoolExecutor(100, 200, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
            long start = System.currentTimeMillis();

            for (int i = 0; i < THREAD_OVER_POOL_SIZE; i++) {
                ec.execute(new SleepRunnable(1000));
                printStatue(ec, "task-" + i);
            }

            ec.shutdown();

            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000 + "s");

            ec.shutdown();

        }catch (RejectedExecutionException e){
            System.out.println("[queue 값 초과로 인한 오류발생] : " + e.getMessage());
        }


    }




}
