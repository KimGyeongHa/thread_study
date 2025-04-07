package thread.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureAllOf {


    public static void main(String[] args) {
        FutureAllOfService service = new FutureAllOfService();

        CompletableFuture<Integer> service1 = service.get1();
        CompletableFuture<Integer> service2 = service.get2();

        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(service1, service2);

        CompletableFuture<Integer> integerCompletableFuture = allOfFuture.thenApply(n -> {
            Integer get1 = service1.join();
            Integer get2 = service2.join();
            return get1 + get2;
        });

        System.out.println("[allOfFuture result] : " + integerCompletableFuture.join());

        CompletableFuture.anyOf(service1, service2).thenAccept(System.out::println);

    }


    static class FutureAllOfService{

        private CompletableFuture<Integer> get1(){
            return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return 1;
                }
            });
        }

        private CompletableFuture<Integer> get2(){
            return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return 2;
                }
            });
        }



    }



}
