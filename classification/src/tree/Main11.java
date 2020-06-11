package tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.zip.Inflater;

/**
 *如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Main11 {
    /**
     * 维护一个最大堆和最小堆，
     * 在记录一个数量，
     */
    public static void main(String[] args) {

        Main11 main11 = new Main11();
        main11.Insert(1);
        main11.Insert(2);
        main11.Insert(3);
        main11.Insert(4);
        System.out.println(main11.GetMedian());
    }
    // 最大堆
    PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)-> o2-o1);

    // 最小堆
    PriorityQueue<Integer> min = new PriorityQueue<>();

    // size
    int size=0;
    public void Insert(Integer num) {
        size++;
        // 先放入最小堆
        if (size%2==1){
            max.add(num);
            min.add(max.poll());
            // 在放入最大堆
        }else {
            min.add(num);
            max.add(min.poll());
        }
    }

    public Double GetMedian() {
        //奇数
        if ((size&1)==1){
            System.out.println("奇数");
            return new Double(min.peek());
        }else {
            return (min.peek()+max.peek())/2.0;
        }
    }
}
