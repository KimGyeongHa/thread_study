package thread.example.future;

import java.util.List;
import java.util.concurrent.*;

public class FutureInvokeAllTask {

    public static void main(String[] args) {
        try{
            ExecutorService executor = Executors.newFixedThreadPool(3);

            List<Callable<String>> callable = List.of(
                    new FutureInvokeTask().getCallable(),
                    new FutureInvokeTask().getCallable(),
                    new FutureInvokeTask().getCallable()
            );

            String s1 = executor.invokeAny(callable);
            System.out.println(s1);

            executor.shutdown();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        ;
    }


}
