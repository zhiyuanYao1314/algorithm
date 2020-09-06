package csig;

import byted.泛型Andlanmbda.Container;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/9/6 16:15
 * Describe:
 * version:1.0
 */
public class Main4 {
    public static void main(String[] args) {
        // int min = min(new int[]{1, 1, 0, 0}, new int[]{0, 1, 1, 0}, 4);
        // System.out.println(min);
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        int[] companys = convert(s1);
        int[] gym = convert(s2);
        int min = min(companys, gym, n);
        System.out.println(min);
    }
    static int[] convert(String[] s){
        int[] res = new int[s.length];
        for (int i=0;i<s.length;i++){
            res[i]= new Integer(s[i]);
        }
        return res;
    }

    static int min(int[] gym, int[] company , int n){
        int[][] dp = new int[n+1][3];// 0:gym 1:com, 2:re
        for (int i=1;i<n+1;i++){
            for (int j=0;j<3;j++){
                dp[i][j]=n+2;
            }
        }
        for (int i=1;i<n+1;i++){
            dp[i][2] = min(dp[i-1][0],dp[i-1][1],dp[i-1][2])+1;
            if (company[i-1]==1){// 上班,休息；
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]);
            }
            if (gym[i-1]==1){
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]);
            }
        }
        // for (int i=0;i<n+1;i++){
        //     for (int j=0;j<3;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return min(dp[n][0], dp[n][1],dp[n][2]);
    }
    static  int min(int a, int b, int c){
        int t = Math.min(a,b);
        return Math.min(t,c);
    }

}