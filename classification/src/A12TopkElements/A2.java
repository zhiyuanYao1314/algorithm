package A12TopkElements;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 13:01
 * 前k个高频元素
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class A2 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计词频
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        // 2.构建只含有k个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue((o1,o2)-> (
                map.get(o1)-map.get(o2)));
        for (Integer i:map.keySet()){
            minHeap.add(i);
            if (minHeap.size()>k) minHeap.poll();
        }
        // 3. 取出作为结果
        int[] ans = new int[k];
        while (!minHeap.isEmpty()){
            ans[--k] = minHeap.poll();
        }
        return ans;
    }
}
