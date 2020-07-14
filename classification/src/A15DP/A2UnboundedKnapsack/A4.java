package A15DP.A2UnboundedKnapsack;

import A15DP.AO;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/5 15:33
 *零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 */
public class A4 {

    // 给定不同面额的硬币 coins 和一个总金额 amount。
    // 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    // 如果没有任何一种硬币组合能组成总金额，返回 -1。
    // dp[i][j] = min(dp[i-1][j]不用, dp[i-1][j-w]+1)用

    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max); // 数组所有元素填充不可能的元素
        dp[0] = 0; // 0元素，0总额，
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<amount+1;j++){
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount]>=max?-1:dp[amount];
    }

    // 正好，无限 从前往后  dp[n] = dp[n-arr]+dp[n];
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // 初始化；
        dp[0] =1; // 0 0为1种；
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                dp[j] = dp[j]+ dp[j-coins[i]];//
            }
        }
        return dp[amount];
    }

    // dp[i] = min(dp[i],dp[i-coins[j]);
    // 初始化： dp[0] = 1, amount+1;
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // dp[i] 表示考虑前j项的时候，
        Arrays.fill(dp, amount+1);
        dp[0] =1;
        for(int j=0;j<coins.length;j++){
            for(int i=coins[j];i<amount+1;i++){
                dp[i] = Math.min(dp[i], dp[i-coins[j]]);
            }
        }
        return dp[amount];
    }


}
