package backTracking;


/**
 * 机器人能走多远
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Main3 {

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
