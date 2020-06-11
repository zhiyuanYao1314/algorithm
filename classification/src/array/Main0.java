package array;

import static sort.QuickSort.swap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 12:49
 * 荷兰国旗问题
 * 将一个数组按给定的元素划分成三部分，要求左边<， 中间相等，右边>
 */
public class Main0 {

    /**
     *
     */
    void partition(int[] nums, int pivot){
        int L = -1; // 小于pivot的元素的右边界
        int R = nums.length; // 大于pivot的元素的左边界
        int s =0;
        while (s<R){
            if (nums[s]<pivot){
                swap(nums,s++,++L);
            }else if (nums[s]>pivot){
                swap(nums, s, --R);
            }else {
                s++;
            }
        }
    }

}
