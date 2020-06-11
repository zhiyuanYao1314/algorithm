package DP;


/**
 * 最长公共子序列
 */
public class Main5 {
    public static void main(String[] args) {
        System.out.println(longestCommonString("1235874", "12374"));
    }

    public static int longestCommonString(String A, String B){
        /**
         * dp[i][j]表示A的前i个字母，B的前j个字母中 的最长公共子序列
         *  if A[i] == B[j]: dp[i][j] = dp[i-1][j-1];
         *  else    max([i-1][j],[i][j-1])
         */
        char[] As = A.toCharArray();
        char[] Bs = B.toCharArray();
        int[][] ans = new int[As.length+1][Bs.length+1];
        for (int i=0;i<As.length+1;i++){
            ans[i][0] = 0;
        }
        for (int i=0;i<Bs.length+1;i++){
            ans[0][i] = 0;
        }
        for (int i=1;i<=As.length;i++){
            for (int j=1;j<=Bs.length;j++){
                if (As[i-1]==Bs[j-1]){
                    ans[i][j] = ans[i-1][j-1]+1;
                }else {
                    ans[i][j] = Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        return ans[As.length][Bs.length];
    }
}
