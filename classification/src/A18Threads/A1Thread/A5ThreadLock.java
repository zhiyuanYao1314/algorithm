package A18Threads.A1Thread;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 16:51
 * 对比synchronized, AtomicLong 和LongAddr锁
 * 在高并发的情况下 谁更快
 *
 * 实验数据：
 *
 */
public class A5ThreadLock {

    static Object lock = new Object();
    static Long count1 = 0L;
    static AtomicLong count2 = new AtomicLong(0);
    static LongAdder count3 = new LongAdder();

    // 线程数
    static int threadsNum = 1000;
    public static void main(String[] args) {

        // 2. LongAtomic
        long start2 = System.currentTimeMillis();
        Thread[] threads2 = new Thread[threadsNum];
        for (int i=0;i<threadsNum;i++){
            threads2[i] = new MyThread2();
            threads2[i] .start();
        }
        for (int i=0;i<threadsNum;i++){
            try {
                threads2[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end2= System.currentTimeMillis();
        System.out.println("-----AtomicLong-----------:");
        System.out.println("count2:"+count2);
        System.out.println("time:"+ (end2-start2));

        // synchronized
        long start1 = System.currentTimeMillis();
        Thread[] threads = new Thread[threadsNum];
        for (int i=0;i<threadsNum;i++){
            threads[i] = new MyThread1();
            threads[i] .start();
        }
        for (int i=0;i<threadsNum;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end1= System.currentTimeMillis();
        System.out.println("synchronized:");
        System.out.println("count1:"+count1);
        System.out.println("time:"+ (end1-start1));

        // 3. LongAddr
        long start3 = System.currentTimeMillis();
        Thread[] threads3 = new Thread[threadsNum];
        for (int i=0;i<threadsNum;i++){
            threads3[i] = new MyThread1();
            threads3[i] .start();
        }
        for (int i=0;i<threadsNum;i++){
            try {
                threads3[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end3= System.currentTimeMillis();
        System.out.println("LongAddr:");
        System.out.println("count3:"+count3);
        System.out.println("time:"+ (end3-start3));

    }

    static class MyThread3 extends Thread{
        @Override
        public void run() {
            count3.increment();
        }
    }
    static class MyThread2 extends Thread{
        @Override
        public void run() {
            for (int i=0;i<threadsNum;i++){
                count2.incrementAndGet();
            }
        }
    }

    static class MyThread1 extends Thread{
        @Override
        public void run() {
            for (int i=0;i<threadsNum;i++){
                synchronized (lock){
                    count1++;
                }
            }
        }
    }


}
