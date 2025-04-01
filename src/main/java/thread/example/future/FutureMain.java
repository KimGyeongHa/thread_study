package thread.example.future;

import java.util.Random;
import java.util.concurrent.*;

public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Integer i = es.submit(new Callable1()).get();
        System.out.println(i);
        es.shutdown();
    }

    static class Callable1 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int i = new Random().nextInt(10);
            return i;
        }
    }



}
