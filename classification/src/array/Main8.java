package array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Main8 {
    public static void main(String[] args) {

    }
    /**
     * 如果给我一个确定的数组，则怎么打印呢？
     * 最外层一个while循环，
     * 每层分为上，右，下，左四个一维数组打印，
     */
    ArrayList<Integer> ans = new ArrayList<>();
    int [][] matrix;
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rs = 0;
        int cs = 0;
        int re = matrix.length-1;
        int ce = matrix[0].length-1;
        while (re>=rs && ce>=cs){
            print(matrix,rs++,re--,cs++,ce--);
        }
        return ans;
    }

    public void print(int [][] matrix, int rs,int re, int cs, int ce){
        for (int i= cs; i<=ce;i++){
            ans.add(matrix[rs][i]);
        }
        for (int i= rs+1; i<=re;i++){
            ans.add(matrix[i][ce]);
        }
        // 最后一行
        if (re>rs){
            for (int i= ce-1; i>=cs;i--){
                ans.add(matrix[re][i]);
            }
        }
        // 最后一列
        if (ce>cs){
            for (int i= re-1; i>=rs+1;i--){
                ans.add(matrix[i][cs]);
            }
        }
    }
}
