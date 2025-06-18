package interfacemethod.parallel;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream4 {

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1, 8).boxed().toList();

        long startTime = System.currentTimeMillis();

        //Integer reduce = list.stream().parallel().map(n -> new MyTask(n).getResult()).reduce(0, (a, b) -> a + b);

        list.stream().map(n -> new MyTask(n).getResult()).reduce(0 , (a,b) -> a + b);


        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

    }


    static class MyTask{
        private int result;

        public MyTask(int i) {
            System.out.println("[task]" + i + "번 실행시작" );
            result += i * 10;
        }

        public int getResult() {
            return result;
        }

    }



}
