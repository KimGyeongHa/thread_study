package thread.example;

import static thread.example.Utils.ThreadSleepUtils.*;

public class BankAccount implements BankAccountMethod{

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public Boolean withDraw(int amount){
        synchronized (this) {
            if (balance < amount) {
                System.out.println("[출금실패]");
                return false;
            }
            System.out.println("[출금시작]");
            balance = balance - amount;

            sleep(1000);
        }
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
