package thread.example.future.question;

public class Customer {

    private boolean deliveryCheck = false;

    private int stock = 10;

    private boolean systemCheck = false;

    public void setDeliveryCheck(boolean deliveryCheck) {
        this.deliveryCheck = deliveryCheck;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isSystemCheck() {
        return systemCheck;
    }

    public void setSystemCheck(boolean systemCheck) {
        this.systemCheck = systemCheck;
    }

    public boolean isDeliveryCheck() {
        return deliveryCheck;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "deliveryCheck=" + deliveryCheck +
                ", stock=" + stock +
                ", systemCheck=" + systemCheck +
                '}';
    }
}
