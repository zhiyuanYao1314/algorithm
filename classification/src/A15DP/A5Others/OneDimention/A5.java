package A15DP.A5Others.OneDimention;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 16:10
 * LC 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度
 * 判断你是否能够到达最后一个位置。
 * [2,3,1,1,4]
 * 输出: true
 *
 * [3,2,1,0,4]
 * 输出: false
 */
public class A5 {

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