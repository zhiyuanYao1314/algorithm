
public class BlockingQueue {
    // 队列，用来给生产者存放元素，消费者消费元素
    int[] queue;

    // 队列的大小
    int size;

    Object lock; // 锁

    // 当前可以放入元素的下标
    int putIndex;

    // 当前获取元素的下标
    int getIndex;

    //当前的大小
    int curSize;

    /**
     * 构造方法
     * @param size
     */
    BlockingQueue(int size){
        this.size = size;
        queue = new int[size];
    }

    /**
     * 放入元素
     * @param k
     */
    void put(int k) throws InterruptedException {
        synchronized (lock){
            // 1.queue放满了，等待
            while (curSize==size){
                lock.wait();
            }
            // 2. 没有放满
            queue[putIndex]=k; // 放入元素
            putIndexnext();
            curSize++;
            lock.notify();// 唤醒其他线程；
        }
    }

    /**
     * 获取元素
     * @return
     */
    int get() throws InterruptedException {
        synchronized (lock){
            // 1.queue为空，等待
            while (curSize==0){
                lock.wait();
            }
            // 2. 队列里有元素
            int res = queue[getIndex]; // 获取元素
            getIndexnext();
            curSize--;
            lock.notify();// 唤醒其他线程；
            return res;
        }
    }

    /**
     *下一个线程放置元素的位置；
     * 循环队列，当元素放置的位置到达最后一个后，
     * 再从头开始；
      */
    int putIndexnext(){
        putIndex++;
        if (putIndex==size){
            putIndex=0;
        }
        return putIndex;
    }
    /**
     *下一个线程获取元素的位置；
     * 循环队列，当元素获取的位置到达最后一个后，
     * 再从头开始；
     */
    int getIndexnext(){
        getIndex++;
        if (getIndex==size){
            getIndex=0;
        }
        return getIndex;
    }
}
