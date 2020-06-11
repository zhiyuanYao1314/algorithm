package array;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 16:54
 * 判断数独是否有效?
 */
public class Main16 {
    public static void main(String[] args) {
        char s = '0' - 2;
        System.out.println(s);
    }

    /**
     * 只需一遍遍历，
     * 遍历的时候，记录每一行每个数字出现的次数；
     * 记录每一列每个数字出现的次数
     * 记录每个格子中每个数字出现的次数。  (i,j) 对应的格子为  (i/3)*3+j;
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][]rows = new int[9][10];
        int[][]colums = new int[9][10];
        int[][]boxs = new int[9][10];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.') continue;
                int num = board[i][j]-'0';
                rows[i][num]++;
                colums[j][num]++;
                boxs[(i/3)*3+j/3][num]++;
                if (rows[i][num]+colums[j][num]+boxs[(i/3)*3+j/3][num]>3){
                    return false;
                }
            }
        }
        return true;
    }


}
