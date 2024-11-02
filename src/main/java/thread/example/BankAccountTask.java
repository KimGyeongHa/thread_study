package thread.example;


public class BankAccountTask implements Runnable{

    private BankAccountMethod account;
    private int amount;

    public BankAccountTask(BankAccountMethod account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withDraw(amount);
    }
}
