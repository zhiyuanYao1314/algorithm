package backTracking;

import link.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 22:31
 * 给定N个（N>3）囚犯， 开始在标号为N的牢房
 * 重新排序的时候 要求囚犯不能和 之前的相邻的囚犯 再次相邻，
 * 求所有的排序方法。
 * 举例：
 * N=4;
 * return [2,1,4,3],[3,4,1,2].
 * 因为2不能和1，3相邻； 3不能和2，4相邻。
 * 思路： 回溯。
 */
public class Main9 {

    public static void main(String[] args) {
        Main9 main9 = new Main9();
        List<String> ans = main9.premute(4);
        System.out.println(ans);

    }
    // List中每一个String是一种答案。
    List<String> ans = new ArrayList<>();
    int N; //作为全局变量，不需要每次递归传递
    public List<String> premute(int N){
        this.N = N;
        backtrack(new String());
        return ans;
    }

    void backtrack(String path){
        // 退出条件
        if (path.length()==N){
            ans.add(path);
            return;
        }
        // 选择当前符合条件的情况
        for (int i=1;i<=N;i++){
            if (!check(path,i))continue;
            String cur = path+i;
            backtrack(cur);
        }
    }
    private boolean check(String path, int i) {
        if (path.length()==0) return true;
        if (path.contains(""+(char)(i+'0')))return false;
        char right = path.charAt(path.length()-1);
        if ((i+'0'-1)==right ||(i+'0'+1) == right || (i+'0')==right)
            return false;
        return true;
    }

}
