package thread.example.review;

import java.util.ArrayList;
import java.util.List;

public class CouponRequestMain {



    public static void main(String[] args) {
        CouponRequestMethod method = new CouponRequestV4(2);
        productFirst(method);
        //customerFirst(method);
    }

    private static void productFirst(CouponRequestMethod method) {
        List<Thread> threads = new ArrayList<Thread>();
        product(method, threads);
        couponStatus(threads);
        customer(method, threads);
        couponStatus(threads);
    }

    private static void customerFirst(CouponRequestMethod method){
        List<Thread> threads = new ArrayList<Thread>();
        customer(method, threads);
        product(method, threads);
        couponStatus(threads);
    }

    public static void product(CouponRequestMethod method, List<Thread> threads) {
        for (int i = 1 ; i < 10 ; i++){
            Thread thread = new Thread(new ProducerTask(method, "쿠폰" + i));
            threads.add(thread);
            thread.start();
        }
    }

    public static void customer(CouponRequestMethod method, List<Thread> threads){
        for (int i = 1 ; i < 10 ; i++){
            Thread thread = new Thread(new CustomerTask(method));
            threads.add(thread);
            thread.start();
        }
    }

    public static void couponStatus(List<Thread> threads){
        System.out.println();
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " + thread.getState());
        }
    }


}
