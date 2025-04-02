package thread.example.executor.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    public static void printStatue(ExecutorService executorService){
        if (executorService instanceof ThreadPoolExecutor threadPoolExecutor){
            int poolSize = threadPoolExecutor.getPoolSize();
            long taskCount = threadPoolExecutor.getTaskCount();
            int activeCount = threadPoolExecutor.getActiveCount();
            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("Pool Size: " + poolSize + ", Active Count: " + activeCount + ", Task Count : " + taskCount + ", Queue Size: " + queueSize);
        }else{
            System.out.println(executorService);
        }
    }

    public static void printStatue(ExecutorService executorService, String name){
        if (executorService instanceof ThreadPoolExecutor threadPoolExecutor){
            int poolSize = threadPoolExecutor.getPoolSize();
            long taskCount = threadPoolExecutor.getTaskCount();
            int activeCount = threadPoolExecutor.getActiveCount();
            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println(name + " -> " + "Pool Size: " + poolSize + ", Active Count: " + activeCount + ", Task Count : " + taskCount + ", Queue Size: " + queueSize);
        }else{
            System.out.println(executorService);
        }
    }



}
