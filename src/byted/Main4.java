package byted;


/**
 * 买卖股票的最佳利润
 * [7,1,5,3,6,4]
 * 5
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println( maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        // init
        int min =prices[0];
        int ret =0;
        for (int i =1;i<prices.length;i++){
            if (prices[i]<min){
                min = prices[i];
            }else {
                ret = Math.max(prices[i]-min, ret);
            }
        }
        return ret;
    }

}
