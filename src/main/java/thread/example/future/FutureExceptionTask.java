package thread.example.future;

import java.util.concurrent.*;

public class FutureExceptionTask {


    public static void main(String[] args) {
        try{
            ExecutorService ex = Executors.newFixedThreadPool(2);

            Future<String> submit = ex.submit(new FutureExceptionCallable());

            try {
                String s = submit.get();
            } catch (InterruptedException | ExecutionException e) {
                Throwable cause = e.getCause();
                throw new RuntimeException(cause);
            }

            ex.shutdown();
        }catch (Exception e){}
    }

    static class FutureExceptionCallable implements Callable<String>{
        @Override
        public String call() throws IllegalArgumentException {
            throw new IllegalArgumentException("[Callable 중 발생 오류 투척]");
        }
    }



}
