package byted;

/**
 * 33 搜索旋转排序数组
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 核心： 一分为二， 肯定有一半为递增；
 */
public class Main12 {
    public static void main(String[] args) {
        System.out.print(search(new int[]{1,3}, 3));
    }

    public static int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        int mid;
        while (left<=right){
            mid = left+ ((right-left)>>1);
            if (target==nums[mid])
                return mid;
            if (nums[mid]<nums[right]){ // 右半段有序
                if (target> nums[mid] && target<=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }else { // 左半段有序
                if (target<nums[mid] && target>=nums[left])
                    right = mid-1;
                else 
                    left = mid+1;
            }
        }
        return -1;
    }
}
