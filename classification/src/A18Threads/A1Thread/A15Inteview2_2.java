package A18Threads.A1Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 17:54
 * 一个满足生产者消费者模式的容器：
 *  容器， get/put方法， count方法。
 *  线程安全 2个线程放，5个线程取。
 */
public class A15Inteview2_2 {
    int MAX = 10;
    List<Integer> container = new ArrayList<>(MAX);
    int count;

    /**
     * 往容器中放入元素，
     * 如果满了，则一直等待；
     *
     */
    public synchronized void put(int i) throws InterruptedException {
        while (container.size()==MAX){
            this.wait();
        }
        container.add(i);
        System.out.println("生成了"+i);
        this.notify();
    }
    public synchronized int get() throws InterruptedException {
        while (container.size()==0){
            this.wait();
        }
        int k = container.remove(0);
        System.out.println("消费了"+k);
        this.notify();
        return k;
    }

    public static void main(String[] args) throws InterruptedException {
        A15Inteview2_2 test = new A15Inteview2_2();
        for (int i=0;i<2;i++){
            new Thread(()->{
                for (int j=0;j<20;j++){
                    try {
                        test.put(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<3;j++){
                    try {
                        test.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}