package A15DP.A5Others.OneDimention;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 12:53
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class A2 {
    public static void main(String[] args) {
        A2 a1 = new A2();
        int i = a1.integerBreak1(5);
        System.out.println(i);

    }

    /**
     * 1. dp
     */
    public int integerBreak1(int n) {
        // dp[n] = max(dp[n-i]*i, (n-i)*i), {i 1..n-1}
        // 1..0 2..1 3..2 4..4
        if (n<=3) return n-1;
        int[] dp = new int[n+1];
        for (int i=0;i<4;i++){
            dp[i] = i-1;
        }
        for (int i=4;i<n+1;i++){
            for (int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],  Math.max(dp[i-j]*j, (i-j)*j));
            }
        }
        return dp[n];
    }

    /**
     * 2. 数学规律：
     *  n----> 尽量拆成3的倍数和2的倍数
     */
    public int integerBreak(int n) {
        // 1..0 2..1 3..2
        // 4..4; 5..6; 6..9; 7;12
        if (n<=3) return n-1;
        int times3 = n/3;
        if (n%3==1)times3--;
        int times2 = (n-times3*3)/2;
        return (int) (Math.pow(3,times3)*Math.pow(2,times2));
    }
}
