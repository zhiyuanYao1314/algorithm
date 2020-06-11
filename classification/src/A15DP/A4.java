package A15DP;

import java.awt.geom.AffineTransform;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 14:53
 * LC44: 通配符匹配
 *  ? 可以匹配任何单个字符
 *  * 可以匹配任意字符串(包括空字符串)
 */
public class A4 {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // ?
        // dp[i][j]
        // s.i==p.j || j=?   i-1 j-1
        // j=*  i-1 j-1, i-1 j, i, j-1
        // 00 true, 01 dp[0][j] = dp[0][j-1];  1*
        // 初始化
        dp[0][0] =true;
        for (int i=1;i<p.length()+1;i++){
            if (p.charAt(i-1)=='*')
                dp[0][i] = dp[0][i-1];
        }
        // dp
        for (int i=1;i<s.length()+1;i++){
            for (int j=1;j<p.length()+1;j++){
                if (p.charAt(j-1)== s.charAt(i-1) || p.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j]|| dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
