package thread.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureCompleteTask2 {

    public static void main(String[] args) {


        CompletableFuture<Integer> completableFuture = new TaskService().getCompletableFuture();

        CompletableFuture<Void> voidCompletableFuture = completableFuture.thenApply(n -> n + 1).thenAccept(System.out::println);

        CompletableFuture<Integer> integerCompletableFuture = completableFuture.completeAsync(() -> 3);
        System.out.println(completableFuture.join());

    }


    static class TaskService{

        public CompletableFuture<Integer> getCompletableFuture() {

            CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(() -> {

            });

            executorService.shutdown();

            return completableFuture;

        }



    }

}
