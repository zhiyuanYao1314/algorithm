package A15DP.A4PalindromicSubsequence;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 23:47
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class A3 {
    public int countSubstrings(String s) {
        if (s==null || s.length()==0) return 0;
        int count=0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=n-1;i>=0;i++){
            dp[i][i] =true; // 一个元素都是回文
            count++;
            for (int j=i+1;j<n;j--){
                if (j==i+1 && s.charAt(i)==s.charAt(j))
                    dp[i][j] = true; // 两个元素相同，对称
                else
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}
