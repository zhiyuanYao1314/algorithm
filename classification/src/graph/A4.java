package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 14:15
 *
 * 695 岛屿的最大面积
 */
public class A4 {
    public static void main(String[] args) {
        A4 a4 = new A4();
        int[][] ints = new int[][]{
                {1,1,1,0},
                {0,0,0,1}
        };
        int i = a4.maxAreaOfIsland(ints);
        System.out.println(i);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        // 1. 遍历修改所有的边界点
        int rs = grid.length;
        int cs = grid[0].length;
        int max =0;
        for (int i=0;i<rs;i++){
            for (int j=0;j<cs;j++){
                if (grid[i][j]==1) {
                    int cur = dfs(grid, rs ,cs,i,j);
                    if (cur>max)
                        max = cur;
                }
            }
        }
        return max;
    }

    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    /**
     * 以每个为1的点开始将所有为1的点变成2， 表示已经遍历过的岛屿
     */
    int dfs(int[][] board,int rs , int cs, int i, int j){
        // 退出条件
        if (i<0 || i>=rs || j<0 || j>=cs)
            return 0;
        if (board[i][j]==0 || board[i][j]==2){
            return 0;
        }
        //O
        int count =1;
        board[i][j]=2;
        for (int[] dir: dirs){
            count += dfs(board, rs, cs, i+dir[0], j+dir[1]);
        }
        return count;
    }

}
