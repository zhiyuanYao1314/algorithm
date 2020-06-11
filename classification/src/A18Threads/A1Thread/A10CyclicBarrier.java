package A18Threads.A1Thread;

import sun.awt.windows.ThemeReader;

import java.util.FormatFlagsConversionMismatchException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.prefs.BackingStoreException;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 19:37
 * CyclicBarrier 应用二，所有人全部跑完步再吃饭
 */
public class A10CyclicBarrier {
    static CyclicBarrier barrier = new CyclicBarrier(5);
    public static void main(String[] args) {
        for (int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "跑完步！");
                        barrier.await();
                        System.out.println(Thread.currentThread().getName() + "吃饭！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
