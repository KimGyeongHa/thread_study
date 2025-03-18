package thread.example.review;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CouponRequestV4 implements CouponRequestMethod{

    private Queue<String> couponRequests = new ArrayDeque<String>();
    private final int max;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public CouponRequestV4(int max) {
        this.max = max;
    }

    @Override
    public void put(String request)  {
        lock.lock();
        try {
            while (couponRequests.size() == max) {
                System.out.println("[저장 값 초과] : " + request);
                condition.await();
            }
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
        condition.signal();
        couponRequests.offer(request);

    }

    @Override
    public String take()  {
        lock.lock();
        try {
            while (couponRequests.isEmpty()) {
                System.out.println("[저장 값 없음]");
                condition.await();
            }
            condition.signal();
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }

        return couponRequests.poll();
    }

    @Override
    public String toString() {
        return couponRequests.toString();
    }
}
