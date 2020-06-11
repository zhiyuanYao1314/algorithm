package A18Threads.A1Thread;

import java.util.concurrent.CyclicBarrier;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 19:19
 * Describe: 模拟CyclicBarrier使用
 * 人满发车，
 * version:1.0
 */
public class A9CyclicBarrier {

    CyclicBarrier barrier = new CyclicBarrier(5,()-> System.out.println("满5人，发车！"));
    // CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
    //     @Override
    //     public void run() {
    //         System.out.println("人满5，发车！");
    //     }
    // });

    public static void main(String[] args) {
        A9CyclicBarrier test = new A9CyclicBarrier();

        for (int i=0;i<14;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"达到目的地");
                        test.barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
