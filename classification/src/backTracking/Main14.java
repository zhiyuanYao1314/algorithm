package backTracking;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/16 15:59
 * 60 第k个排列
 */
public class Main14 {
    //
    // public String getPermutation(int n, int k) {
    //     boolean[] used = new boolean[n+1];
    //     this.k = k;
    //     dfs(n,0,"",used);
    //     return ans;
    // }
    // int k;
    // int count=0;
    // String ans;
    // private boolean dfs(int n, int depth, String s, boolean[] used) {
    //     if (depth==n){
    //         count++;
    //         if (count==k){
    //             ans = new String(s);
    //             return true;
    //         }
    //         else
    //             return false;
    //     }
    //     for (int i=1;i<=n;i++){
    //         if (used[i]) continue;
    //         s += i;
    //         used[i] = true;
    //         if (dfs(n, depth+1, s, used)){
    //             return true;
    //         }
    //         s  = s.substring(0,s.length()-1);
    //         used[i] = false;
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        Main14 main14 = new Main14();
        System.out.println(main14.getPermutation(3,2));// 123 132
    }
    String ans;
    int count;
    public String getPermutation(int n, int k) {
        if (n<=0) return ans;
        boolean[] used = new boolean[n];
        dfs(n,"", used, k);
        return ans;
    }

    public void dfs(int n, String path, boolean[] used,int k){
        if (path.length()==n){
            count++;
            if (count ==k){
                ans = path;
            }
            return;
        }
        for (int i=1;i<=n;i++){
            if (count==k) // 提前退出
                return;
            if (used[i-1])
                continue;
            used[i-1] =true;
            path += i;
            dfs(n,path,used, k);
            path = path.substring(0,path.length()-1);
            used[i-1] = false;
        }
    }

}
