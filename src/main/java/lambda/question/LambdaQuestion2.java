package lambda.question;

import java.util.Arrays;

@FunctionalInterface
interface Procedure{
    long checkTime(LambdaQuestion2.Plus plus, LambdaQuestion2.SortArr sortArr) throws InterruptedException;
}

public class LambdaQuestion2 {

    volatile static long currentTime = 0;

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 3, 5, 7, 9};
        int plusData = 10;

        Procedure procedure = new Procedure() {
            @Override
            public long checkTime(Plus plus, SortArr sortArr) {
                long startTime = System.currentTimeMillis();

                plus.getResult();
                sortArr.getResult();

                long endTime = System.currentTimeMillis();

                return endTime - startTime;
            }
        };

        System.out.println(
                procedure.checkTime(new Plus(plusData), new SortArr(arr))
        );


        Procedure procedure1 = (Plus plus, SortArr sortArr) -> {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long startTime = System.currentTimeMillis();

                        Thread.sleep(10);
                        plus.getResult();
                        sortArr.getResult();

                        long endTime = System.currentTimeMillis();
                        currentTime = endTime - startTime;

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            thread.start();
            thread.join();

            return currentTime;
        };

        System.out.println(
                procedure1.checkTime(new Plus(plusData), new SortArr(arr))
        );



    }

    static class Plus{
        private int result = 0;
        private int n = 0;

        public Plus(int n) {
            this.n = n;
        }

        public int getResult() {
            for (int i = 0; i < n; i++){
                result += i;
            }
            return result;
        }

    }

    static class SortArr{
        private int[] result = new int[0];

        public SortArr(int[] arr) {
            this.result = arr;
        }

        public int[] getResult() {
            if (result.length > 0){
                Arrays.sort(result);
            }
            return result;
        }
    }

}
