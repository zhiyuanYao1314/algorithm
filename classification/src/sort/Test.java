package sort;
import java.util.LinkedList;
import java.util.Queue;


// 主线程类： 负责读取数据，然后分配给7个线程进行处理
public class Test {
    // 7个线程，每个线程处理一个集合。
    static Queue<String>[] lines = new LinkedList[7];

    public static void main(String[] args) {
        // 创立7个队列集合，由7个线程进行处理。
        for (int i=0;i<7;i++){
            lines[i] = new LinkedList<>();
        }
        // 开启7个线程,把对应的集合交给对应的线程处理。
        for (int i=0;i<7;i++){
            Thread threadi = new Thread(new MyThread(lines[i]));
            threadi.start();
        }
        // 循环读取所有文件内容
        int i=0;
        String readLine = "hello";
        while (true){
            // 把数据依次地放入集合中。
            int k = (i++)%7;
            lines[k].add(readLine);
            // 放入数据后 唤醒对应的子线程进行处理。
            lines[k].notifyAll();
        }
    }
}
