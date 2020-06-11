
package DP;

import java.util.Arrays;

/**
 * 求二维矩阵的左上角到右下角的最短距离
 *DP
 */
public class Main1 {
    public static void main(String[] args) {
        int[][] dis = {
                {1,2,3},
                {2,4,6},
                {2,3,2}
        };
        int s = shortest(dis);
        System.out.println(s);
    }

    public static int shortest(int[][] distance){
        int rows = distance.length;
        int lines = distance[0].length;
        int[][] ans = new int[rows][lines];
        int sum =0;
        for (int i=0;i<rows;i++){
            sum += distance[i][0];
            ans[i][0] =sum;
        }
        sum =0;
        for (int i=0;i<lines;i++){
            sum += distance[0][i];
            ans[0][i] =sum;
        }
        for (int i=1;i<rows;i++){
            for (int j=1;j<lines;j++){
                ans[i][j] = distance[i][j]+Math.min(ans[i-1][j],ans[i][j-1]);
            }
        }
        for (int[] an:ans){
            System.out.println(Arrays.toString(an));
        }
        return ans[rows-1][lines-1];
    }
}
