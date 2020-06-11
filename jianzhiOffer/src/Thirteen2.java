import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 10:38
 * Describe:
 * version:1.0
 */
public class Thirteen2 {


    private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
    }

    boolean[][] matrix;
    public int movingCount(int threshold, int rows, int cols) {
        matrix = new boolean[rows][cols];

        backTrace(0,0);
        return 0;
    }

    private void backTrace(int i, int j) {
        // 退出条件
        // if ()return;

        matrix[i][j]= true;
        for (int[] d: directions){
            backTrace(i+d[0],j+d[1]);
        }


    }


    public void dfs(){

    }
}
