package byted;

/**
 * 53 最大子序和
 * i 开始位置 j表示结束位置；
 *
 */
public class Main37 {

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int sum = nums[0];
        for (int i=1;i<nums.length;i++){
            if (sum>0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

}
