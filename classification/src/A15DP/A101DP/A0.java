package A15DP.A101DP;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 10:49
 * 0/1 背包问题
 *
 * 状态定义 状态转移方程
 * 初始化 输出
 * 思考状态压缩
 */
public class A0 {
    /**
     * 1. 相等子集划分--> 选出一部分元素，和等于总和的一半--> 重量恰好等于背包；
     *      dp[i][j] 从前i个元素中选择和为j的元素是否可能；false表示不可能
     *      dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]] 选与不选两种可能
     * 2. 给定一个包含N个非负数的set， 并且给定K, 从集合中找出一组元素子集， 使得这组子集的各个元素相加起来和是K。
     *      重量恰好等于背包的背包问题；
     * 3. 只有+ - 两个操作符，把数组中的所有元素串起来，使得结果为0
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int i = pack01(arr, W);
        System.out.println(i);
    }
    // arr[]
    public static int pack01(int[][] arr,int W){
        int len = arr.length; //w v
        int[] dp = new int[W+1];
        for (int i=0;i<len;i++){
            for (int j=W;j>=arr[i][0];j--){
                dp[j] = Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
            }
        }
        return dp[W];
    }
}
