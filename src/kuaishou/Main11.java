package kuaishou;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 19:44
 * 1234 --> 1324
 */
public class Main11 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        divide(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * i表示奇数元素后的第一个偶数 j表示当前遍历的位置；
     */
    static void divide(int[] nums){
        int i=0;
        int n= nums.length;
        for (;i<n;i++){
            if ((nums[i] & 1)==0){ // 偶数
                break;
            }
        }
        if (i==n){
            return;
        }
        int j=i+1;
        for (;j<n;j++)
            if ((nums[j] & 1) != 0) {// 奇数
                swap(nums, i, j);
                i++;
            }
    }
    static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
