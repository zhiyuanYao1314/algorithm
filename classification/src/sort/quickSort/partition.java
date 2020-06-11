package sort.quickSort;

import static sort.QuickSort.swap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/26 17:06
 * Describe:
 * version:1.0
 */
public class partition {

    public static void main(String[] args) {

    }


    /**
     * 荷兰国旗问题
     *
     */
    void Partition3(int[] nums, int k){
        //
        int smaller =-1; // <k的右边界
        int bigger = nums.length; // >k的左边界
        for (int i=0;i<bigger;){
            if (nums[i]<k){
                swap(nums, i++, ++smaller);
            }else if (nums[i]>k){
                swap(nums, i,--bigger);
            }
        }
    }

    // 单指针
    int Partition2(int[] nums){
        int s = -1; // 表示<=区的有边界
        int n = nums[0];
        for (int i=0;i<nums.length;i++){
            if (nums[i]<=n){
                swap(nums, ++s, i);
            }
        }
        return s;
    }

    int Partition(int[] nums){
        int n = nums.length;
        int left = 0; // <=区
        int right = n-1;
        int k = nums[0];
        while (left<right){
            while (right>left && nums[right]<=k){ // 右边找小等值
                right--;
            }
            while (left<right && nums[left]>k){
                left++;
            }
            if (left<right){
                swap(nums, left, right);
            }
            // 左边找大值
        }
        return left;
    }
}