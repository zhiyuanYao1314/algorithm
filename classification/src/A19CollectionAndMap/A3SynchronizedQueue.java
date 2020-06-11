package A19CollectionAndMap;

import java.util.concurrent.SynchronousQueue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 23:36
 * SynchronizedQueue实现了场景：
 * 一个线程给另外一个线程传东西，
 * 只能放一个东西，放的线程，只有等拿的线程去完后
 *
 * a线程放了没人取，会阻塞；
 * b线程取得时候发现没有东西，会阻塞；
 * 线程两边交换
 *
 * 线程间的任务调度的时候都是它1
 */
public class A3SynchronizedQueue {
    public static void main(String[] args) {
        SynchronousQueue<Integer> q = new SynchronousQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put start!");
                try {
                    q.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put end!");
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("get started!");
                q.poll();
                System.out.println("take end!");
            }
        }).start();
    }

}
