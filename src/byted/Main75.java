package byted;

/**
 * 无限背包 凑够target目标的数量：
 *
 */
public class Main75 {
    public static void main(String[] args) {
        int s = count(new int[]{1,2}, 4);
        System.out.println(s);

    }
    public static int count(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] =1;
        for (int i=0;i<nums.length;i++){
            for (int j=nums[i];j<target+1;j++){
                dp[j] = dp[j-nums[i]]+dp[j];
            }
        }
        return dp[target];
    }
}
