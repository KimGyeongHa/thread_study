package thread.example;

public class ParameterThread {

    public static void main(String[] args) {
        ParameterRunnable runnable1 = new ParameterRunnable("parameterTest1",1000);
        ParameterRunnable runnable2 = new ParameterRunnable("parameterTest2",3000);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

    static class ParameterRunnable implements Runnable{
        private String content;
        private int sleepCount;

        public ParameterRunnable(String content, int sleepCount) {
            this.content = content;
            this.sleepCount = sleepCount;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.content);
                Thread.sleep(sleepCount);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
