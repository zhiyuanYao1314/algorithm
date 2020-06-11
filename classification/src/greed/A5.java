package greed;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/30 14:25
 * 1353. 最多可以参加的会议数目
 */
public class A5 {
    // n^2 未通过 待优化
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1,o2)->{
            int t1= o1[1]-o2[1] ; // 结束时间从早到晚
            if (t1==0){
                return (o1[1]-o1[0])-(o2[1]-o2[0]) ;
            }
            return t1;
        });
        int count=0;
        Set<Integer> sets = new HashSet();
        for (int i =0;i<events.length;i++){ // 所有事件
            for (int j=events[i][0];j<=events[i][1];j++){ // 起始--终止点
                if (!sets.contains(j)){
                    //System.out.println(j);
                    count++;
                    sets.add(j);
                    break;
                }
            }
        }
        return count;
    }
}
