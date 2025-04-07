package thread.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static thread.example.Utils.ThreadSleepUtils.*;

public class CompletableFutureTask {

    public static void main(String[] args) {

        try(ExecutorService executorService = Executors.newFixedThreadPool(2)){

            CompletableFuture<String> getFirstFuture = CompletableFuture
                    .supplyAsync(new Supplier<String>() {
                        @Override
                        public String get() {
                            return Thread.currentThread().getName();
                        }
                    }, executorService)
                    .thenApplyAsync(n -> {
                        System.out.println(n);
                        System.out.println("[비동기 처리결과] :" + Thread.currentThread().getName());
                        return n + " 스레드 사용";
                    }, executorService);

            CompletableFuture<String> getSecondFuture = getFirstFuture.thenCompose(n -> {
                return CompletableFuture.supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        System.out.println("[compose로 연결된 thread] : " + Thread.currentThread().getName());
                        return n + " compose로 새로운 completableFuture와 연결";
                    }
                },executorService);
            });

            getSecondFuture.thenAccept(System.out::println);

            getSecondFuture.join();

            getSecondFuture.thenRun(() ->{
                System.out.println("[비동기 처리 처리완료]");
            });

            /* CompletableFuture 결과 값 두개 결합하여 반환 시작 */
            CompletableFuture<String> combineFirstFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    sleep(3000);
                    return "a";
                }
            });

            CompletableFuture<String> combineSecondFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    sleep(3000);
                    return "b";
                }
            });

            long start = System.currentTimeMillis();

            // 병렬처리
            CompletableFuture<String> combineFuture = combineFirstFuture.thenCombine(combineSecondFuture, (result1, result2) -> {
                return result1 + result2;
            });

            combineFuture.join();


            long end = System.currentTimeMillis();

            System.out.println((end - start) / 1000 + "s");

            combineFuture.thenAccept(System.out::println);

            /* CompletableFuture 결과 값 두개 결합하여 반환 끝 */

        };

    }



}
