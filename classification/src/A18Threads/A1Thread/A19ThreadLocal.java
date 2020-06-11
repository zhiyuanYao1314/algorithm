package A18Threads.A1Thread;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/4 15:58
 *
 * ThreadLocal 本地线程原理和演示
 *
 * 使用： 每个线程向里面放的时候，取到的是自己线程的东西；
 *      使用场景举例：声明式事务。 Mybatis中，DAO层数据库操作，Service层的事务都需要用到Connection数据库连接。
 *      一个线程中的Connection需要保证同一份；通过ThreadLocal.
 * 每个ThreadLocal
 */
public class A19ThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                local.set(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"线程1").start();

        new Thread(()->{
            try {
                local.set(1);
                local.remove();
                Thread.sleep(2000);
                System.out.println(local.get()); // 获取到的不是3，说明线程2获取到的是自己的
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"线程2").start();
    }
}
