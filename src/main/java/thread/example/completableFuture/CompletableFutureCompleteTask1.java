package thread.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static thread.example.Utils.ThreadSleepUtils.*;

public class CompletableFutureCompleteTask1 {

    public static void main(String[] args) {

        CompletableFutureCompleteTask futureTask = new CompletableFutureCompleteTask();

        CompletableFuture<String> task = futureTask.getCompletableFuture;

       /* if (task.complete("김경하")){
            System.out.println(task.join());
        }*/

        CompletableFuture<String> failCompleteTimeoutTask = task.completeOnTimeout("김경하", 2, TimeUnit.SECONDS);
        System.out.println(failCompleteTimeoutTask.join());


        CompletableFuture<Object> completableFuture = CompletableFuture.completedFuture(task.join());

        CompletableFuture<String> completableFutureException = completableFuture.thenCompose(n -> {
            return CompletableFuture.supplyAsync(() -> {
                sleep(3000);
                return n + " bbb";
            });
        }).whenComplete((result, throwable) -> {
            if (throwable != null) {
                System.out.println(throwable.getMessage());
            }
            System.out.println(result);
        });

        if (completableFutureException.isCompletedExceptionally()) {
            System.out.println("오류 처리 후 반환 된 값으로 인한 출력");
        }


    }

    static class CompletableFutureCompleteTask{

        public CompletableFuture<String> getCompletableFuture;

        public CompletableFutureCompleteTask() {
            this.getCompletableFuture = CompletableFuture.supplyAsync(() -> {
                sleep(3000);
                return Thread.currentThread().getName();
            });
        }
    }

}
