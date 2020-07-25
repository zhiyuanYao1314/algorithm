package shopee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二维矩阵 最长路径；
 */
public class Main2 {
    static int[][] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(",");
        int rows = new Integer(ss[0]);
        int cols = new Integer(ss[1]);

        nums = new int[rows][cols];
        // 初始化
        for (int i=0;i<rows;i++){
            String line = sc.nextLine();
            String[] ns = line.split(",");
            for (int j=0;j<cols;j++){
                nums[i][j] = new Integer(ns[j]);
            }
        }
        // int rows = 3;
        // int cols = 3;
        // nums = new int[][]{
        //         {10,11,12},
        //         {6,18,8},
        //         {2,19,1}
        // };

        boolean[][] used = new boolean[rows][cols];
        for (boolean[] u: used){
            Arrays.fill(u, false);
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                used[i][j] = true;
                help(i, j, used, rows, cols,1);
                used[i][j] = false;
            }
        }
        System.out.println(max);
    }
    // nums,
    static int max=0;
    static int[][] dirs = new int[][]{ {0,-1},{-1,0},{0,1},{1,0}};
    static void help(int x, int y,boolean[][] used, int rows, int cols, int depth){
        max = Math.max(max, depth);
        int cur = nums[x][y];
        for (int[] dir: dirs){
            int newx = x+dir[0];
            int newy = y +dir[1];
            // System.out.println(newx+":"+newy);
            if (check(cur, used,newx,newy, rows, cols)){
                used[newx][newy] = true;
                help(newx, newy,used, rows, cols, depth+1);
                used[newx][newy] = false;
            }
        }
    }
    private static boolean check(int cur, boolean[][] used, int newx, int newy, int rows, int cols) {
        if (newx<0 || newx>=rows){
            return false;
        }
        if(newy<0 || newy>=cols)
            return false;
        if (used[newx][newy]==true)
            return false;
        if (nums[newx][newy]<=cur)
            return false;
        return true;
    }
}
