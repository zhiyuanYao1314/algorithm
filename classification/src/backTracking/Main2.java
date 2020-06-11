package backTracking;



/**
 * 在一个矩阵中是否包含某字符串所有字符的路径
 * a b c e
 * s f c s
 * a d e e
 * 包含bcced
 */
public class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.hasPath());
    }

    int rows = 3;
    int lines = 4;
    char[][] matrix = new char[][]{
        {'a','b','c','e'},
        {'s','f','c','s'},
        {'a','d','e','e'},
    };
    char[] target = new char[]{'b','c','c','e','d'};
    boolean[][] marked = new boolean[rows][lines];
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean hasPath() {
        for (int i=0;i<rows;i++){
            for (int j=0;j<lines;j++){
                if (backTrace(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrace(int x, int y, int len){
        // 成功退出条件：
        if (len == target.length) return true;
        // 失败: 出界，访问过，不相等
        if (x<0 || x>=rows || y<0||y>=lines || marked[x][y]==true || target[len] != matrix[x][y])
            return false;
        //记录当前条件，访问过
        marked[x][y] = true;
        // 继续往下走
        for (int[] di: directions){
            int nx = x+di[0];
            int ny = y+di[1];
            // 访问都为true
            if(backTrace(nx, ny,len+1)){
                return true;
                // 否则， 回溯
            }else {
                marked[x][y] = false;
            }
        }
        return false;
    }
}
