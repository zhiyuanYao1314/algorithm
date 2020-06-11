package A18Threads;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/4 0:47
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        // service.submit();
        ReentrantLock r = new ReentrantLock(true);
        BlockingQueue q = new ArrayBlockingQueue(10);

        AtomicInteger in = new AtomicInteger();


        /**
         * 三个人都跑完步才能吃饭
         */
        Random ran = new Random();
        CyclicBarrier cb = new CyclicBarrier(3);
        for (int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("开始出发！");
                        Thread.sleep(ran.nextInt(1000));
                        cb.await(); // 每次调用 cb数量-- 直到为0的时候才开始
                        System.out.println("开始吃饭");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("3个部分都完成了，开始处理总结事情");


        Semaphore s = new Semaphore(2);
        s.acquire();
        s.release();


        ReentrantLock lock1 = new ReentrantLock();
        Condition c1 = lock1.newCondition();
        c1.await(); // 当前线程放入c1中等待；
        c1.notifyAll(); // 唤醒c1中的所有的线程。


        ThreadLocal tl = new ThreadLocal();
        tl.set("");
        tl.get();

        ReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock read = (ReentrantReadWriteLock.ReadLock) lock.readLock();
        read.lock();
        ReentrantReadWriteLock.WriteLock write= (ReentrantReadWriteLock.WriteLock)lock.writeLock();
        write.lock();
        read.unlock();

        // ReentrantLock lock = new ReentrantLock(true);
        //
        // lock.lock();
        // System.out.println("do something...");
        // lock.unlock();
        //
        // CountDownLatch latch = new CountDownLatch(1);
        // latch.countDown();
        // latch.await();

        // 数组+ lock锁+condition。
        PriorityBlockingQueue pbq = new PriorityBlockingQueue();
        pbq.put("");
        pbq.take();

        BlockingQueue qq = new PriorityBlockingQueue();
        qq.take();




    }

}
