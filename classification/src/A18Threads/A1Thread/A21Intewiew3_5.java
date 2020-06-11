package A18Threads.A1Thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 14:49
 * 轮流打印1A2B3C...
 *
 * 使用BlockingQueue的put take操作的阻塞性
 * 即： 一个线程put了，必须等另外一个线程拿了才能继续执行；
 */
public class A21Intewiew3_5 {

    static BlockingDeque<Integer> q1 = new LinkedBlockingDeque(1);
    static BlockingDeque<Character> q2 = new LinkedBlockingDeque(1);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=26;i++){
                    System.out.println(i);
                    try {
                        q1.put(i);
                        q2.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (char i='A';i<='Z';i++){
                    try {
                        q1.take();
                        System.out.println(i);
                        q2.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}