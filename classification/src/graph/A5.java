package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 14:41
 *
 * 463. 岛屿的周长
 */
public class A5 {
    public int islandPerimeter(int[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        // 1. 遍历修改所有的边界点
        int rs = grid.length;
        int cs = grid[0].length;
        for (int i=0;i<rs;i++){
            for (int j=0;j<cs;j++){
                if (grid[i][j]==1) {
                    return  dfs(grid, rs ,cs,i,j);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] board,int rs , int cs, int i, int j) {
        int count=0;
        if (i<0 || i>=rs || j<0 || j>=cs|| board[i][j]==0){
            return 1;
        }
        if (board[i][j]==2){
            return 0;
        }
        board[i][j] =2;
        return count
        +dfs(board, rs, cs, i+1,j)
        +dfs(board, rs, cs, i-1,j)
        +dfs(board, rs, cs, i,j+1)
        +dfs(board, rs, cs, i,j-1);
    }

}
