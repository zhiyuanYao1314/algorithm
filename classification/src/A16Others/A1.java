package A16Others;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 16:08
 * 数组中和为0的最长连续子序列
 *
 * 要求O(n)
 */
public class A1 {
    public static void main(String[] args) {
        int i = sum0(new int[]{-1, 2, 2, 2, -6, 1});
        System.out.println(i);
    }

    /**
     * 前缀数字和
     * 1. 遍历一遍，sum[i] 为0-i的和
     * 2. 利用hashmap, if sum[i]==sum[j] 表明i-j之间的数组为0
     */
    public static int sum0(int[] arr){
        if (arr==null || arr.length==0) return 0;
        int[] sum = new int[arr.length];
        int tmp =0;
        int len = 0;
        for (int i=0;i<arr.length;i++){
            tmp += arr[i];
            sum[i] = tmp;
            if (tmp==0 && i+1>len){
                len = i+1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<sum.length;i++){
            Integer loc = map.get(sum[i]);
            if (loc != null){
                if (i-loc+1>len) len = i-loc+1;
            }else map.put(sum[i],i);
        }
        return len;
    }

}
