package DP;

import java.util.Arrays;

/**
 * 最长回文字符串！
 */
public class Main4 {
    public static void main(String[] args) {
        String s = "ab1234321abc";
        int ll = longestString2(s);
        System.out.println(ll);
        System.out.println("--------");
        int len = s.length();
        dp = new int[len][len];
        // -1 不行，
        // 1 可以， 0 未处理
        for (int i=0;i<len;i++){
            dp[i][i] = 1; // 单个节点
            if (i+1<len && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1; // 两个节点
            }else if (i+1<len){
                dp[i][i+1]=-1;
            }
        }
        for (int i=0;i<len;i++){
            for (int j=i+2;j<len;j++){
                longestString(s,i,j);
                // if (s.charAt(i)==s.charAt(j))
                //     dp[i][j] = dp[i+1][j-1];
                // else dp[i][j] =-1;
            }
        }
        for (int[] d: dp) {
            System.out.println(Arrays.toString(d));
        }
    }

    // max
    public static int longestString2(String  s){

        int n = s.length();
        boolean[][] dp =new boolean[n][n];
        int max=1;
        for (int i =0;i<n;i++){
            dp[i][i] = true;
        }
        //
        for (int i=0;i<n-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                max =2;
            }
        }
        for (int i=n-2;i>=0;i--){
            for (int j=i+2;j<n;j++){ //
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j]){
                        max = Math.max(j-i+1, max);
                    }
                }
            }
        }
        return max;
    }

    // "ab1234321abc" : 2-8 dp[i][j]为1表示i-j是回文。
    static int[][] dp;
    public static int longestString(String  s, int i, int j){
        // 退出条件
        if (dp[i][j] != 0){
            return dp[i][j];
        }
        if (s.charAt(i)==s.charAt(j)){
            dp[i][j] = longestString(s, i+1,j-1);
            return dp[i][j];
        }else {
            dp[i][j] =-1;
            return -1;
        }
    }
}
