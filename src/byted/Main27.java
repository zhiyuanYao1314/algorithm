package byted;

/**
 * 200 岛屿数量
 *
 * 思路：
 * 遍历所有的点，
 * 走过的路标记为2；
 *
 */
public class Main27 {

    public static void main(String[] args) {
        Main27 m = new Main27();
//        char[][] n = new char[][]{
//                {'1','0','1','1'},
//                {'0','0','1','0'},
//                {'0','1','0','1'}
//        };
        char[][] n = new char[][]{};
        int kl = m.numIslands(n);
        System.out.println(kl);
    }

    int[][] directinos  = new int[][]{{0,1}, {0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        int count=0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i =0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]=='1'){
                    dfs(i, j, grid);
                    ++ count;
                }
            }
        }
        return count;

    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] =2;
        int x, y;
        for (int[] direc: directinos){
            x = i+direc[0];
            y = j+direc[1];
            if (check(x, y, grid)){
//                grid[x][y]=2;
                dfs(x, y,grid);
            }
        }
    }

    /**
     * xy在范围内，且为1，
     */
    private boolean check(int x, int y, char[][] grid) {
        if (x>= 0 && x<grid.length && y>=0 && y<grid[0].length  && grid[x][y] =='1'){
            return true;
        }
        return false;
    }
}
