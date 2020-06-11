package A15DP;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 16:45
 * LC45 跳跃游戏2 最小跳数
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 */
public class A7 {

    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int n = nums.length;
        // 初始化
        int[] dp = new int[n];
        for (int i=0;i<n;i++){
            dp[i] =Integer.MAX_VALUE;
        }
        dp[n-1] = 0;
        // dp
        for (int i=n-2;i>=0;i--){
            for (int j=i+1;j<n && j<=i+nums[i];j++){
                if (dp[j]==Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[0];
    }
}
