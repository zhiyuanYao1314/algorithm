package DP;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/22 16:16
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */

public class Main6 {

    public static void main(String[] args) {
        int i = cutRope(2);
        System.out.println(i);
    }
    public static int cutRope(int target) {
        int[] dp = new int[target+1];
        dp[1] =1;
        dp[2] =1;
        for (int i=3;i<=target;i++){
            int max=0;
            for (int j=1;j<i;j++){
                max = Math.max(max, Math.max(dp[i-j]*dp[j],Math.max(j*dp[i-j], j*(i-j))));
            }
            dp[i] =max;
        }
        return dp[target];
    }

}
