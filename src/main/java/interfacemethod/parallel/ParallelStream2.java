package interfacemethod.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ParallelStream2 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask(IntStream.of(1, 8).boxed().toList());
        System.out.println(myTask.compute());

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);
        forkJoinPool.invoke(myTask);


        System.out.println(forkJoinPool);


    }

    static class MyTask extends RecursiveTask<Integer> {

        private List<Integer> list = new ArrayList<Integer>();
        private Integer result = 0;


        public MyTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Integer compute() {

            if (list.size() >= 4) {
                List<Integer> left = list.subList(0, 3);
                List<Integer> right = list.subList(3, list.size());

                ForkJoinTask<Integer> fork1 = new MyTask(right).fork();

                fork1.join();

                try {
                    result += new MyTask(left).compute() + fork1.get();
                }catch (InterruptedException | ExecutionException e) {}


            } else {
                for (Integer item : list) {
                    result += item * 10;
                }
            }

            return result;
        }
    }




}
