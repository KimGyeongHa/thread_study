package thread.example.review;

import java.util.ArrayList;
import java.util.List;

public class CouponRequestMain {


    static List<Thread> threads = new ArrayList<Thread>();

    public static void main(String[] args) {

        CouponRequestMethod method = new CouponRequestV1(2);
        product(method);
        customer(method);
        couponStatus();

    }

    public static void product(CouponRequestMethod method){
        for (int i = 1 ; i < 10 ; i++){
            Thread thread = new Thread(new ProducerTask(method, "쿠폰" + i));
            threads.add(thread);
            thread.start();
        }
    }

    public static void customer(CouponRequestMethod method){
        for (int i = 1 ; i < 10 ; i++){
            Thread thread = new Thread(new CustomerTask(method));
            threads.add(thread);
            thread.start();
        }
    }

    public static void couponStatus(){
        System.out.println();
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " + thread.getState());
        }
    }


}
