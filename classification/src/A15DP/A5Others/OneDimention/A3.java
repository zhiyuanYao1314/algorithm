package A15DP.A5Others.OneDimention;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/5 16:24
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 */
public class A3 {
    public static void main(String[] args) {
        A3 a1 = new A3();
        int[]days = new int[]{1,4,6,7,8,20};
        int[]costs = new int[]{2,7,15};
        a1.mincostTickets(days, costs);
    }

    // dp[n] = (dp[k]+costs[0],dp[]+costs[1],dp[]+costs[2])
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp =new int[days.length+1];
        for (int i=0;i<days.length;i++){
            int[] tmp= daysInN(days, i);
            dp[i+1] = Math.min(Math.min(dp[tmp[0]+1]+costs[0],dp[tmp[1]+1]+costs[1]),dp[tmp[2]+1]+costs[2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[days.length];
    }

    // 返回当前元素的前面不在1 7 30 天之内元素的下标；
    // 全部在的话，返回-1；
    int[] daysInN(int[] days, int k){
        int[] before1_7_30 = new int[3];
        before1_7_30[0]=k-1;
        int cur = days[k];
        int j = k-1;
        while (j>=0 && cur-days[j]<=6 ){
            j--;
        }
        before1_7_30[1]=j;
        while (j>=0 && cur-days[j]<=29 ){
            j--;
        }
        before1_7_30[2]=j;
        return before1_7_30;
    }

}
