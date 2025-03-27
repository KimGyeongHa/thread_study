package thread.example.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {

    //volatile boolean lock = false;
    private AtomicBoolean locked = new AtomicBoolean(false);

    public void lock() {
        while (!locked.compareAndSet(false, true)) {
            System.out.println("lock 획득대기");
        }
        locked.getAndSet(true);
        System.out.println("lock 획득");
    }

    public void unlock() {
        locked.getAndSet(false);
        System.out.println("lock 반납");
    }

}
