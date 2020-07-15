package byted;

import java.awt.image.ImageObserver;
import java.util.Arrays;

/**
 * 63 不同路径2
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 */
public class Main52 {
    /**
     * 注意：写题目时，想好每一个参数 变量的含义， 然后在下笔；
     *
     */


    public static void main(String[] args) {
        Main52 m = new Main52();
        int[][] param = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int s = m.uniquePathsWithObstacles(param);
        System.out.println(s);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0
                || obstacleGrid[0]==null || obstacleGrid[0].length==0){
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i=0;i<rows;i++){
            if (obstacleGrid[i][0]!=1){
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i=0;i<cols;i++){
            if (obstacleGrid[0][i]!=1){
                dp[0][i] =1;
            }else {
                break;
            }

        }
        for (int i=1;i<rows;i++){
            for (int j=1;j<cols;j++){
                if (obstacleGrid[i][j]==1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[rows-1][cols-1];
    }



}
