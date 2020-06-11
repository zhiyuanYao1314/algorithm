package A19CollectionAndMap;

import java.util.concurrent.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 23:19
 */

class Task implements Delayed{
    long time;
    Task(long time){
        this.time = time;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS)){
            return -1;
        }else if (this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS)){
            return 1;
        }else return 0;
    }
}

public class A1DelayQueue {
    public static void main(String[] args) throws InterruptedException {
        // 基于PriorityQueue
        BlockingQueue<Task> delayqueue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        delayqueue.put(new Task(now+3000));
        delayqueue.put(new Task(now+4000));
        delayqueue.put(new Task(now+6000));
        System.out.println("---任务启动--");
        for (int i=0;i<3;i++){
            System.out.println(delayqueue.take());
        }
    }
}
