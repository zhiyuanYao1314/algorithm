package A19CollectionAndMap;

import java.util.PriorityQueue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 23:30
 *
 */
public class A2PriorityQueue {
    public static void main(String[] args) {
        // 内部是一个最小堆
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("b");
        queue.add("a");
        queue.add("d");
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
