package graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 13:45
 * 200. 岛屿数量
 */
public class A3 {
    public static void main(String[] args) {
        A3 a3 = new A3();
        char[][] ints = new char[][]{
                {'1','1','1','0'},
                {'0','0','0','1'}
        };
        int i = a3.numIslands(ints);
        // int j = a3.numIslands2(ints);
        System.out.println(i);
        // System.out.println(j);

    }

    /**
     * DFS
     */
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        // 1. 遍历修改所有的边界点
        int rs = grid.length;
        int cs = grid[0].length;
        int count=0;
        for (int i=0;i<rs;i++){
            for (int j=0;j<cs;j++){
                if (grid[i][j]=='1') {
                    dfs(grid, rs ,cs,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    /**
     * 以每个为1的点开始将所有为1的点变成2， 表示已经遍历过的岛屿
     */
    void dfs(char[][] board,int rs , int cs, int i, int j){
        // 退出条件
        if (i<0 || i>=rs || j<0 || j>=cs)
            return;
        if (board[i][j]=='0' || board[i][j]=='2'){
            return;
        }else{ //O
            board[i][j]='2';
        }
        for (int[] dir: dirs){
            dfs(board, rs, cs, i+dir[0], j+dir[1]);
        }
    }


    /**
     * 2. BFS
     */
    public int numIslands2(char[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        // 1. 遍历修改所有的边界点
        int rs = grid.length;
        int cs = grid[0].length;
        int count=0;
        for (int i=0;i<rs;i++){
            for (int j=0;j<cs;j++){
                if (grid[i][j]=='1') {
                    bfs(grid, rs ,cs,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid,int rs ,int cs,int i,int j){
        int[] cur = new int[]{i,j};
        Deque<int[]> q = new ArrayDeque();
        q.addLast(cur);
        while (!q.isEmpty()){
            int[] c = q.removeFirst();
            grid[c[0]][c[1]] = '2';
            for (int[] dir:dirs){
                int nextX = c[0]+dir[0];
                int nextY = c[1]+dir[1];
                if (nextX<0 || nextX>=rs || nextY<0 || nextY>=cs ||
                        grid[nextX][nextY]=='2' || grid[nextX][nextY]=='0')
                    continue;
                q.addLast(new int[]{nextX,nextY});
            }
        }
    }
}