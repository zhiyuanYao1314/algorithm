package A18Threads.A1Thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 15:50
 *
 * 轮流打印
 * 使用park 和unpark
 *
 */
public class A22inteview3_7 {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=26;i++){
                    System.out.println(i);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char i='A';i<='Z';i++){
                    LockSupport.park();
                    System.out.println(i);
                    LockSupport.unpark(t1);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
