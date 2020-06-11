package guanglianda;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 11:56
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        List<String> strings = main2.generateParenthesis(1);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        put(n,n,new String());
        return ans;
    }
    List<String> ans = new ArrayList<>();
    private void put(int left, int right, String str) {
        if (left==0) {
            for (int i=1;i<=right;i++){
                str = str+")";
            }
            ans.add(str);
            return;
        }
        if (left>=right){
            str += "(";
            put(--left,right,str);
            return;
        }
        String l = str+"(";
        String r = str+")";
        put(left-1,right,l);// 1 3
        put(left,right-1,r);// 2 2
    }







}
