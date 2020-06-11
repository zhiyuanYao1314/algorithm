package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 17:14
 * N皇后
 * 注意：代码的前后影响！！
 */
public class Main7 {

    // public static void main(String[] args) {
    //     Main7 main7 = new Main7();
    //     List<List<String>> lists = main7.solveNQueens(4);
    //     for (List<String> s: lists){
    //         System.out.println(s);
    //     }
    // }
    // int N;
    // List<List<String>> ans = new ArrayList<>();
    // //n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    // public List<List<String>> solveNQueens(int n) {
    //     ArrayList<StringBuffer> track = new ArrayList<>();
    //     N =n;
    //     StringBuffer str =new StringBuffer();
    //     while (n>0){
    //         str.append('.');
    //         n--;
    //     }
    //     n=N;
    //     while (n>0){
    //         StringBuffer s = new StringBuffer(str);
    //         track.add(s);
    //         n--;
    //     }
    //     backtrack(track,N-1);
    //     return ans;
    // }
    // // 答案 路径 当前选择 结束条件
    // void backtrack(ArrayList<StringBuffer> track, int n){
    //     if (n==-1) {
    //         List<String> ss = new ArrayList<>();
    //         for (StringBuffer sb: track){
    //             ss.add(sb.toString());
    //         }
    //         ans.add(ss);
    //         return;
    //     }
    //     for (int i=0;i<N;i++){
    //         if (check(track,n, i)){
    //             track.get(n).setCharAt(i,'Q');
    //             backtrack(track, n-1);
    //             track.get(n).setCharAt(i,'.');
    //         }
    //     }
    // }
    //
    // /**
    //  * @param stack 棋盘
    //  * @param n 当前行
    //  * @param i 当前列
    //  * @return
    //  */
    // private boolean check(ArrayList<StringBuffer> stack, int n, int i) {
    //     int nn = n;
    //     int ii=i;
    //     while (n<N){
    //         if (stack.get(n++).charAt(i)== 'Q'){
    //             return false;
    //         }
    //     }
    //     n=nn;i=ii;
    //     while (i<N && n<N){
    //         if (stack.get(n++).charAt(i++)== 'Q')
    //             return false;
    //     }
    //     n=nn;i=ii;
    //     while (i>=0 && n<N){
    //         if (stack.get(n++).charAt(i--)== 'Q')
    //             return false;
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        Main7 main7 = new Main7();
        List<List<String>> lists = main7.solveNQueens(4);
        for (List<String> s: lists){
            System.out.println(s);
        }
    }
    List<List<String>> ans = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        int[] locs = new int[n+1]; //1..n数组中的元素表示每一层放置的皇后的位置；
        dfs(n, 1, locs);
        return ans;
    }

    private void dfs(int n, int depth, int[] locs){
        // 之前的n层已经放置好
        if (depth == n+1){
            List<String> cur = build(locs);
            ans.add(cur);
            return;
        }
        for (int i=1;i<=n;i++){
            if (!check(depth, locs, i)){
                continue;
            }
            locs[depth] = i;
            dfs(n, depth+1, locs);
            locs[depth] = 0;
        }
    }
    // 不能在对角线
    private boolean check(int depth, int[] locs, int i){
        for (int j=1; j<depth;j++){
            if(locs[j]==i) // 当前列有人了！
                return false;
            // j -- locs[j]  3 3
            // depth -- i    4 2
            if (i-locs[j] == depth-j || i-locs[j] == j-depth){
                return false;
            }
        }
        return true;
    }

    // 从1开始
    private List<String> build (int[] locs){
        List ans = new ArrayList();
        for (int i=1;i<locs.length; i++){
            StringBuffer sb = new StringBuffer();
            for (int j=1;j<locs.length; j++){
                if(j==locs[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
