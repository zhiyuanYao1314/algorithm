package greed;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 17:26
 *
 * lc 122 买卖股票
 */
public class A3 {
    public static void main(String[] args) {
        // Integer.toBinaryString(123);
        System.out.println(Integer.highestOneBit(5));// i>>1

    }

    public int maxProfit(int[] prices) {
        if (prices.length==1) return 0;
        int sum =0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>prices[i-1]){
                sum += prices[i]-prices[i-1];
            }
        }
        return sum;
    }

}
