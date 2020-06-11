package A15DP.A3Fibonacci;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 12:04
 * 爬楼梯
 */
public class A2 {
    public int climbStairs(int n) {
        // 1:1 2:2 3:3
        if (n<=3) return n;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 0 <= n <= 100
     */
    public int numWays(int n) {
        int a=0;
        int b=1;
        int sum=1;// 1:1 2: 2
        for (int i=0;i<n;i++){// 0:0 1:1 2:2
            sum = (a+b)%(1000000007);
            a=b;
            b = sum;
        }
        return sum;
    }
}
