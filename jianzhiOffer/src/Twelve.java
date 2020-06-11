/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 15:55
 * Describe:
 * version:1.0
 */
public class Twelve {

    public static void main(String[] args) {
        Twelve twelve = new Twelve();
        String arr = "abcesfcsadee";
        char[] chars = arr.toCharArray();
        String a2 = "abs";
        char[] s = a2.toCharArray();
        System.out.println(twelve.hasPath(chars, 3,4,s));
     }

    int[][] direction = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};// 上下左右
    int rows;
    int cols;
    char[][] matrixs;
    boolean[][] marked;
    char[] str;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        matrixs = new char[rows][cols];
        marked = new boolean[rows][cols];
        buildMatrix(matrix);
        for (int i =0;i<rows;i++){
            for (int j =0;j<cols;j++){
                if (backTrace(i,j,0)) return true;
            }
        }
        return false;
    }

    /**
     * 回溯算法 for循环，探索所有的路，
     * if 当前路可行，
     *  递归，if 可行 return true
     *  if 不可信 换一条路。。。
     * @param r
     * @param c
     * @param len
     * @return
     */
    // r c 当前位置， len为现有匹配长度
    public boolean  backTrace(int r, int c, int len){
        if (len == str.length) return true;
        // 不满足条件
        if (r<0 || r>=rows || c<0 || c>=cols || str[len] != matrixs[r][c] || marked[r][c]) {
            return false;
        }
        len ++;
        marked[r][c] = true;
        for (int[] d:direction){
            if (backTrace(r+d[0],c+d[1],len)){
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    public void buildMatrix(char[] matrix){
        int index =0;
        for (int i =0;i<rows;i++){
            for (int j=0;j<cols;j++){
                char tm = matrix[index++];
                matrixs[i][j] = tm;
            }
        }
    }
}
