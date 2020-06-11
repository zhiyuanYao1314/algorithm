package alibaba;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/30 12:47
 * Describe:
 * version:1.0
 */
public class Test1 {

    // 打印的起始数
    private int index = 1;
    // 控制两个线程轮流打印
    private boolean P1hasPrint= false;
    // 锁
    private Object lock = new Object();
    // 打印数字的最大值
    private final int printMaxNumber = 100;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Thread p1 = new Thread(test1.new P1());
        Thread p2 = new Thread(test1.new P2());
        p1.start();
        p2.start();

    }

    public class P1 implements Runnable{
        @Override
        public void run() {
            for (int i =0;i<printMaxNumber/2;i++){
                synchronized (lock){
                    while (P1hasPrint){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("P1: "+index++);
                    P1hasPrint = true;
                    lock.notifyAll();
                }
            }
        }
    }
    public class P2 implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<printMaxNumber/2;i++){
                synchronized (lock){
                    while (!P1hasPrint){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("P2: "+ index++);
                    P1hasPrint = false;
                    lock.notifyAll();
                }
            }
        }
    }
}
