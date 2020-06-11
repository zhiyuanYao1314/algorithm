import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 17:03
 * Describe:
 * version:1.0
 */
public class Thirteen {

    public static void main(String[] args) {
        Thirteen thirteen = new Thirteen();
        int count = thirteen.movingCount(5, 10, 10);// 21 ?100?
        System.out.println(count);
    }

    int rows;
    int cols;
    boolean[][] matrix ;
    int threshold ;
    int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    public int movingCount(int threshold, int rows, int cols) {
        matrix = new boolean[rows][cols];
        this.threshold= threshold;
        this.rows = rows;
        this.cols= cols;
        backTrace(0,0);
        int sum =0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                // 这不是赋值语句！
                if (matrix[i][j] == true){
                    sum ++;
                }
            }
        }
        return sum;
    }

    public void backTrace(int r, int c){
        // 出边界 去过了 超出
        if (r<0 || r>=rows || c<0 || c>=cols
                || matrix[r][c]
                || !check(r,c)){
            return;
        }
        matrix[r][c]=true;// 可以走这条路

        for (int[] d: directions){
            backTrace(r+d[0],c+d[1]);
        }
    }

    public boolean check (int r, int c){
        int sum =0;
        while (r>0){
            sum += r%10;
            r = r/10;
        }
        while (c>0){
            sum += c%10;
            c = c/10;
        }
        if (sum >threshold) return false;
        return true;
    }
}
