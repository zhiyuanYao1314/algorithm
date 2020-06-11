/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 11:03
 * Describe:
 * version:1.0
 */
public class Fourteen {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    /**
     * 把一个绳子分成n端，然后乘积，求最大值
     * 动态规划：dp(n) 取前面的n中方案的最大值，
     * 总结：
     * 动态规划中的递推式也可以是包含循环求解。
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2;i<n+1;i++){
            for (int j=1;j<i;j++){
                // 注意：j*(i-j) 前半段不一定还需要再分。
                dp[i] = Math.max(dp[i], Math.max(dp[j]*(i-j),j*(i-j)));
            }
        }
        return dp[n];
    }
}