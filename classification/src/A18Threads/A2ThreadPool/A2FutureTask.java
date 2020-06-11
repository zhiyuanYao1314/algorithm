package A18Threads.A2ThreadPool;

import java.util.concurrent.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 16:28
 * FutureTask集合了callable和 future
 * 既是一个任务，有含有返回值 future
 *
 *
 */
public class A2FutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(()->
        {
            TimeUnit.SECONDS.sleep(1);
            return 1000;
        });
        new Thread(task).start();
        System.out.println(task.get());

        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(3);


        // new ThreadPoolExecutor()

    }
}
