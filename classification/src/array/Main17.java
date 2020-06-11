package array;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 16:17
 * Leetcode 17.09 第k个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 */
public class Main17 {
    public static void main(String[] args) {
        Main17 main17 = new Main17();
        int ans= main17.getKthMagicNumber(5);
        System.out.println(ans);
    }

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[1] = 1;
        int p3=1,p5=1,p7=1;
        for (int i=2;i<=k;i++){
            int max = Math.min(Math.min(dp[p3]*3,dp[p5]*5),dp[p7]*7);
            dp[i] = max;
            if (dp[p3]*3==max) ++p3;
            if (dp[p5]*5==max) ++p5;
            if (dp[p7]*7==max) ++p7;
        }
        return dp[k];
    }
}