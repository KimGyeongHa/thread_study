package thread.example.review;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CouponRequestV5 implements CouponRequestMethod{

    private Queue<String> couponRequests = new ArrayDeque<String>();
    private final int max;

    private final Lock lock = new ReentrantLock();
    private final Condition productCondition = lock.newCondition();
    private final Condition customerCondition = lock.newCondition();

    public CouponRequestV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String request)  {
        lock.lock();
        try {
            while (couponRequests.size() == max) {
                try {
                    System.out.println("[생산자 스레드 대기] : " + request);
                    productCondition.await();
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            couponRequests.offer(request);

            customerCondition.signal();
            System.out.println("[사용자 스레드 꺠움] : " + request);

        }finally {
            lock.unlock();
        }
    }

    @Override
    public String take()  {
        lock.lock();
        try {
            while (couponRequests.isEmpty()) {
                System.out.println("[사용자 스레드 대기]");
                try {
                    customerCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("[생산자 스레드 꺠움]");
            productCondition.signal();
            return couponRequests.poll();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return couponRequests.toString();
    }
}
