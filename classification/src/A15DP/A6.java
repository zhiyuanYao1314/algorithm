package A15DP;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 16:10
 * LC 55. 跳跃游戏
 */
public class A6 {

    public boolean canJump(int[] nums) {
        if (nums.length==1) return true;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] =true;
        int index = nums.length-2;
        for (;index>=0;index--){
            for (int i=index+1; i<nums.length && i<= index+nums[index];i++){
                if (dp[i]==true){
                    dp[index]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}