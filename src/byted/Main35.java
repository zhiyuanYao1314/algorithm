package byted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56 合并区间
 *  先排序 在合并 快速
 */
public class Main35 {

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int[] inter: intervals){
            if (ans.size()==0){
                ans.add(inter);
                continue;
            }
            int[] pre = ans.get(ans.size()-1);
            if (inter[0]<=pre[1]){
                pre[1] = Math.max(pre[1], inter[1]);
            }else {
                ans.add(inter);
            }
        }
        int[][] ret = new int[ans.size()][];
        int i=0;
        for (int[] cur:ans){
            ret[i++] = cur;
        }

        return ret;
    }


}


