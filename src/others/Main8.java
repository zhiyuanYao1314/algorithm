package others;

/**
 * Time:2020/7/25 19:17
 *最长递增子序列:
 * 【题目】
 * 给定数组arr，返回arr的最长递增子序列。
 * 【举例】
 * arr=[2,1,5,3,6,4,8,9,7]，返回的最长递增子序列为
 * [1,3,4,8,9]。
 * 【要求】
 * 如果arr长度为N，请实现时间复杂度为O(NlogN)的方法。
 * 解法：
 * 一位数组的dp问题，
 * 但是求解dp[i]依赖于前面所有的0--i-1的元素！
 */
public class Main8 {
    public static void main(String[] args) {

    }
    class Info{
        int maxVal;
        int maxLength;
        Info(int maxLength, int maxVal){
            this.maxLength = maxLength;
            this.maxVal = maxVal;
        }
    }

    int[] longestPath(int[] arr){
        Info[] dp = new Info[arr.length+1];
        dp[0] = new Info(-100,0);

        return null;
    }

    /**
     * 最长连续递增子序列
     * i，j双指针
     */

    /**
     * 最长公共子序列
     * 二维数组：
     * dp[i][j] =
     *  if 相等 dp[i-1][j-1];
     *  else max (dp[i-1][j] , dp[i][j-1])
     */

    /**
     * 最长公共子串
     * 二维数组：
     *
     *  方法1： 两层循环在嵌套一层对比：
     *  m*n*。。
     *
     *  方法2：
     * 记录移动长度，
     * 然后，从后向前移动；
     */

    /**
     * 最小编辑代价：
     * dp[i][j] = dp[i-1][j-1]+k1替换，dp[i][j-1]+k2增加, dp[i-1][j]+k3删除
     *
     */


    /**
     * 132 分割回文串
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回符合要求的最少分割次数。
     * 示例:
     * 输入: "aab"
     * 输出: 1
     * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
     * todo!
     */
    public int minCut(String s) {

        return 0;
    }








}
