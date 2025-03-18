package thread.example.review;

import java.util.ArrayDeque;
import java.util.Queue;

import static thread.example.Utils.ThreadSleepUtils.*;

public class CouponRequestV2 implements CouponRequestMethod{

    private Queue<String> couponRequests = new ArrayDeque<String>();
    private int max;

    public CouponRequestV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String request) {
        while (this.couponRequests.size() == max) {
            System.out.println("[저장 값 초과] : " + request);
            sleep(1000);
        }
        this.couponRequests.add(request);
    }

    @Override
    public synchronized String take() {
        while (couponRequests.isEmpty()){
            System.out.println("[저장 값 없음]");
            sleep(1000);
        }
        return couponRequests.poll();
    }

    @Override
    public String toString() {
        return couponRequests.toString();
    }

}
