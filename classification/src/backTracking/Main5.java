package backTracking;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 14:14
 * leetcode401: 二进制手表
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 第一行: 1 2 4 8 表示小时数
 * 第二行: 1 2 4 8 16 32 表示分钟数
 * 总和；
 */
public class Main5 {
    public static void main(String[] args) {
        Main5 main5 = new Main5();
        List<String> strings = main5.readBinaryWatch(2);
        System.out.println(strings);
    }

    List<String> ans = new LinkedList<>();
    public List<String> readBinaryWatch(int num) {
        int[][] visited = new int[10][2];
        visited[0][0] =1;visited[1][0] =2;visited[2][0] =4;visited[3][0] =8;
        visited[4][0] =1;visited[5][0] =2;visited[6][0] =4;visited[7][0] =8;
        visited[8][0] =16;visited[9][0] =32;
        dfs(num,0,visited);
        return ans;
    }
    /**
     *
     * @param n 表示层数，n==0, 表示所有数使用完
     * @param start 起始点，接下来的每一层只能从该点的右边开始， 避免重复计算。
     * @param visited 所有点是否访问过的情况
     */
    void dfs(int n, int start, int[][] visited){
        // 所有点使用完，放入最终答案；
        if (n==0) calculateTime(visited);
        for (int i=start;i<visited.length;i++){
            // ==0  && time<11 && <59
            if (check(i,visited)){
                visited[i][1] = 1;
                dfs(n-1, i+1,visited);
                visited[i][1] = 0;
            }
        }

    }

    // i表示当前点，visited表示之前的点
    private boolean check(int cur, int[][] visited) {
        if (visited[cur][1]==1) return false;
        int hour =0;
        for (int i=0;i<4;i++){
            if (visited[i][1]==1)
                hour += visited[i][0];
        }
        int minuter=0;
        for (int i=4;i<10;i++){
            if (visited[i][1]==1)
                minuter += visited[i][0];
        }
        if (cur<4){
            hour += visited[cur][0];
        }else {
            minuter += visited[cur][0];
        }
        if (hour<=11 && minuter<=59)
            return true;
        return false;
    }

    void calculateTime(int[][] visited){
        int hour =0;
        for (int i=0;i<4;i++){
            if (visited[i][1]==1)
                hour += visited[i][0];
        }
        int minuter=0;
        for (int i=4;i<10;i++){
            if (visited[i][1]==1)
                minuter += visited[i][0];
        }
        String str;
        if (minuter<=9){
            str = hour+":0"+minuter;
        }else str = hour+":"+minuter;
        ans.add(str);
    }
}
