package thread.example.review;

import java.util.ArrayDeque;


public class CouponRequestV1 implements CouponRequestMethod{

    private ArrayDeque<String> couponRequests = new ArrayDeque<String>();
    private int max;

    public CouponRequestV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String request) {
        this.couponRequests.add(request);
        if (this.couponRequests.size() > max) {
            System.out.println("[저장 값 초과] : " + request);
        }
    }

    @Override
    public synchronized String take() {
        if (couponRequests.isEmpty()){
            return null;
        }
        return couponRequests.poll();
    }

    @Override
    public String toString() {
        return couponRequests.toString();
    }
}
