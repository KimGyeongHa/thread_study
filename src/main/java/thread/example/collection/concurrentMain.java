package thread.example.collection;

import java.util.*;
import java.util.concurrent.*;

public class concurrentMain {

    public static void main(String[] args) {
        List<String> concurrentList = new CopyOnWriteArrayList<String>(); // arrayList 대안
        Set<String> concurrentHashSet = new CopyOnWriteArraySet<String>(); // hashSet 대안
        Set<String> concurrentTreeSet = new ConcurrentSkipListSet<String>(); // treeSet 대안
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>(); // hashMap 대안
        Map<String, Object> concurrentSkipListMap = new ConcurrentSkipListMap<String, Object>(); // treeMap 대안
        Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>(); // 동시성 queue
        Deque<String> concurrentDeque = new ConcurrentLinkedDeque<>();// 동시성 deque

    }


}
