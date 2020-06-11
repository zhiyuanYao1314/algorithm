package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 13:16
 * 130. 被围绕的区域
 */
public class A2 {
    /**
     * 方法1： 深度优先遍历
     * 方法2：并查集；
     */

    /**
     * 方法 1：
     */
    public void solve(char[][] board) {

        if (board==null || board.length<=1)
            return;
        // 1. 遍历修改所有的边界点
        int rs = board.length;
        int cs = board[0].length;
        // 第一行和最后一行
        for (int i=0;i<cs;i++){
            if (board[0][i]=='O')
                dfs(board, rs, cs, 0,i);
            if (board[rs-1][i]=='O')
                dfs(board, rs, cs, rs-1,i);
        }
        // 第一列和最后一列
        for (int i=0;i<rs;i++){
            if (board[i][0]=='O')
                dfs(board, rs, cs, i,0);
            if (board[i][cs-1]=='O')
                dfs(board, rs, cs, i,cs-1);
        }

        for (int i=0;i<rs;i++){
            for (int j=0;j<cs;j++){
                if (board[i][j]=='#'){
                    board[i][j] = 'O';
                }else if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 深度遍历 将
    void dfs(char[][] board,int rs , int cs, int i, int j){
        // 退出条件
        if (i<0 || i>=rs || j<0 || j>=cs)
            return;
        if (board[i][j]=='#' || board[i][j]=='X'){
            return;
        }else{ //O
            board[i][j]='#';
        }
        for (int[] dir: dirs){
            dfs(board, rs, cs, i+dir[0], j+dir[1]);
        }
    }
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

}
