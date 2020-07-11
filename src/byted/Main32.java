package byted;

/**
 * 62 不同路径
 * 回溯算法
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 */
public class Main32 {

    public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i=0;i<n;i++){
            dp[0][i] =1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }

    public int uniquePaths2(int m,int n){
        help(1,1,m,n);
        return ans;
    }
    int ans =0;
    public void help(int x, int y, int m ,int n){
        if (x>m || y>n)
            return;
        if (x==m && y ==n){
            ans ++;
            return ;
        }
        help(x+1, y, m, n);
        help(x, y+1, m, n);

    }
}
