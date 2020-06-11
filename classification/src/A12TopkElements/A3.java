package A12TopkElements;
import java.util.Arrays;
/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 13:50
 * leetcode  最接近原点的k个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class A3 {

    /**
     *
     */
    public int[][] kClosest(int[][] points, int k){
        int len = points.length;
        int[] dis = new int[len];
        for (int i=0;i<len;i++){
            dis[i] = points[i][0]*points[i][0]+points[i][1]*points[i][1];
        }
        Arrays.sort(dis);
        int[][] ans = new int[k][2];
        int index =0;
        int max = dis[k-1];
        for (int i=0;i<len;i++){
            if (points[i][0]*points[i][0]+points[i][1]*points[i][1]<=max)
                ans[index++] = points[i];
        }
        return ans;
    }
}
