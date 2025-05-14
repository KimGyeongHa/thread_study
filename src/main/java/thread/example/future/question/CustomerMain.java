package thread.example.future.question;

import java.util.List;
import java.util.concurrent.*;

public class CustomerMain {

    public static void main(String[] args) {
        try{
            ExecutorService ex = Executors.newFixedThreadPool(3);
            Customer customer1 = new Customer();
            FutureCustomerTask futureTask = new FutureCustomerTaskImpl(customer1);

            List<Callable<Customer>> list = List.of(futureTask.setDelivery(), futureTask.setStock(), futureTask.setSystem());
            ex.invokeAll(list);

            System.out.println(customer1.toString());

            ex.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
