package thread.example.bounded;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CouponRequestBlockingQueueV2 implements CouponRequestMethod{

    private final BlockingQueue<String> queue;

    public CouponRequestBlockingQueueV2(int max) {
        queue = new LinkedBlockingQueue<String>(max);
    }

    @Override
    public void put(String request) {

        try {
            // add 시 queue의 size 초과 시 IllegalStateException 에러
            queue.add(request);

            // offer시 size초과 시 null 반환
            //queue.offer(request);

            // offer시 size초과 시 대기
            //queue.put(request);
        }catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            // get queue에 값이 없을 떄 null반환
            return queue.poll();

            // queue에 값이 없을 떄 대기
            // queue.take();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
