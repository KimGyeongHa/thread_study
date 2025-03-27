package thread.example.bounded;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CouponRequestBlockingQueueV1 implements CouponRequestMethod{

    private final BlockingQueue<String> queue;

    public CouponRequestBlockingQueueV1(int max) {
        queue = new LinkedBlockingQueue<String>(max);
    }

    @Override
    public void put(String request) {
        try{
            queue.put(request);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public String take() {
        try {
            return queue.take();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
