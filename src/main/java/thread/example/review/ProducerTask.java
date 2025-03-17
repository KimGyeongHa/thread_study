package thread.example.review;

public class ProducerTask implements Runnable {

    private CouponRequestMethod method;
    private String request;

    public ProducerTask(CouponRequestMethod method, String request) {
        this.method = method;
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("[쿠폰 생성] : " + request);
        method.put(request);
    }
}
