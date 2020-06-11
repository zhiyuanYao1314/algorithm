package A4MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 12:18
 * leetcode 986
 * 两个数组的 区间列表的交集
 */
public class A2 {
    public static void main(String[] args) {

    }

    /**
     * 每次取最左边的两个区间的交集，放入答案；
     * 在删除较小的一个，因为较小的一个只能与另一个存在一个交集
     */
    public int[][] intervalIntersection(int[][] A, int[][] B){
        if (A.length==0 || B.length==0) return new int[0][0];
        List<int[]> ans = new ArrayList<>();
        int i=0,j=0;
        while (i<A.length && j<B.length){
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            if (left<=right){
                ans.add(new int[]{left, right});
            }
            if (A[i][1]<B[j][1])
                i++;
            else j++;
        }
        return  ans.toArray(new int[ans.size()][]);
    }

}
