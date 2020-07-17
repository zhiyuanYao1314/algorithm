package byted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 480 滑动窗口中位数
 *
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
 * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *
 */
public class Main68 {



//    public double[] medianSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        double[] ret = new double[nums.length-k+2];
//        int j=1;
//        // 假设k<=nums;
//        int[] ks = Arrays.copyOf(nums, k);
//        Arrays.sort(ks);
//        for (int i=0;i<(k-1)/2;i++){
//            maxHeap.add(ks[i]);
//        }
//        for (int i=(k-1)/2+1;i<k;i++){
//            minHeap.add(ks[i]);
//        }
//        if((k&1)==1){ // 奇数
//            ret[0] = maxHeap.peek();
//        }
//        for (int i=k;i<nums.length;i++){
//            if (minHeap.size()>maxHeap.size()){
////                minHeap.remove();
//            }
//        }
//
//    }
}
