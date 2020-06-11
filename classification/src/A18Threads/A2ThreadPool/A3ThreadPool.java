package A18Threads.A2ThreadPool;

import java.util.concurrent.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 20:19
 */
public class A3ThreadPool {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        //  核心线程数 最大线程数 保活时间 队列 线程工厂 拒绝策略
        ThreadPoolExecutor service = new ThreadPoolExecutor(2,
                3,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
        for (int i=0;i<5;i++)
            service.submit(task);

        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(3);
        ScheduledExecutorService delays = Executors.newScheduledThreadPool(3);
        // delays.scheduleAtFixedRate();
        Executors.newSingleThreadExecutor();

    }
}
