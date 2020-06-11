package A18Threads.A1Thread;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.zip.Adler32;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 14:29
 * 实现两个容器，add size()
 * 线程1添加10个元素，线程2监控容器的数量，当添加5个元素的时候，线程2打印出提示并暂停，线程1继续执行完。
 * 不能一个等一个执行。 使用wait和notify
 * 实现分析：
 * 线程1 打印到5的时候，通知线程2，自己等待。
 * 线程2 等待通知，再打印结束，再通知线程2.

 */
public class A14Inteview1 {

    static List<Integer> container = new ArrayList<>();
    static void add(int i){
        container.add(i);
    }
    static int size(){return container.size();}
    static Object lock = new Object();

    public static void main(String[] args) {
        // 监控
        Thread t1 = new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait();
                    System.out.println("have 5!");
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 运行
        Thread t2 = new Thread(()->{
            for (int i=0;i<10;i++){
                synchronized (lock){
                    if (container.size()==5){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    add(i);
                    System.out.println("添加"+i);
                }
            }
        });
        t1.start();
        t2.start();

    }

}
