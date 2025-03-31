package thread.example.collection;

public class SynchronizedProxyList implements SimpleList{

    private final SimpleList target;

    public SynchronizedProxyList(BasicList list) {
        this.target = list;
    }

    @Override
    public synchronized void add(Object o) {
        target.add(o);
    }

    @Override
    public synchronized int size() {
        return target.size();
    }

    @Override
    public synchronized Object get(int index) {
        return target.get(index);
    }

    @Override
    public synchronized String toString() {
        return target.toString();
    }

}
