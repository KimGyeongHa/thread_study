package thread.example.future;

import java.util.concurrent.*;

public class FutureSumTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> sum1 = executor.submit(new CallableTask(1, 50));
        Future<Integer> sum2 = executor.submit(new CallableTask(51, 100));

        System.out.println(sum1.get() + sum2.get());

    }


    static class CallableTask implements Callable<Integer> {
        int sum ,startNum, endNum;

        public CallableTask(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        public Integer call() throws Exception {
            while (startNum <= endNum) {
                sum += startNum++;
            }
            return sum;
        }
    }

}
