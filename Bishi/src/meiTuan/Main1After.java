package meiTuan;

import java.util.Arrays;
import java.util.Scanner;

public class Main1After {
    static int[] arr;
    static int len;
    static int k;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        k = sc.nextInt();
        arr = new int[len];
        dp = new int[len][len];
        for(int i=0;i<len;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if (i != j) dp[i][j] = -1;
            }
        }
        System.out.println(minRemove(0,len-1));
        for (int[] k: dp)
        System.out.println(Arrays.toString(k));
    }
    public static int minRemove(int i, int j){
        if (arr[j]-arr[i]<=k) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Math.min(minRemove(i+1,j),minRemove(i,j-1))+1;
        return dp[i][j];
    }
}
