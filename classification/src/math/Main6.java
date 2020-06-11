package math;

import java.util.ArrayList;
/**
 * Time:2020/4/22 13:31
 */
public class Main6 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = FindContinuousSequence(100);
        for(ArrayList<Integer> ans : lists){
            System.out.println(ans);
        }

    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // i 表示序列开始的数
        for (int i=1;i<=sum/2;i++){
            int s =i;
            int all = sum;
            ArrayList<Integer> list = new ArrayList<>();
            while (all>0){
                all -= s;
                list.add(s);
                s++;
                if (all==0){
                    ans.add(list);
                    break;
                }
            }
        }
        return ans;
    }
}
