package A15DP.A5Others.TwoDimetion;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 13:46
 *
 * 给定一个包含N个非负数的set， 并且给定K, 从集合中找出一组元素子集，使得这组子集的各个元素相加起来和是K。
 *
 * 解法： 选择 正好等于k的问题 转换 换零钱
 * 初始化 除了0是true  其他的false
 * 从前向后
 */
public class A2 {

    public static void main(String[] args) {

    }

    /**
     * 子集和正好等于k
     */
    public boolean sumK2(int[] arr, int k){
        if (arr==null || k<0) return false;
        // dp[i][k]
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        if (arr[0]<=k) dp[arr[0]] = true;
        for (int i=1;i<arr.length;i++){
            for (int j=k;j>=arr[i];j--){
                dp[j] = dp[j] || dp[j-arr[i]];
            }
        }
        return dp[k];
    }
}
