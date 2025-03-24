package thread.example.bounded;

public class CustomerTask implements Runnable {

    private CouponRequestMethod method;

    public CustomerTask(CouponRequestMethod method) {
        this.method = method;
    }

    @Override
    public void run() {
        System.out.println("[쿠폰 발급]" + method.take());
    }
}
