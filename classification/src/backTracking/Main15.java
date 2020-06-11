package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/16 16:37
 * 35 下一个排列
 *
 * 优化一下！
 */
public class Main15 {
    public static void main(String[] args) {
        int[] ints = {1, 5, 9, 7, 2};
        new Main15().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length==0 || nums.length==1) return;
        // 1. 找到倒序
        int n = nums.length-1;
        int i = n;
        while (i-1>=0 &&nums[i]<=nums[i-1]){
            i--;
        }
        if (i==0){
            // reverse
            sort(nums,-1);
            return;
        }
        // 2. 找到大于的进行交换
        int k =i-1;
        while (i<nums.length && nums[i]>nums[k]){
            i++;
        } // i-1
        swap(nums, k, i-1);
        sort(nums, k); // 不包括k
        return;
        // 3. 重排序
    }

    private void sort(int[] nums, int k) {

        List<Integer> tmp = new ArrayList<>();
        for (int i=k+1; i<nums.length;i++){
            tmp.add(nums[i]);
        }
        int j=0;
        for (int i = nums.length-1; i>=k+1;i--){
            nums[i] = tmp.get(j++);
        }
    }
    private void swap(int[] nums, int k, int i) {
        int tmp = nums[k];
        nums[k] = nums[i];
        nums[i] = tmp;
    }

}
