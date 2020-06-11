package array;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 17:31
 *
 * 超级丑数
 */
public class Main18 {
    public static void main(String[] args) {
        Main18 main18 = new Main18();
        int[] primes = {2, 7, 13, 19};
        int i = main18.nthSuperUglyNumber(12, primes);
        System.out.println(i);
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n==1) return 1;
        // dp存储前面n个超级丑数
        int[] dp = new int[n+1];
        // 第一个丑数, 方便书写， 直接从1开始
        dp[1]  =1;
        // 每个prime对应的pointer
        int[] pointers = new int[primes.length];
        for (int i=0; i<pointers.length;i++){
            pointers[i] = 1;
        }
        for (int i=2;i<n+1;i++){
            // 取出最小元素的下标，并将该下标+1；
            int min = min(pointers,dp, primes);
            dp[i] = primes[min]*(dp[pointers[min]]);
            pointers[min]++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public int min(int[] pointers,int[] dp, int[] primes){
        int min=Integer.MAX_VALUE;
        int index =0;
        for (int i=0;i<pointers.length;i++){
            if (primes[i]*dp[pointers[i]]==min){

            }
            if (primes[i]*dp[pointers[i]]<min){
                min = primes[i]*dp[pointers[i]];
                index = i;
            }
        }
        return index;
    }
}