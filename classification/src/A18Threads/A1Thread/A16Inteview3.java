package A18Threads.A1Thread;

import com.sun.corba.se.spi.ior.ObjectKey;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 17:01
 * 两个线程交叉打印A1B2....Z26
 *
 * 思路:
 * 一个线程打印完等待 通知另外一个线程。
 * 简单版本：但是需要 确保打印数字线程先运行！
 */

public class A16Inteview3 {
    static boolean cFirstcan =false;
    static Object lock = new Object();
    static void printC() throws InterruptedException {
        for (char i='A';i<='Z';i++){
            synchronized (lock){
                System.out.println(i);
                lock.notify();
                if (i!='Z'){
                    lock.wait();
                }
            }
        }
    }
    static void printDigit() throws InterruptedException {
        for (int i=0;i<26;i++){
            synchronized (lock){
                System.out.println(i+1);
                lock.notify();
                lock.wait();
            }
        }
    }

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                printDigit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }



}
