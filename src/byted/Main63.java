package byted;

/**
 * 1143 最长公共子序列
 */
public class Main63 {
    public static void main(String[] args) {
        int n = longestCommonSubsequence("abc", "aabkdce");
        System.out.println(n);
    }
    /**
     * dp[i][j]
     *  if(i==j) == dp[i-1][j-1]
     *  else max dp[i-1][j], dp[i][j-1]
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1==null || text2==null || text1.length()==0 || text2.length()==0)
            return 0;
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1;i<=n1;i++){
            for (int j=1;j<=n2;j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
