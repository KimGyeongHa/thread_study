package thread.example.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureTask {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() ->{
            CompletableFuture.supplyAsync(() -> Thread.currentThread().getName()).thenApply(n -> {
                System.out.println(Thread.currentThread().getName());
                return n + "b";
            });

        });

        executorService.shutdown();



    }



}
