package thread.example.executor.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    public void printStatue(ExecutorService executorService){
        if (executorService instanceof ThreadPoolExecutor threadPoolExecutor){
            int poolSize = threadPoolExecutor.getPoolSize();
            int activeCount = threadPoolExecutor.getActiveCount();
            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("Pool Size: " + poolSize + ", Active Count: " + activeCount + ", Queue Size: " + queueSize);
        }else{
            System.out.println(executorService);
        }
    }



}
