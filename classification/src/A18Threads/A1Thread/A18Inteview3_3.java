package A18Threads.A1Thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 22:51
 * Condition 实现生产者消费者模式
 *
 * 要求： 容器满的时候，所有的生产者等待
 *        容器空的时候，所有的消费者等待；
 *
 * 等待的原理：lock.wait() ,即：将当前的线程放入到队列中；
 * Condition 指的是：根据ReenntrantLock可以生成多个队列。
 * 生产者发现满的时候，await所有的生产者，notify所有的消费者；
 * 消费者相反；
 */
public class A18Inteview3_3<T> {

    ReentrantLock lock = new ReentrantLock();
    Condition producers = lock.newCondition();
    Condition consumers = lock.newCondition();

    Integer max = 10;
    ArrayList<T> container = new ArrayList<>(max);
    public A18Inteview3_3(int max){
        this.max= max;
    }
    int count;

    public void put(T o){
        lock.lock();
        if (count==max){
            try {
                producers.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        container.add(o);
        System.out.println(Thread.currentThread().getName()+"生产了"+o);
        count++;
        consumers.signalAll();
        lock.unlock();
    }

    public T get(){
        lock.lock();
        if (count==0){
            try {
                consumers.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T ret = container.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费了"+ret);
        count--;
        producers.signalAll();
        lock.unlock();
        return ret;
    }

    public static void main(String[] args) {
        A18Inteview3_3<Integer> test = new A18Inteview3_3<Integer>(10);
        for (int i=0;i<2;i++){
            new Thread(()->{
                for (int j=0;j<10;j++){
                    test.put(j);
                }
            }).start();
        }
        for (int i=0;i<5;i++){
            new Thread(()->{
                for (int j=0;j<3;j++){
                    test.get();
                }
            }).start();
        }
    }

}
