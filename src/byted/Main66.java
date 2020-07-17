package byted;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成
 *
 * 回溯
 */
public class Main66 {
    public static void main(String[] args) {
        Main66 m = new Main66();
        List<String> ss=  m.generateParenthesis(3);
        for (String s :ss)
            System.out.println(s);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        help(n, n, "",ans);
        return ans;
    }

//    List<String> ans = new ArrayList<>();
    void help(int l, int r, String path,List<String> ans){
        if (l==0 && r==0){
            ans.add(path);
            return;
        }
        if (l==0){
            for(int i=0;i<r;i++){
                path +=")";
            }
            ans.add(path);
            return;
        }
        if(r>l){
            path +=")";
            r--;
            help(l, r, path, ans);
            r++;
            path = path.substring(0,path.length()-1);
        }
        path+="(";
        l--;
        help(l, r, path,ans);
    }
}
