package string;

import sun.nio.cs.ext.PCK;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Main3 {

    /**
     * 开始想不出来是因为情况 种类太多，
     * 使用DP问题细化， 然后
     * 考虑问题减少时候的几种情况。
     * 考虑全面
     */
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        String str = "abcabc";
        String pattern = "ab.a*k*bc*";
        boolean match = main3.match(str.toCharArray(), pattern.toCharArray());
        System.out.println(match);
    }

    /**
     * DP, dp[i][j] 表示前i个str与前j个pattern是否匹配，
     * str[i-1]== pattern[j-1] : dp[i][j] = dp[i-1][j-1];
     * else if pattern[j-1]== "*" and pattern[j-2]!= char[i-1]  dp[i][j] = dp[i][j-2]；
     * else if pattern[j-1]== "*" and pattern[j-2]== char[i-1]
     *  dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i][j-2]
     */
    public boolean match(char[] str, char[] pattern){
        int rows = str.length;
        int lines = pattern.length;
        boolean[][] ans = new boolean[rows+1][lines+1];
        ans[0][0] = true;
        //
        for (int i=1;i<=lines;i++){
            if (pattern[i-1]=='*') ans[0][i] = ans[0][i-2];
        }
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=lines;j++){
                if (str[i-1]==pattern[j-1] || pattern[j-1]=='.'){
                    ans[i][j] = ans[i-1][j-1];
                }else if (pattern[j-1]=='*'){
                    if (pattern[j-2]==str[i-1] || pattern[j-2]=='.'){
                        ans[i][j] |= ans[i][j-1]; // a*匹配一个a
                        ans[i][j] |= ans[i][j-2]; // a*不匹配
                        ans[i][j] |= ans[i-1][j]; // a*匹配多个。。
                    }else ans[i][j]= ans[i][j-2];
                }
            }
        }
        return ans[rows][lines];
    }
}
