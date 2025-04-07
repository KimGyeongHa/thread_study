package thread.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static thread.example.Utils.ThreadSleepUtils.*;

public class CompletableFutureCombineComposeTask {


    public static void main(String[] args) {
        CompletableFutureService service = new CompletableFutureService();

        CompletableFuture<String> combine = service.getData1().thenCombine(service.getData2(), (s1, s2) ->{
            return s1 + s2;
        });


        CompletableFuture<String> compose = combine.thenCompose(n -> {
            return CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    return n + " completableFuture";
                }
            });
        });

        compose.join();
        compose.thenAccept(System.out::println);

    }


    static class CompletableFutureService{

        public CompletableFuture<String> getData1() {
            return CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    sleep(30);
                    return "Hello";
                }
            });
        }

        public CompletableFuture<String> getData2() {
            return CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    sleep(30);
                    return " world";
                }
            });
        }

    }
}
