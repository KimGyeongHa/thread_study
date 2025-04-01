package thread.example.future.question;

import java.util.List;
import java.util.concurrent.*;

public class CustomerMain {

    public static void main(String[] args) {
        try(ExecutorService ex = Executors.newFixedThreadPool(3)){

            FutureCustomerTask futureTask = new FutureCustomerTaskImpl();
            List<Callable<Customer>> list = List.of(futureTask.setDelivery(), futureTask.setStock(), futureTask.setSystem());

            List<Future<Customer>> futures = ex.invokeAll(list);
            for (Future<Customer> future : futures) {
                Customer customer = future.get();
                System.out.println(customer.toString());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        ;
    }


}
