package byted;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * lc 剑指offer 41 数据流中的中位数
 */
public class Main67 {


}


class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        minHeap = new PriorityQueue();
        size=0;

    }

    public void addNum(int num) {
        // 偶数，加入到最大堆
        if ((size&1)==0){
            if (minHeap.size()==0){
                maxHeap.add(num);
            }else {
                int p = minHeap.poll();
                int min = Math.min(p, num);
                int max = Math.max(p,num);
                maxHeap.add(min);
                minHeap.add(max);
            }
        }else { // 偶数 加入到最小堆，最小堆是大的元素
            int p = maxHeap.poll();
            int min = Math.min(p,num);
            int max = Math.max(p,num);
            maxHeap.add(min);
            minHeap.add(max);
        }
        size++;
    }

    public double findMedian() {
        if ((size&1)==1){ //
            return maxHeap.peek();
        }
        return  ((double)maxHeap.peek()+minHeap.peek())/2;
    }
}
