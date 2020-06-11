package A18Threads.A1Thread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/2 17:37
 * Describe:
 * version:1.0
 */
public class A7ReentrentLockTryLock {

    static ReentrantLock lock = new ReentrantLock();
    static public void m1(){
        boolean b=false;
        try {
            b = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("lock success: "+b);
        }catch (Exception e){
        }finally {
            if (b)lock.unlock();
        }
    }
    static void m2(){
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        new Thread(A7ReentrentLockTryLock::m2).start();
        new Thread(A7ReentrentLockTryLock::m1).start();

    }
}
