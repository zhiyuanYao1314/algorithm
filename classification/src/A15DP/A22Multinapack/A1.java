package A15DP.A22Multinapack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 15:59
 * Describe:
 * version:1.0
 */
public class A1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        for (int i=0;i<n;i++){
            int w =  sc.nextInt();
            int v =  sc.nextInt();
            int m =  sc.nextInt();
            for (int k=1;k<=m;k*=2){
                m -=k;
                ArrayList<Integer> tmp =  new ArrayList();
                tmp.add(w*k);
                tmp.add(v*k);
                list.add(tmp);
            }
            if (m>0){
                ArrayList<Integer> tmp =  new ArrayList();
                tmp.add(w*m);
                tmp.add(v*m);
                list.add(tmp);
            }
        }
        int ans = multiPack(list, W);
        System.out.println(ans);
    }

    private static int multiPack(ArrayList<ArrayList<Integer>> list, int W) {
        int[] dp = new int[W+1];
        for (int i=0;i<list.size();i++){
            for (int j=W;j>= list.get(i).get(0);j--){
                dp[j] = Math.max(dp[j], dp[j-list.get(i).get(0)]+list.get(i).get(1));
            }
        }
        return dp[W];
    }
}
