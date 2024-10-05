package thread.example;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(5000);

        Thread account1 = new Thread(new BankAccountTask(bankAccount,4000));
        Thread account2 = new Thread(new BankAccountTask(bankAccount,4000));

        account1.start();
        account1.join();
        System.out.println("[thread1상태] : " + account1.getState());
        System.out.println("[thread2상태] : " + account2.getState());

        account2.start();
        account2.join();

        System.out.println("[남은잔액] : " + bankAccount.getBalance());

    }

}
