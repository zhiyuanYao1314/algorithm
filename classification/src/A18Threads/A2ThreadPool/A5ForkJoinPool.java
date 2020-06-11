package A18Threads.A2ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/9 14:39
 *
 */
public class A5ForkJoinPool {
    public static void main(String[] args) throws IOException {

        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(5);
        ExecutorService service = Executors.newWorkStealingPool();
        ForkJoinPool fjp = new ForkJoinPool();
        Task task = new Task(0, num.length);
        fjp.execute(task);
        long result = (long) task.join();
        System.out.println(result);
    }
    static int[] num = new int[100_0000];
    static Random random = new Random();
    static {
        for (int i=0;i<num.length;i++){
            num[i] = random.nextInt(100);
        }
    }
    static class Task extends RecursiveTask {
        int start ;
        int end ;
        Task(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        protected Long compute() {
            // 退出条件
            if (end-start<=5000){
                long sum =0L;
                for (int i=start;i<end;i++){
                    sum +=num[i];
                }
                // System.out.println("from "+start+" to"+end + " sum is "+ sum);
                return sum;
            }
            int mid = start + (end-start)/2;
            Task left = new Task(start, mid);
            Task right = new Task(mid, end);
            left.fork();
            right.fork();
            return (Long) (left.join())+(Long)(right.join());
        }
    }
}
