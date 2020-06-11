package A15DP.A2UnboundedKnapsack;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 12:52
 * 无线背包
 */
public class A1 {

    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int ans = unboundedPack(arr, W);
        System.out.println(ans);
    }

    /**
     * arr[0]表示重量
     * arr[1]表示v价值
     */
    public static int unboundedPack(int[][] arr, int W){
        int[] dp= new int[W+1];
        for(int i=0;i<arr.length;i++){
            // 从前往后，可重复选择；
            for(int j=arr[i][0];j<=W;j++){
                dp[j] = Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
            }
        }
        return dp[W];
    }
}
