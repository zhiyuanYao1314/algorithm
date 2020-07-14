package byted;

/**
 * 518 零钱兑换II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *
 */
public class Main46 {

    public static void main(String[] args) {
        Main46 mm= new Main46();
        int k = mm.change(10, new int[]{1,2,5,10});
        System.out.println(k);
    }

    /**
     * 初始化：dp[amount+1] 0 = 1; 恰好
     * 递推关系式： dp[i] = dp[i] + dp[i-coins[j]]
     * 因为无限 从前向后
     */
    public int change(int amount, int[] coins) {
        // 1.过滤
        if (amount<0)
            return 0;
        if (coins==null || coins.length==0){
            return 0;
        }
        // 2. 初始化
        int[] dp = new int[amount+1];
        dp[0] =1;
        // 3. dp
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<amount+1;j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
