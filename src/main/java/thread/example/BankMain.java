package thread.example;

import thread.example.LockSupport.ReentrantLockToBankAccountV1;
import thread.example.LockSupport.ReentrantLockToBankAccountV2;

import static thread.example.Utils.ThreadSleepUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {


      /*
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

        */


        ReentrantLockToBankAccountV2 reentrantLockToBankAccount2 = new ReentrantLockToBankAccountV2(3000);

        Thread account5 = new Thread(new BankAccountTask(reentrantLockToBankAccount2,2000));
        Thread account6 = new Thread(new BankAccountTask(reentrantLockToBankAccount2,2000));

        account5.start();
        account6.start();

        System.out.println("[남은잔액] : " + reentrantLockToBankAccount2.getBalance());


        /*ReentrantLockToBankAccountV1 reentrantLockToBankAccount = new ReentrantLockToBankAccountV1(3000);

        Thread account3 = new Thread(new BankAccountTask(reentrantLockToBankAccount,2000));
        Thread account4 = new Thread(new BankAccountTask(reentrantLockToBankAccount,2000));

        account3.start();
        account3.join();
        System.out.println("[중간 출금액] : " + reentrantLockToBankAccount.getBalance());

        System.out.println("[thread3상태] : " + account3.getState());

        account4.start();
        account4.join();
        System.out.println("[thread4상태] : " + account4.getState());*/



    }

}
