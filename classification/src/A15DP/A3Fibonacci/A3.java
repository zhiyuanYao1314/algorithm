package A15DP.A3Fibonacci;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 12:09
 * 1137. 第 N 个泰波那契数
 */
public class A3 {

    public int tribonacci(int n) {
        // 0 1 1
        if (n<=1) return n;
        if (n==2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i=3;i<n+1;i++){ //
            dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

}
