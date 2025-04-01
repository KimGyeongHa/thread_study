package thread.example.future.question;

import java.util.concurrent.Callable;

public class FutureCustomerTaskImpl implements FutureCustomerTask {

    private Customer customer = new Customer();

    public Callable<Customer> setDelivery() {
        return new Callable<Customer>() {
            @Override
            public Customer call() throws Exception {
                customer.setDeliveryCheck(true);
                return customer;
            }
        };
    }

    public Callable<Customer> setStock() {
        return new Callable<Customer>() {
            @Override
            public Customer call() throws Exception {
                customer.setStock(customer.getStock() - 1);
                return customer;
            }
        };
    }

    public Callable<Customer> setSystem() {
        return new Callable<Customer>() {
            @Override
            public Customer call() throws Exception {
                customer.setSystemCheck(true);
                return customer;
            }
        };
    }

}
