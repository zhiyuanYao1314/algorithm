package A18Threads.A1Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 15:09
 * 写一个固定容量同步器，拥有put 和get方法， 以及getCount方法。
 * 能够支持两个生产者和10个消费者线程的阻塞调用。
 *
 *  分析： 生产者消费者模式
 * 生产者put之前，检查容器，容器满了，wait； 容器不满，放入，notifyAll
 * 消费者get之前，检查容器空了，wait； 容器不空，get
 * 因为容器有多线程操作，所以，需要保证线程安全；
 *
 * 注意：容器加锁，是为了不同的消费者或者生产者同时处理处理
 *
 */
public class A15Inteview2 {

    static int MAX=10000;
    static List<Integer> container = new ArrayList<>(MAX);

    static synchronized void put(int i) {
        container.add(i);
    }

    static synchronized int get(){
        Integer k = container.get(0);
        container.remove(k);
        return k;
    }
    static synchronized int getCount(){
        return container.size();
    }

    static Object lock = new Object();
    public static void main(String[] args) {
        Runnable producter = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        // 容器满了，等待
                        while (getCount() == MAX) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        // 生成
                        int i = (int) (Math.random() * 100);
                        put(i);
                        //
                        System.out.println(Thread.currentThread().getName() + "生产了" + i);
                        // 通知其他用户；
                        lock.notifyAll();
                    }
                    // try {
                    //     TimeUnit.SECONDS.sleep(1);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true){
                    // 空了 等待
                    synchronized (lock){
                        while (getCount()==0){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        // 消费
                        int k = get();
                        System.out.println("消费者"+ Thread.currentThread().getName()+"消费了"+k);
                        // 通知
                        lock.notifyAll();
                    }
                    // try {
                    //     TimeUnit.SECONDS.sleep(1);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }
                }
            }
        };
        for (int i=0;i<10;i++){
            new Thread(consumer, "consumer"+i).start();
        }
        for (int i=0;i<2;i++){
            new Thread(producter, "producer"+i).start();
        }
    }
}
