package thread.example.future;

import java.util.concurrent.*;

public class FutureInvokeTask {
    public Callable<String> getCallable() {
        return new Callable<>() {
            @Override
            public String call() throws InterruptedException {
                System.out.println("[callable 호출]");
                Thread.sleep(1000);
                return "A";
            }
        };

    }





}
