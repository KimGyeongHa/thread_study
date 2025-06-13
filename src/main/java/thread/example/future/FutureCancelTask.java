package thread.example.future;

import java.util.concurrent.*;

public class FutureCancelTask {

    private final static boolean mayInterruptIfRunning = true;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(1);

        System.out.println("-----[Thread Start]-----");

        Future<String> future = es.submit(new FutureTask());

        future.cancel(mayInterruptIfRunning);

        if (future.isCancelled()){
            System.out.println("[future is cancelled]");
        }

        System.out.println("-----[Thread End]-----");

        es.shutdown();
    }


    static class FutureTask implements Callable<String> {

        private String name = "";

        @Override
        public String call() throws InterruptedException {

            try {
                Thread.sleep(1000);
                while (name.length() < 5) {
                    name += "A";
                }
            }catch (InterruptedException e){
                System.out.println("[InterruptedException]" + e);
            }


            return name;
        }
    }

}
