package A18Threads.A1Thread;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 17:27
 * 测试synchronized可重入锁
 * 可重入锁：同一个线程可以重复拿到一把锁。
 * m1 和 m2方法使用同一把锁，如果synchronized不可重入，
 * 那么m2方法会因为m1已经拿到锁而进不去。
 */
public class A6ReentrentSynchronized {

    public static void main(String[] args) {
        new Thread(A6ReentrentSynchronized::m1).start();

    }
    static int count=0;
    static synchronized void m1(){
        m2();
    }
    static synchronized void m2(){
        for (int i=0;i<3;i++){
            count++;
        }
    }

}
