package thread.example.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

public class CouponRequestV3 implements CouponRequestMethod {

    private Queue<String> couponRequests = new ArrayDeque<String>();
    private int max;

    public CouponRequestV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String request)  {
        while (this.couponRequests.size() == max) {
            System.out.println("[저장 값 초과] : " + request);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.couponRequests.add(request);
        notify();

    }

    @Override
    public synchronized String take()  {
        while (couponRequests.isEmpty()){
            System.out.println("[저장 값 없음]");
            try{
                wait();
            }catch (InterruptedException e){}
        }
        notify();
        return couponRequests.poll();
    }

    @Override
    public String toString() {
        return couponRequests.toString();
    }
}
