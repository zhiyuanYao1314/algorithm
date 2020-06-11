package backTracking;

import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/5 17:08
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 */
public class Main11 {
    public static void main(String[] args) {

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        this.rows = triangle.size();
        backTrack(triangle,0,0,0);
        return min;
    }

    int rows;
    int min= Integer.MAX_VALUE;
    void backTrack(List<List<Integer>> triangle, int row, int col,  int sum){
        if (row==rows){
            //
            if (sum < min) min = sum;
            return ;
        }
        List<Integer> rowNums = triangle.get(row); //当前行
        sum +=rowNums.get(col);
        backTrack(triangle, row+1, col,sum);
        sum -=rowNums.get(col);
        if (col+1>=rowNums.size()) return; // 出边界，剪枝
        sum +=rowNums.get(col+1);
        backTrack(triangle,row+1, col+1,sum);
        sum -=rowNums.get(col+1);
    }
}
