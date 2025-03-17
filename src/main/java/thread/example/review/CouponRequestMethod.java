package thread.example.review;

import java.util.Queue;

public interface CouponRequestMethod {

    void put(String request);
    String take();
}
