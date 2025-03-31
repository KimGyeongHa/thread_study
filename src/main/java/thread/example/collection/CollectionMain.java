package thread.example.collection;

public class CollectionMain {

    public static void main(String[] args) throws InterruptedException {
        SimpleList list = new SynchronizedProxyList(new BasicList());

        Thread thread1 = new Thread(new CollectionThread(list, "A"));
        Thread thread2 = new Thread(new CollectionThread(list, "B"));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list);
        System.out.println(list.size());
    }

}

class CollectionThread implements Runnable {
    private final SimpleList list;
    private final Object o;

    public CollectionThread(SimpleList list, Object o) {
        this.list = list;
        this.o = o;
    }

    @Override
    public void run() {
        list.add(o);
    }
}
