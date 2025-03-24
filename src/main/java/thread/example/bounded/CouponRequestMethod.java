package thread.example.bounded;

public interface CouponRequestMethod {

    void put(String request);
    String take();
}
