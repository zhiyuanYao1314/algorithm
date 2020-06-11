package huawei;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/9 14:22
 * Describe:
 * version:1.0
 */
public class Main3 {

    private static int[][] chess= new int[9][9];

    public static void main(String[] args) {
        // 读取

        while ( !pdStatus()){
            for (int i=0;i<9;i++) {
                for (int j = 0; j < 9; j++) {
                    if (chess[i][j]==0){
                        calcFillin(i,j);
                    }
                }
            }
        }
    }

    private static void calcFillin(int row, int col) {
        int[] A= {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        for (int i=0;i<9;i++){
            if (i != col){
                if (chess[row][i] !=0){
                    A[chess[row][i]-1] =0;
                }
            }
        }
        for (int j=0;j<9;j++){
            if (j != row){

            }
        }

    }

    public static boolean pdStatus(){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (chess[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}
