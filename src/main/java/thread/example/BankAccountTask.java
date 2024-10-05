package thread.example;

import thread.example.BankAccount;

public class BankAccountTask implements Runnable{

    private BankAccount account;
    private int amount;

    public BankAccountTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withDraw(amount);
    }
}
