package A12TopkElements;

import java.awt.font.NumericShaper;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 14:38
 * leetcode 215. 数组中的第K个最大元素
 * 这里采用方法一。
 * 1. 方法一 快排 最好的复杂度: logN
 * 2 方法二 大顶堆 nlogK
 * 3. 直接Sort nlogN
 */
public class A4 {

    public static void main(String[] args) {
        A4 a4 = new A4();
        int[] nums = new int[]{3,2,1,5,6,4};
        int ans= a4.findKthLargest(nums,2);
        System.out.println(ans);
    }

    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        return findKthSmallest(nums, 0,len-1, len+1-k); // 4
    }

    public int findKthSmallest(int[] nums, int s, int e, int k){
        int index = partition(nums, s, e);
        if (index-s==k-1)
            return nums[index];
        if (index-s>k-1){
            return findKthSmallest(nums,s,index-1, k);
        }else {
            return findKthSmallest(nums,index+1,e,k-(index-s+1));
        }
    }
    // 返回第一个元素在数组中的位置。
    public int partition(int[] nums, int start, int end){
        int first = nums[start];
        int firstIndex = start;
        while (start<end){
            while (end>start && nums[end]>first) end--; // 先从右边开始
            while (start<end && nums[start]<=first) start++; // 再从左边开始
            if (start<end) swap(nums, start, end); // 交换
        }
        swap(nums, firstIndex , end);
        return end;
    }
    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }



}
