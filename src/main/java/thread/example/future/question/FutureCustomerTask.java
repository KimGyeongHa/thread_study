package thread.example.future.question;

import java.util.concurrent.Callable;

public interface FutureCustomerTask {

    Callable<Customer> setDelivery();
    Callable<Customer> setStock();
    Callable<Customer> setSystem();

}
