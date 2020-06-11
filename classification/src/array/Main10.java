package array;

import org.omg.CORBA.FREE_MEM;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class Main10 {
    public static void main(String[] args) {
        Main10 main10 = new Main10();
        ArrayList<Integer> list = main10.GetLeastNumbers_Solution(new int[]{1, 2, 3, 4}, 3);
        System.out.println(list.toString());
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input==null || k>input.length)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue((o1,o2)->((Integer)o2-(Integer) o1));
        for (int i=0;i<input.length;i++){
            maxHeap.add(input[i]);
            if (maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
