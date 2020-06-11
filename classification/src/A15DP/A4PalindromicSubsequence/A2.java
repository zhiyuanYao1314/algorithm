package A15DP.A4PalindromicSubsequence;

import java.util.logging.Level;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 22:59
 * 最长回文子序列 子序列不要求连续，但再序列中的前后位置保持一致。
 *
 * 导致递推式不一样
 * dp[i][j]=
 *  if s.i==s.j =dp[i+1][j-1] +2
 *  else max ( dp[i+1][j], dp[i][j-1])
 *
 */
public class A2 {

    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length()==0) return 0;
        int n = s.length(), max=1;
        int[][] dp = new int[n][n];
        for (int i=n-1;i>=0;i--){
            dp[i][i] =1;
            for (int j=i+1;j<n;j++){
                if (s.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i+1][j-1]+2; //开始相等， 0+2没有问题。
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                if (dp[i][j]>max) max = dp[i][j];
            }
        }
        return max;
    }

}
