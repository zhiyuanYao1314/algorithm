package A15DP;
import java.util.List;
/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/5 17:49
 * 三角形最小路径和
 */
public class A2 {

    /**
     * 迭代：自底向上 每个元素取下面元素的最小值；
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0 ) return 0;
        int rows = triangle.size();
        int maxColoms = triangle.get(rows-1).size();
        int[] tmp = new int[maxColoms+1];
        int[] ans = new int[maxColoms+1];
        for (int i=rows-1;i>=0;i--){ //每一行
            List<Integer> row = triangle.get(i);
            for (int j=0;j<row.size();j++){
                ans[j] = Math.min(tmp[j],tmp[j+1])+row.get(j);
                tmp = ans;
            }
        }
        return tmp[0];
    }

    /**
     * 递归：自底向上；最后返回一个数组
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] ans = dp(triangle, triangle.size() - 1, new int[triangle.size() + 1]); //
        return ans[0]; //
    }
    public int[]  dp(List<List<Integer>> triangle, int row, int[] sum){
        if (row==-1){
            return sum;
        }
        int[] ans = new int[triangle.get(row).size()]; // 当前层的和
        for (int i=0;i<ans.length;i++){
            ans[i] = triangle.get(row).get(i)+Math.min(sum[i],sum[i+1]);
        }
        return ans;
    }
}