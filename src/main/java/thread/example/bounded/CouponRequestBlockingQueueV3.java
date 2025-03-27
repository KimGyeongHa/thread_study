package thread.example.bounded;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CouponRequestBlockingQueueV3 implements CouponRequestMethod{

    private final BlockingQueue<String> queue;

    public CouponRequestBlockingQueueV3(int max) {
        queue = new LinkedBlockingQueue<String>(max);
    }

    @Override
    public void put(String request) {
        try {
            // 시간 초과 시 null 반환
            queue.offer(request,1000L, TimeUnit.SECONDS);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            // 시간 초과 시 null 반환
            return queue.poll(1000L, TimeUnit.SECONDS);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
