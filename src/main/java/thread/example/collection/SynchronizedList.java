package thread.example.collection;

import java.util.Arrays;
import static thread.example.Utils.ThreadSleepUtils.sleep;

public class SynchronizedList implements SimpleList{

    private static final int DEFAULT_CAPACITY = 10;

    private int index = 0;

    private Object[] elements;

    public SynchronizedList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized void add(Object o) {
        elements[index] = o;
        sleep(10);
        index++;
    }

    @Override
    public synchronized int size() {
        return index;
    }

    @Override
    public synchronized Object get(int index) {
        return elements[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elements, index)) + " -> " + index;
    }
}
