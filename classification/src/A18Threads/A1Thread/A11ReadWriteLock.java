package A18Threads.A1Thread;

import java.lang.reflect.AccessibleObject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 22:14
 * 读写锁测试
 *
 */
public class A11ReadWriteLock {
    // 互斥锁
    static Lock lock = new ReentrantLock();
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 读锁
    static Lock readLock = readWriteLock.readLock();
    // 写锁
    static Lock writeLock = readWriteLock.writeLock();

    //
    static double value;
    public static void read(Lock lock) {
        try {
            lock.lock();
            System.out.println("read over");
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public static void write(Lock lock, double i){
        try {
            lock.lock();
            value = i;
            System.out.println("write over");
            Thread.sleep(1000);
        } catch (Exception e){
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        /* 测试1：采用ReentrantLock互斥锁:
        这样在运行的时候，不论读写都要等拿到锁的线程运行完，才能去枪锁，
        所以，18个读线程和2个写线程至少需要20s。
         */
        // Runnable readThread = ()-> read(lock);
        // Runnable writeThread = ()->write(lock, Math.random());
        /*
        测试2： 采用读锁和写锁。
        他们是由同一把ReentrantReadWriteLock锁生成的，
        在读操作上加读锁，在写操作上加写锁。
        所以，读可以一起执行，时间大约1s，写一个个执行，需要2s，
        总时间大约3s。
         */
        Runnable readThread = ()-> read(readLock);
        Runnable writeThread = ()->write(writeLock, Math.random());
        for (int i=0;i<18;i++){
            new Thread(readThread).start();
        }
        for (int i=0;i<2;i++){
            new Thread(writeThread).start();
        }
    }


}
