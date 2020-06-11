package backTracking;

import javax.xml.transform.dom.DOMResult;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/16 17:17
 * 77 组合
 *  组合的话，位置不同只能算一次。
 */
public class Main16 {
    // List<List<Integer>> ans = new ArrayList<>();
    // public List<List<Integer>> combine(int n, int k) {
    //     if (k>n) k =n;
    //     Deque<Integer> path = new ArrayDeque();
    //     dfs(n, 1, k, path);
    //     return ans;
    // }
    // private void dfs(int n, int depth, int k, Deque<Integer> path) {
    //     if (path.size()== k){
    //         ans.add(new ArrayList<>(path));
    //         return;
    //     }
    //     for (int i=depth;i<=n;i++){
    //         path.addLast(i);
    //         dfs(n,i+1,k,path);
    //         path.removeLast();
    //     }
    // }
    public static void main(String[] args) {
        Main16 main16 = new Main16();
        List<List<Integer>> combine = main16.combine(3, 2); // 1 2 3
        for (List<Integer> l: combine){
            System.out.println(l);
        }
    }
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combine(int n , int k){
        Deque<Integer> path = new ArrayDeque();
        dfs(n , 1, path, k);
        return ans;
    }
    // depth表示当前层从第几个元素开始
    private void dfs(int n, int depth,Deque<Integer> path, int k){
        if (path.size()==k){
            ans.add(new ArrayList(path));
            return;
        }
        for (int i=depth;i<=n;i++){
            path.addLast(i);
            dfs(n, i+1,path, k);
            path.removeLast();
        }
    }
}
