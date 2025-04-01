package thread.example.LockSupport;

import thread.example.BankAccountMethod;

import java.util.concurrent.locks.ReentrantLock;

import static thread.example.Utils.ThreadSleepUtils.sleep;

public class ReentrantLockToBankAccountV1 implements BankAccountMethod {

        private int balance;
        private final ReentrantLock reentrantLock = new ReentrantLock();

        public ReentrantLockToBankAccountV1(int balance) {
            this.balance = balance;
        }

        public Boolean withDraw(int amount){
            try{
                reentrantLock.lock();

                if (balance < amount) {
                    System.out.println("[출금실패]");
                    return false;
                }
                System.out.println("[출금시작]");
                balance = balance - amount;

                sleep(1000);

                return true;
            }finally {
                reentrantLock.unlock();
            }
        }

        @Override
        public int getBalance() {
            try{
                reentrantLock.lock();
            }finally {
                reentrantLock.unlock();
            }
            return balance;
        }
    }


