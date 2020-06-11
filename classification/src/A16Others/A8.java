package A16Others;

import java.beans.PropertyEditorSupport;
import java.util.PriorityQueue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 17:31
 * LC123 买卖股票的最佳时机 III
 */
public class A8 {

    // 最多两个只能买两个上升期
    //
    public int maxProfit(int[] prices) {
        // int times =0; // 购买上升期的次数；
        // PriorityQueue<Integer> heap = new PriorityQueue();

        // 记录最大的两次交易
        int[] max = new int[2];
        int n = prices.length;
        int i=0;
        while (i<n){
            int cur = i;
            if (cur+1<n && prices[cur]<prices[cur+1]){
                while (cur+1<n && prices[cur]<prices[cur+1]){
                    cur++; // cur>cur+1
                }
                int sum = prices[cur]- prices[i];
                // 对比交换max
                swap(max, sum);
                i = cur+1;
            }else {
                i++;
            }
        }
        return max[0]+max[1];
    }
    private void swap(int[] max, int sum) {
        if (max[0]>max[1]){
            if (sum>max[1])
                max[1] = sum;
        }else {
            if (sum>max[0])
                max[0] = sum;
        }
    }
}
