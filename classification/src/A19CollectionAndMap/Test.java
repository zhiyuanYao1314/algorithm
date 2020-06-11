package A19CollectionAndMap;

import java.util.*;
import java.util.concurrent.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/4 20:40
 * Describe:
 * version:1.0
 */
public class Test {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        Collections.synchronizedMap(hashtable);

        TreeMap map = new TreeMap();
        map.firstKey();
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add(1);
        list.get(0);
        ConcurrentLinkedDeque q = new ConcurrentLinkedDeque();
        //
        Thread th = new Thread();

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        LinkedBlockingDeque queue = new LinkedBlockingDeque();
        // queue.take();
        // queue.peek();
    }
}
