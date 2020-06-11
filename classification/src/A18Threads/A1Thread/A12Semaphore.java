package A18Threads.A1Thread;

import java.util.concurrent.Semaphore;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 22:53
 * Describe:
 * version:1.0
 */
public class A12Semaphore {
    static Semaphore s= new Semaphore(3);
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()-> {
                try {
                    s.acquire();
                    System.out.println(Thread.currentThread().getName()+"开始售票!");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"售票完成!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    s.release();
                }
            }).start();
        }
    }
}
