package A4MergeIntervals;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import javax.swing.text.html.HTMLWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/3 12:46
 * 插入区间
 */
public class A3 {

    /**
     *
     * 可以从两边往中间寻找合并区间，这样就节省了对合并区间中的每一个数组都进行合并的操作，例如示例中的合并区间为[3,10]，从两边开始遍历找到3和10之后,中间的[6,7]也就不需要判断了。
     *
     * 假设合并区间是[left,right]。
     * 从头开始寻找left值，newInterval[0]<=intervals[n][1]时，可知left = Math.min(intervals[n][0], newInterval[0]);
     *
     * 没找到left值说明目标数组大于所有区间，应该放在最右边，提前结束。
     *
     * 从尾开始寻找right值，newInterval[1]>=intervals[n][0]时，可知right = Math.max(intervals[n][1], newInterval[1]);
     *
     * 没找到right值但是有left值,说明目标数组应该在索引start之后且不需要合并，提前结束。
     *
     * 找到合并区间[left,right]后，可知目标输出为：left之前的数组+[left,right]+right之后的数组。
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval==null || newInterval.length==0) return intervals;
        // 查找合并区间的Left
        int i=0;
        int len = intervals.length;
        while (i< len&& intervals[i][1]<newInterval[0]){
            i++;
        }
        if (i==len) { // left> intervals的最大值；
            int[][] ans = Arrays.copyOf(intervals, len + 1);
            ans[len]= newInterval;
            return ans;
        }
        int left = Math.min(newInterval[0], intervals[i][0]);
        // 查找合并区间的right
        i= len-1;
        while (i>=0 && intervals[i][0]>newInterval[1]){
            i--;
        }
        if (i==-1){// right< intervals的最左边
            int[][] ans = new int[len + 1][2];
            ans[0] = newInterval;
            for (int j=1;j<len+1;j++){
                ans[j] = intervals[j-1];
            }
            return ans;
        }
        int right = Math.max(newInterval[1], intervals[i][1]);
        // 合并答案： left之前+[left, right]+right之后
        List<int[]> ans = new ArrayList<>();
        int j=0;
        while (intervals[j][1]<left){ // 加入所有<left
            ans.add(intervals[j++]);
        }
        ans.add(new int[]{left, right}); // 加入[left, right]
        while (j<len && intervals[j][0]<=right){ // 找到>right
            j++;
        }
        while (j<len){ // 加入所有>right
            ans.add(intervals[j++]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
