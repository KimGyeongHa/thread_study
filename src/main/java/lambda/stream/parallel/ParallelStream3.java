package lambda.stream.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStream3 {


    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        System.out.println(processorCount);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int parallelism = forkJoinPool.getParallelism();

        System.out.println(parallelism);

        ParallelStream2.MyTask myTask = new ParallelStream2.MyTask(IntStream.of(1, 8).boxed().toList());
        forkJoinPool.invoke(myTask);

        myTask.compute();

    }



}
