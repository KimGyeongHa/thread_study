package optional.basic;

import java.util.function.Supplier;

public class OptionalExample2 {


    public static void main(String[] args) {
        DelayTask delayTask = new DelayTask();

        delayTask.setDebugging(true);
        delayTask.call(30 + 50);
        System.out.println("==========================");

        delayTask.setDebugging(false);
        delayTask.call2(() -> 30 + 50);
    }

    static class DelayTask{

        private boolean debugging = false;

        public void call(int result){
            if (debugging){
                System.out.println(result);
            }
        }

        public <T> void call2(Supplier<T> supplier){
            if (debugging){
                System.out.println(supplier.get());
            }
        }

        public void setDebugging(boolean debugging) {
            this.debugging = debugging;
        }
    }
}
