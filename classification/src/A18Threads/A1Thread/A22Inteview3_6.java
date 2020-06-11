package A18Threads.A1Thread;

import java.io.FileReader;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 15:03
 * 轮流打印
 * 使用condition
 *
 */
public class A22Inteview3_6 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition c1 = lock.newCondition();
    static Condition c2 = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for (int i=1;i<=26;i++){
                    try {
                        System.out.println(i);
                        c2.signalAll();
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                    }
                }
                c2.signalAll(); // 1号结束后记得最后在唤醒2号，否则2号会一直等待！
                lock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char i='A';i<='Z';i++){
                    try {
                        lock.lock();
                        System.out.println(i);
                        c1.signalAll();
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
    }
}
