package A18Threads.A1Thread;

import java.util.concurrent.CountDownLatch;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 19:15
 * countDownLatch示例
 * main线程等所有的线程处理完在处理
 */
public class A8CountDownLatch {

    public void m1(){
        System.out.println(Thread.currentThread().getName()+"完成工作");
        latch.countDown();
    }

    CountDownLatch latch = new CountDownLatch(5);
    public static void main(String[] args) {
        A8CountDownLatch test = new A8CountDownLatch();
        for (int i=0;i<5;i++){
            new Thread(test::m1).start();
        }
        try {
            test.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始总结所有线程的成果");
    }
}
