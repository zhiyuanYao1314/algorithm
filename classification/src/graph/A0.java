package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 14:57
 * Describe:
 * version:1.0
 */
public class A0 {

    /**
     *
     * 图的基础算法题：
     *  1. 图的DFS BFS
     *  2. topolog排序；
     *  3. 最小生成树!
     *  4. 最短距离
     *  5.
     */


    /**
     * 常考题：格子问题的图的DFS以及BFS
     *1. 朋友圈数量
     *2. LC130. 被围绕的区域 可以用DFS 也可以用unionFind:
     *3. LC200. 岛屿数量
     *4. 岛屿的最大面积
     *5. 463. 岛屿的周长
     *
     * 6. 733. 图像渲染
     */

    /**
     * DFS框架
     *
     *
     */

    /**
     *
     * @param board 棋盘
     * @param rs 行数
     * @param cs 列数
     * @param i 当前的x坐标
     * @param j 当前的y坐标
     * @return  根据题目， 如 连接点的数量， 面积，边长， 以周长为例；
     */
    int dfs(int[][] board,int rs, int cs,  int i, int j){
        if (i<0 || i>=rs || j<0 || j>=cs || board[i][j]==0 /* 水*/){
            return 1; // 记录一个边长1
        }
        if (board[i][j]==2) // 访问过的点
            return 0;
        board[i][j] =2;
        return
            dfs(board, rs, cs, i+1,j)+
            dfs(board, rs, cs, i+1,j)+
            dfs(board, rs, cs, i+1,j)+
            dfs(board, rs, cs, i+1,j);
    }
}