package A15DP;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 15:44
 * 正则表达式匹配
 * . 表示任意一个字符
 * * 匹配零个或多个前面的那一个元素
 * 注意和统配符的区别： 通配符'*' 可以匹配任意字符串（包括空字符串）。不特指前面的字符
 */
public class A5 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp =new boolean[s.length()+1][p.length()+1];

        // 初始化
        dp[0][0] = true;
        for (int i=2;i<p.length()+1;i++){
            if (p.charAt(i)=='*')
                dp[0][i] =dp[0][i-2];
        }
        // dp
        for (int i=1;i<s.length()+1;i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.')
                    dp[i][j] = dp[i-1][j-1];
                if (p.charAt(j-1)=='*'){
                    if (p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.')
                        dp[i][j] = dp[i-1][j];
                    dp[i][j] =dp[i][j] || dp[i][j-2] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}