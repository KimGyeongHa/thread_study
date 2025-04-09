package thread.example.completableFuture;

import thread.example.Utils.ThreadSleepUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static thread.example.Utils.ThreadSleepUtils.sleep;

public class CompletableFutureException {


    public static void main(String[] args) {

        CompletableFutureExceptionTask exceptionTask = new CompletableFutureExceptionTask();


        // handle
       /* CompletableFuture<Integer> exceptionFuture1 = exceptionTask.getData1(10);
        CompletableFuture<Integer> exceptionFuture2 = exceptionTask.getData2(exceptionFuture1.join()).handle((result,exception) ->{
            if (exception != null) {
                throw new RuntimeException("handle 오류발생");
            }else{
                return result;
            }
        });

        System.out.println(exceptionFuture2.join());*/


        // whenComplete
        CompletableFuture<Integer> whenCompleteFuture = exceptionTask.getData2(10).whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("예외처리 오류위치");
            } else {
                System.out.println(result * 2);
            }
        });

        try{
            whenCompleteFuture.join();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (CompletionException e){
            System.out.println(e.getMessage());
        }


    }



    static class CompletableFutureExceptionTask{
        private CompletableFuture<Integer> getData1(Integer value){
            return CompletableFuture.supplyAsync(() -> {
               return  value;
            });
        }

        private CompletableFuture<Integer> getData2(Integer value){
            return CompletableFuture.supplyAsync(()-> value/5);
        };
    }



}
