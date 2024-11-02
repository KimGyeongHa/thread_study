package thread.example.LockSupport;

import thread.example.BankAccountMethod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static thread.example.Utils.ThreadSleepUtils.sleep;

public class ReentrantLockToBankAccountV2 implements BankAccountMethod {

        private int balance;
        private final ReentrantLock reentrantLock = new ReentrantLock();

        public ReentrantLockToBankAccountV2(int balance) {
            this.balance = balance;
        }

        public Boolean withDraw(int amount){
            try {
                if (!reentrantLock.tryLock(100, TimeUnit.MILLISECONDS)){
                    System.out.println("[이미 출금중입니다.]");
                    return false;
                }
            }catch (InterruptedException e){

            }

            try{

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


