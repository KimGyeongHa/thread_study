package interfacemethod.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class ParallelStream1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        long startTime = System.currentTimeMillis();

        /*
            IntStream range = IntStream.rangeClosed(0, 10);

            range
                .map(ParallelStream1::MyLogger)
                .forEach(System.out::println);
       */

        /*
            Thread thread1 = new Thread(new ThreadTask(1, 4));
            Thread thread2 = new Thread(new ThreadTask(4, 8));

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        */

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        /*
            List<Future<?>> futures = new ArrayList<>();

            for (int i = 0 ; i < 5 ; i++) {
                Future<?> submit = executorService.submit(new ThreadTask(1, i + 1));
                futures.add(submit);
            }

            for (Future<?> future : futures) {
                future.get();
            }
        */

        CompletableFuture<?> future = CompletableFuture.supplyAsync(() -> new Supplier<String>() {
            @Override
            public String get() {
                return "하이하이";
            }
        }, executorService).thenAccept(n -> System.out.println(n.get()));

        CompletableFuture.supplyAsync(() -> "하이하이2", executorService).thenAccept(System.out::println);

        executorService.shutdown();

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime));

    }


    public static int MyLogger(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return i * 10;
    }


    static class ThreadTask implements Runnable{

        private int startValue;
        private int endValue;

        public ThreadTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            for (int i = startValue; i <= endValue; i++) {
                System.out.println(MyLogger(i));
            }
        }
    }

}
