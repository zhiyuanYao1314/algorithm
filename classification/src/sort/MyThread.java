package sort;

import java.util.HashMap;
import java.util.Queue;

//每个处理的线程
public class MyThread implements Runnable {
    // 维护自己的map， 放入对应的单词和数量
    HashMap<String,Integer> map = new HashMap();

    // 处理主线程放入的数据
    Queue<String> line ;

    public MyThread(Queue<String> line){
        this.line = line;
    }
    @Override
    public void run() {
        while (true){
            // 对单词集合数据加锁
            synchronized (line){
                // 当单词集合为空的时候，等待，
                while (line.isEmpty()) {
                    try {
                        line.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 不为空的时候，把所有数据取出，处理
                while (!line.isEmpty()){
                    String s = line.poll();
                    // 进行字符串的处理 读取放到map中。
                    // 。。。
                }
                //处理完 通知主线程 继续读入数据。
                line.notifyAll();
            }
        }
    }
}
