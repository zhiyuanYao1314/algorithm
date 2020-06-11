package others;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 12:26
 * Describe:
 * version:1.0
 */
public class Solve {

    public static void main(String[] args) {
        Solve s = new Solve();
        int n=2;
        int[] a = new int[]{338445,138976};
        int[] p = new int[]{1};
        int[] k = new int[]{868800,554660};
        int[] ans = s.solve2(n,a,p,k);
        System.out.println(Arrays.toString(ans));
    }

    // 2,[338445,138976],[1],[868800,554660]
    // time: n^2
    // space: n^2
    public int[] solve (int n, int[] a, int[] p, int[] k) {
        // [4,3,2,1]
        // [1,2,3]
        // [1,2,3,4]
        ArrayList<Integer>[] kits = new ArrayList[n];
        for (int i=0;i<n;i++){
            kits[i] = new ArrayList();
            kits[i].add(k[i]);
        }
        // 最后的答案。
        int[] ans = new int[n];
        for (int i=n-1;i>=0;i--){
            for (Integer in: kits[i]){
                // 问题解决不了，交给能力更高的人
                if (in>a[i]){
                    if (i>0){
                        kits[p[i-1]-1].add(in);
                    }
                    // 问题解决了,解决的问题+1
                }else {
                    ans[i] = ans[i]+1;
                }
            }
            kits[i] = null;
        }
        return ans;
    }


    /**
     * 从前往后一次计算，内部有个递归
     * 注意：边界的判断
     * @param n
     * @param a
     * @param p
     * @param k
     * @return
     */
    public int[] solve2(int n, int[] a , int[] p, int[] k){
        int[] ans = new int[n];
        if (a[0]>= k[0]) ans[0]++;
        for (int i=1;i<n;i++){
            int t = i; // 3
            int value = k[t];
            while (value>a[t] && t!= 0){
                t = p[t-1]-1;
            }
            if (value<= a[t]){
                ans[t]++;
            }
        }
        return ans;
    }

    public int[] solve3(int n, int[] a, int[] p, int[] k) {
        int[] rcd = new int[n];

        for (int i = 0; i < k.length; i++) {
            int qst = k[i];
            if (qst > a[0]) continue;
            if (qst == a[0]) {
                rcd[0]++;
                continue;
            }
            for (int pep = i; true; ) {
                if (a[pep] >= qst) {
                    rcd[pep]++;
                    break;
                }
                pep = p[pep - 1] - 1;
            }
        }
        return rcd;
    }


}
