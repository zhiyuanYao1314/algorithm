package zhoucongAli;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/4 1:19
 * Describe:
 * version:1.0
 */


public class Main3{

    //第二题 2、给定一个未排序的整数数组，找出最长连续序列的长度。 例如，
    // 给出 [100, 4, 200, 1, 3, 2]，
    // 这个最长的连续序列是 [1, 2, 3, 4]。返回所求长度： 4。

    public static void main(String[] args) {
        // 特殊值测试案例0:
        int[] nums0 = new int[]{};
        int ans0 = maxLength(nums0);
        System.out.println(ans0); // 0
        // 测试案例1：
        int[] nums1 = new int[]{100, 4, 200, 1, 3, 2};
        int ans1 = maxLength(nums1);
        System.out.println(ans1); // 4
        // 测试案例2
        int[] nums2 = new int[]{100, 5, 200, 1, 3, 8};
        int ans2 = maxLength(nums2);
        System.out.println(ans2); //1
    }

    static int maxLength(int[] nums){
        // 0. 特殊值判断
        if (nums==null || nums.length==0){
            return 0;
        }
        // 1. 排序
        Arrays.sort(nums);
        int i=0; // 连续长度的起始点
        int n = nums.length;
        int max=0; // 当前的最大长度
        // 2. 一次遍历
        while (i<n-1){
            int cur = i;
            // 如果一直是递增；循环
            while (cur+1<n && nums[cur]+1 ==nums[cur+1]){
                cur++;
            }
            // 退出循环，与当前的最大值进行对比
            max = Math.max(max, cur-i+1);
            i =cur+1;
        }
        return max;
    }

}