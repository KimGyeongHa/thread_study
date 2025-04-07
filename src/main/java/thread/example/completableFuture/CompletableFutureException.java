package thread.example.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureException {


    public static void main(String[] args) {

        CompletableFutureExceptionTask exceptionTask = new CompletableFutureExceptionTask();


        // handle
        CompletableFuture<Integer> exceptionFuture1 = exceptionTask.getData1(10);
        CompletableFuture<Integer> exceptionFuture2 = exceptionTask.getData2(exceptionFuture1.join()).handle((result,exception) ->{
            if (exception != null) {
                throw new RuntimeException("handle 오류발생");
            }else{
                return result;
            }
        });

        System.out.println(exceptionFuture2.join());


        // whenComplete
        exceptionTask.getData2(10).whenComplete((result, exception) -> {
            if (exception != null) {
                throw new RuntimeException("whenComplete 오류발생");
            } else {
                System.out.println(result * 2);
            }
        }).join();



    }



    static class CompletableFutureExceptionTask{
        private CompletableFuture<Integer> getData1(Integer value){
            return CompletableFuture.supplyAsync(() -> {
               return  value;
            });
        }

        private CompletableFuture<Integer> getData2(Integer value){
            return CompletableFuture.supplyAsync(()-> value/0);
        };
    }



}
