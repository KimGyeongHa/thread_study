package org.example.Utils;

public abstract class ThreadSleepUtils {
     public static void sleep(int sleepTimes) {
         try {
             Thread.sleep(sleepTimes);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }


}
