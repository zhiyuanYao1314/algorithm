package A18Threads.A2ThreadPool;

import com.sun.org.glassfish.gmbal.AMXMBeanInterface;

import java.util.concurrent.*;
public class A4RejectHandler {
    public static void main(String[] args) {
        new ThreadPoolExecutor(1,
                1,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                new MyHandler()
        );
    }
    static class MyHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 记日志 log("r rejected");
            // 保存在 save r kafka mysql redis
            // try again
            if (executor.getQueue().size()<1000){
                // try again;
            }
        }
    }
}

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/8 0:05
 * Describe:
 * version:1.0
 */
