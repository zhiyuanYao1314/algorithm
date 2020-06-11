package A4MergeIntervals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 0:11
 *
 *
 * 一个数组的合并区间
 * Given a collection of intervals, merge all overlapping intervals.
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 *
 * 思考：排序后，遍历数组，如果> 就添加到答案上，否则，
 */
public class A1 {
    public static void main(String[] args) {

    }

    /**
     * 根据区间左边界进行排序，
     * 然后一次遍历，区间累加；
     * time nlogn
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length==0)
            return new int[0][0];
        int[][] ans = new int[intervals.length][2];
        // 按左边界从小到大排序
        Arrays.sort(intervals, (o1, o2)-> (o1[0]-o2[0]));
        int index =-1;
        for (int[] interval: intervals){
            // 当前区间的左边界> 已存在不可合并的右边界
            if (index==-1 || interval[0]>ans[index][1] ){
                ans[++index] = interval;
            }else ans[index][1] = Math.max(interval[1], ans[index][1]);
        }
        return Arrays.copyOf(ans,index+1);
    }
}
