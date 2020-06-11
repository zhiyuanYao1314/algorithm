package A15DP.A22Multinapack;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 15:30
 */
public class A0 {

    /**
     * 每个元素只能选特定的数量。
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i=0;i<n;i++){
            arr[i][0] = sc.nextInt(); // w
            arr[i][1] = sc.nextInt(); // v
            arr[i][2] = sc.nextInt(); // m
        }
        int ans = multiPack(arr, W);
        System.out.println(ans);
    }

    public static int multiPack(int[][] arr, int W){
        int[] dp = new int[W+1];

        for (int i=0;i<arr.length;i++){
            for (int j=W ;j>=arr[i][0]; j--){
                for (int k =0;k<=arr[i][2] && k*arr[i][0]<=j;k++){
                    dp[j] = Math.max(dp[j], dp[j-k*arr[i][0]]+k*arr[i][1]);
                }
            }
        }
        return dp[W];
    }
}
