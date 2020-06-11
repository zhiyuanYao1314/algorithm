package A18Threads.A2ThreadPool;

import java.util.concurrent.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 16:17
 *
 * Executors
 */
public class A1CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 定义一个具有返回值的task
        Callable<Integer> task = new Callable() {
            @Override
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                return 1;
            }
        };
        // 创建一个线程池的服务
        ExecutorService service = Executors.newFixedThreadPool(5);
        //向该服务中提交一个任务 （异步的），提交完，主线程继续执行；
        Future<Integer> answer = service.submit(task);
        // future的get()方法是阻塞的，当前线程必须拿到值之后才能继续执行
        System.out.println(answer.get());
        System.out.println(answer.isDone());
    }

}
