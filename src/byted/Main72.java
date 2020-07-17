package byted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54 螺旋矩阵
 *
 *  一圈一圈的打印
 */
public class Main72 {
    public static void main(String[] args) {
        Main72 m = new Main72();
        int[][] matrix = new int[][]{
                { 1, 2, 3 ,13},
            { 4, 5, 6 ,12},
            { 7, 8, 9 ,0}
        };
//        int[][] matrix = new int[][]{};
        List<Integer> ss = m.spiralOrder(matrix);
        for (Integer s : ss)
            System.out.print(s+" ");
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix ==null ||matrix.length==0 || matrix[0]==null || matrix[0].length==0)
            return ret;
        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;

        while (startRow<=endRow && startCol<=endCol){
            for (int i=startCol; i<=endCol;i++){
                ret.add(matrix[startRow][i]);
            }
            for (int i=startRow+1;i<=endRow;i++){
                ret.add(matrix[i][endCol]);
            }
//            startRow++;
//            endCol--;
            for (int i=endCol-1; i>=startCol;i--){
                if (endRow==startRow)
                    break;
                ret.add(matrix[endRow][i]);
            }
            for (int i=endRow-1;i>=startRow+1;i--){
                if (startCol==endCol)
                    break;
                ret.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }
        return ret;
    }

}
