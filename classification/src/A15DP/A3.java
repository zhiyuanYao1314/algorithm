package A15DP;

import com.sun.corba.se.spi.orb.ORBData;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 10:19
 * Leetcode 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 *
 */
public class A3 {

    /**
     * 思路： 以(i,j)结尾的斐波那契 可以以(j-i, i)结尾的斐波那契求得
     *         dp[i][j] = dp[j-i][i]+1
     *  要求存在j-1元素且要知道j-i元素对应的下标；--> hashmap;
     *  同时保存dp[i][j] 对应的值；-->映射到 i*N+j一维空间，然后快速查找
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8}; // 3 [1,3,7,11,12,14,18]
        // int[] ints = {1,3,7,11,12,14,18}; // 3 []
        A3 a3 = new A3();
        int i = a3.lenLongestFibSubseq(ints);
        System.out.println(i);
    }

    /**
     * 首先想到的是(i,j)结尾的，然后从前向后求解；
     * 解决的问题： 判断(A[j]-A[i])存在且下标<i 使用hashmap
     * 计算dp的值的时候，使用j*N+i 将二维空间映射到一维空间使用hashmap加快速度
     */
    public int lenLongestFibSubseq(int[] A) {
        if (A.length<=2) return 0;
        HashMap<Integer, Integer> loc = new HashMap<>();
        for (int i=0;i<A.length;i++)
            loc.put(A[i], i);
        // int[][] dp = new int[A.length][A.length];
        // 空间优化
        HashMap<Integer, Integer> leng = new HashMap<>();
        int max =0;
        for (int i=0;i<A.length;i++){ // 以(j,i)结尾的斐波那契
            for (int j=0;j<i;j++){  // 5 2
                int cur = loc.getOrDefault(A[i]-A[j],-1);
                if (cur>=0 && cur<j){
                    int pre = leng.getOrDefault(j*A.length+cur,2);
                    leng.put(i*A.length+j,pre+1);
                    // dp[j][i] = (dp[cur][j]==0?2:dp[cur][j]) + 1;
                    if (pre+1>max) max = pre+1;
                }
                // System.out.println("j:"+j+" i:"+i+" cur: "+cur+" 结果: "+dp[j][i]);
                // if (dp[j][i]>max) max = dp[j][i];
            }
        }
        return max; // 0 >=3
    }
}
