package byted;

/**
 * 209 长度最小的子数组
 * 总结：这种涉及到连续子序列的问题，可以考虑双指针的方法；
 *
 */
public class Main24 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int left = 0;
        int right = 1;
        if (nums[left]>=s)
            return 1;
        int sum= nums[left];
        int ret=Integer.MAX_VALUE;
        for (;right<nums.length;right++){
            sum += nums[right];
            if (sum>=s){
                while (sum>=s){
                    ret = Math.min(ret, right-left+1);
                    sum -= nums[left++];
                }
            }
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
}
