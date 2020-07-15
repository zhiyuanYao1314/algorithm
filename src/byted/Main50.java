package byted;

/**
 * 162 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 */
public class Main50 {
    public static void main(String[] args) {
        int n = findPeakElement2(new int[]{2,3,5,7,2});
        System.out.println(n);
    }
    public static int findPeakElement(int[] nums) {
        if (nums==null || nums.length==0 ){
            return -1;
        }
        if (nums.length==1){
            return 0;
        }
        if (nums[0]>nums[1]){
            return 0;
        }
        int n=nums.length;
        if (nums[n-1]>nums[n-2]){
            return n-1;
        }
        for (int i=1;i<n-1;i++){
            if (nums[i]>nums[i-1] && nums[i]>nums[i+1])
                return i;
        }
        return -1;
    }

    public static int findPeakElement2(int[] nums) {
        if (nums==null || nums.length==0 ){
            return -1;
        }
        if (nums.length==1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        int mid=-1;
        while (left<=right){// l = r =
            mid = left+ ((right-left)>>1);

            if ( (mid-1<0 || nums[mid]> nums[mid-1])
                && (mid+1>=nums.length || nums[mid]>nums[mid+1]))
                return mid;
            if (mid-1>=0 && nums[mid]<nums[mid-1]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return mid;
    }

}
