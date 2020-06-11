package A18Threads.A1Thread;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 17:26
 * 两个线程交叉打印A1B2....Z26
 *
 * 思路:
 * 一个线程打印完等待 通知另外一个线程。
 * 一个boolean 变量控制哪个线程打印
 *  每次打印前， while 如果不该自己打印，就wait(), 否者，打印完，通知
 *
 *  方法1： 只是用一个boolean，不使用锁；
 *  方法2: 只是用锁， 需要确保一个先执行
 *  方法2：使用boolean和锁；自己执行完马上通知其他人；
 * 为什么既需要wait notify 还需要boolean 判断。
 * 因为 只有wait notify的话，需要保证一个线程先开始，另外一个后开始；
 */
public class A17Inteview3_2 {
    Object lock = new Object();
    boolean isD = true;
    public static void main(String[] args) {
        System.out.println("开始");
        A17Inteview3_2 test = new A17Inteview3_2();
        new Thread(test:: printC).start();
        new Thread(test:: printD).start();
    }

    void printD2(){
        for (int i=1;i<=26;i++){
            while (!isD){} // 不是D 空转
            System.out.println(i);
            isD = false;
        }
    }

    void printC2(){
        for (char i='A';i<='Z';i++){
            while (isD){} // 是D 空转
            System.out.println(i);
            isD = true;
        }
    }
    void printD(){
        for (int i=1;i<=26;i++){
            synchronized (lock){
                if (!isD){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                isD = false;
                lock.notify();
            }
        }
    }

    void printC(){
        for (char i='A';i<='Z';i++){
            synchronized (lock){
                if (isD){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                isD = true;
                lock.notify();
            }
        }
    }

}
