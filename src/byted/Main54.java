package byted;

import java.util.*;

/**
 * 347 前k个高频词汇
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class Main54 {

    public static void main(String[] args) {
        Main54 m  = new Main54();
        int[] s = m.topKFrequent(new int[]{2,2,2,2,3,3,7,7,5,5,5,5,5,6,7},3);
        System.out.println(Arrays.toString(s));
    }
    class Node implements Comparable{
        int val;
        int count;
        Node (int val, int count){
            this.val = val;
            this.count = count;
        }
        @Override
        public int compareTo(Object o) {
            return ((Node)o).count-this.count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        for (int num : nums){
            if (map.get(num)==null){
                Node cur = new Node(num ,1);
                map.put(num, cur);
            }else {
                map.get(num).count += 1;
            }
        }
        Collection<Node> cs =  map.values();
        PriorityQueue<Node> pq = new PriorityQueue(cs);
        int[] ret = new int[k];
        int i=0;
        while (i<k){
            ret[i++] = pq.poll().val;
        }
        return ret;
    }
}
