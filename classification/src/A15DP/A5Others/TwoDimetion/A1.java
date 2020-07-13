package A15DP.A5Others.TwoDimetion;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 2:37
 *
 *
 *
 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

 * 相等子集划分
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 *
 *
 * 解法： 转化成换零钱
 *
 */
public class A1 {
    public static void main(String[] args) {
        int[] ints = {1, 5, 11, 6};
        boolean equal = canPartition(ints);
        System.out.println(equal);
    }

    /**
     * dp[i][j] 表示前i个元素中是否存在和等于j的，存在为true， 否则false
     * dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]]
     */
    public static boolean canPartition(int[] arr) {
        if (arr==null || arr.length==1) return false;
        int sum=0;
        for (int ele: arr) sum+=ele;
        if ((sum &1) ==1) return false; // 是奇数
        sum >>=1; // /2
        boolean[] dp = new boolean[sum+1];
        dp[0] =true; // 不选就为true
        if (arr[0]<=sum) dp[arr[0]] =true;
        for (int i=1;i<arr.length;i++){
            for (int j=sum;j>=arr[i];j--){
                dp[j] = dp[j] || dp[j-arr[i]];
            }
        }
        return dp[sum];
    }

}
