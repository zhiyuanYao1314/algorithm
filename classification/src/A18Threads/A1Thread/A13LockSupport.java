package A18Threads.A1Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 14:11
 * LockSupport实现的功能：能够让一个线程运行到指定的位置出park(停车)，等待其他的线程取unpark它。
 *与synchronized对象的wait()和notify对比：唤醒一个线程是取等待池中唤醒，
 */
public class A13LockSupport {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
                for (int i=0;i<10;i++){
                    if (i==3){
                        LockSupport.park();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        LockSupport.unpark(thread);
    }
}
