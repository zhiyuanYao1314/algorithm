package kuaishou;

import java.util.HashSet;
import java.util.Set;

/**
 * 128 最长连续序列
 */
public class Main2 {
    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{1, 5, 4, 3});
        System.out.println(i);
    }

    /**
     * 最长连续子序列 复杂度O(n);
     */
    public static int longestConsecutive(int[] nums) {
        // 1. 使用set 存储所有的元素
        Set<Integer> s = new HashSet<>();
        for (int i =0;i<nums.length;i++){
            s.add(nums[i]);
        }
        int ans =1;
        // 2. 遍历所有的元素；
        for (int i =0;i<nums.length;i++){
            int cur =nums[i];
            // 2.1 如果有比该元素还小的元素，则不计算该元素为起点的连续长度
            if (s.contains(cur-1)){
                continue;
            }
            // 2.2 计算以nums[i]，即cur为起点的连续长度count
            int count =1;
            while (s.contains(cur+1)){
                cur++;
                count++;
            }
            // 2.3 和ans比较，取最大值；
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
