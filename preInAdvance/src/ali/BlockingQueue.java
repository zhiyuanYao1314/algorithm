package ali;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个blocking queue
 */
public class BlockingQueue{

    Integer[] container;
    int size;
    int curSize;
    int putIndex;
    int getIndex;

    ReentrantLock lock;
    Condition producerCon;
    Condition consumerCon;
    public BlockingQueue(int size){
        this.size = size;
        container = new Integer[size];
        lock = new ReentrantLock();
        producerCon = lock.newCondition();
        consumerCon = lock.newCondition();
    }

    void put(int n) throws InterruptedException {
        if (lock.tryLock()){
            if (curSize==size){
                producerCon.await();
            }
            container[putIndex]= n;
            nextIndex("putIndex");
            consumerCon.notify();
        }else {
            put(n);
        }
    }
    void get() throws InterruptedException {
        if (lock.tryLock()){
            if (curSize==0){
                consumerCon.await();
            }
            int res = container[getIndex];
            nextIndex("getIndex");
            producerCon.notify();
        }else {
            get();
        }
    }
    void nextIndex(String str){
        if ("putIndex".equals(str)){
            putIndex++;
            if (putIndex==size){
                putIndex=0;
            }
        }else {
            getIndex++;
            if (getIndex==size){
                getIndex=0;
            }
        }
    }







}
