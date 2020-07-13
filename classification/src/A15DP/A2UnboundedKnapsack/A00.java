package A15DP.A2UnboundedKnapsack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/5 15:04
 */
public class A00 {

    /**
     * 无限背包和换硬币
     *
     * 1. 无限背包
     * 2. 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
     *      dp[n] = for (int j) max (j*(n-j)dp[j][n-j]) time : nn
     *      数学公式: times3 = n%3==1?n/3-1:n/3; f(n)= pow（3,times）* pow(2,(n-3*times)/2);
     * 3. 换硬币的方法:
     *      简单： 1，5，25 面值确定，贪婪
     *      面值是给定的数组，递归 dp[n]表示面值为n当前i个元素的替换种类； 从前往后，
     *          dp[n] = dp[n-arr[i-1]]+dp[n];
     *
     * 4. 零钱兑换
     */

}
