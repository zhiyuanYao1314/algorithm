package A15DP.A4PalindromicSubsequence;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/30 17:10
 * 最长回文子串  子串必须连续
 *
 * dp[i][j]
 *  if s.i ==s.j = [i+1][j-1]
 *
 */
public class A1 {

    public static void main(String[] args) {
        A1 a1 = new A1();
        String babad = a1.longestPalindrome("babad");
        System.out.println(babad);
    }
    public String longestPalindrome2(String s) {
        if (s==null || s.length()==0) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max=0;
        int left=0;
        int right =0;
        for (int i=n-1;i>=0;i++){
            dp[i][i] =true; // 一个元素都是回文
            for (int j=i+1;j<n;j++){
                if (j==i+1 && s.charAt(i)==s.charAt(j))
                    dp[i][j] = true; // 两个元素相同，对称
                else
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                if (dp[i][j] && j-i+1>max){
                    max = j-i+1;
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        int max=1;
        int left=0;
        int right=0;
        for (int i = 0; i < len - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                max =2;
                left=i;
                right=i+1;
            }

        for (int i=len-2;i>=0;i--){
            for (int j=i+2;j<len;j++){
                dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                if (dp[i][j] && j-i+1>max){
                    max = j-i+1;
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left, right+1);


    }
}
