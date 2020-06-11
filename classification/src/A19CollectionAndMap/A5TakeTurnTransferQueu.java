package A19CollectionAndMap;

import com.sun.corba.se.spi.ior.ObjectKey;

import javax.swing.text.html.HTMLWriter;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 0:05
 * 使用transfer 轮流打印，还是必须使用synchronzied
 * 因为 必须要两个人交替！
 */
public class A5TakeTurnTransferQueu {
    static boolean isA =true;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> q = new LinkedTransferQueue<>();
        SynchronousQueue<String> q2 = new SynchronousQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=26;i++){
                    try {
                        synchronized (lock){
                            while (isA){
                                lock.wait();
                            }
                            q2.put(i+"");
                            // q.transfer(i+"");
                            isA=true;
                            lock.notify();
                        }

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
                    synchronized (lock){
                        try {
                            while (!isA){
                                lock.wait();
                            }
                            q2.put(i+"");
                            // q.transfer(i+"");
                            isA=false;
                            lock.notify();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        }).start();

        while (true){
            System.out.println(q2.take());
        }
    }

}
