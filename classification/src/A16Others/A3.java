package A16Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 22:55
 * 406. 根据身高重建队列, 笔试题
 */
public class A3 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o2[0] - o1[0]; //身高由高到低
                if (diff==0) return o1[1] - o2[1];
                return diff;
            }
        });
        ArrayList<int[]> q = new ArrayList();
        for (int[] p:people){
            q.add(p[1], p);
        }
        int[][] ans = q.toArray(new int[people.length][2]);
        return ans;
    }
}
