package kuaishou;

import zhaohang.Mian6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 100%
public class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        int[] ints = main2.GetPowerFactor(33, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] GetPowerFactor (int R, int N) {
        ArrayList<Integer> arr = new ArrayList();
        int tmp = 1;
        int i =0;
        while (tmp<=R){
            arr.add(tmp);
            tmp *=N;
        }
        get(R, arr);
        if (ans.isEmpty()){
            return new int[0];
        }
        // java求

        int[] aa = new int[ans.size()];
        int l =0;
        for (Integer k: ans){
            aa[l++] = cal(k,N);
        }
        Arrays.sort(aa);
        return aa;
    }
    public int cal(int k, int d){
        if (k==1) return 0;
        int ans = 1;
        int tmp = k/d;
        while (tmp != 1){
            ans++;
            tmp = tmp/d;
        }
        return ans;
    }

    ArrayList<Integer> ans =new ArrayList<>();
    private boolean get(int R, ArrayList<Integer> arr) {
        if (R==0) return true;
        if (R<0) return false;
        if (arr.isEmpty()) return false;

        for (int i=0;i<arr.size();i++){
            ArrayList<Integer> cur = (ArrayList<Integer>) arr.clone();
            Integer in = cur.get(i);
            cur.remove(i);
            // 选择
            if (get(R - in, cur)){
                ans.add(in);
                return true;
            }else if (get(R, cur)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    // private ArrayList<Integer> getkk(int R, ArrayList<Integer> arr) {
    //     ArrayList<Integer> ans1 = new ArrayList<>();
    //     ArrayList<Integer> ans2 = new ArrayList<>();
    //     if (R==0) return ans1;
    //     if (R<0) return null;
    //     if (arr.isEmpty()) return null;
    //     ArrayList<Integer> ne = (ArrayList<Integer>) arr.clone();
    //     Integer in = ne.get(ne.size() - 1);
    //     ne.remove(ne.size() - 1);
    //     ans1.addAll(get(R,ne));
    //     ans2.addAll(get(R-in,ne));
    //
    // }


}
