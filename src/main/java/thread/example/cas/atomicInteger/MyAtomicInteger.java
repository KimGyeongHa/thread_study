package thread.example.cas.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncrementInteger{

    AtomicInteger myAtomicInteger = new AtomicInteger();
    private int value;


    @Override
    public void increment() {
        value += myAtomicInteger.incrementAndGet();
    }

    @Override
    public int get() {
        return myAtomicInteger.get();
    }
}
