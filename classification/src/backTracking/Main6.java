package backTracking;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 14:14
 * leetcode37 数独
 * 回溯法，注意每一步 即使return；
 */
public class Main6{
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Main6 main6 = new Main6();
        main6.solveSudoku(board);
        for (char[] c:board){
            System.out.println(Arrays.toString(c));
        }
    }
    public void solveSudoku(char[][] board) {
        if (board==null) return;
        dfs(0,0, board);
    }

    boolean dfs(int r, int c, char[][] board) {
        if (r==8 && c ==9) return true; // 最后成功，返回true
        if (c<9){ // 每一行，从左往右。
            if (board[r][c]!='.'){
                return dfs(r,c+1,board);
            }
            for (char i='1';i<='9';i++){
                if (check(r,c,board,i)){
                    board[r][c]=i;
                    if (dfs(r,c+1,board)){
                        return true;
                    }
                    board[r][c] ='.';
                }
            }
        }
        if (c==9){
            return dfs(r+1,0,board);
        }
        return false;
    }
    /**
     *  核实. 左右以及 方格内未出现
     * @param r 当前行
     * @param c 当前列
     * @param board 之前的棋盘
     * @param num 放入的数字
     * @return
     */
    private boolean check(int r, int c, char[][] board, char num) {
        // if (board[r][c]!='.') return false;
        for (int i=0;i<9;i++){ // 列存在
            if (board[i][c]==num){
                return false;
            }
        }
        for (int i=0;i<9;i++){ // 行存在
            if (board[r][i]==num){
                return false;
            }
        }
        // 5/3=1 7/3=1
        int rowNum = r/3;
        int colNum = c/3;
        // 格子内存在
        for (int i=rowNum*3;i<(rowNum+1)*3;i++){
            for (int j=colNum*3;j<(colNum+1)*3;j++){
                if (board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}

