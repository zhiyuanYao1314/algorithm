package A15DP.A101DP;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 15:52
 *
 *  给一个整数集合，问是否存在某个非空子集，使得子集内中的数字和为0。例：给定集合{−7, −3, −2, 5, 8}，答案是YES，
 *  因为子集{−3, −2, 5}的数字和是0。
 *  这个问题是NP完全问题，且或许是最容易描述的NP完全问题。
 */

public class A3 {
    public static void main(String[] args) {
        A3 a = new A3();
        boolean b = a.subEqualZero(new int[]{1,9,-7,2});
        System.out.println(b);
    }

    public boolean subEqualZero(int[] arr){
        Set<Integer> s = new HashSet<>();
        int sum =0;
        int n = arr.length;
        for (int i=0;i<n;i++){
            sum = arr[i];
            s.add(arr[i]);
            if (help(arr,n,s,sum))
                return true;
            s.remove((Integer)(arr[i]));
        }
        return false;
    }

    /**
     * @param arr 数组
     * @param n 长度
     * @param used 当前使用的
     * @param sum 当前的和
     * @return
     */
    public boolean help(int[] arr, int n,Set<Integer> used, int sum){
        // 和等于0，结束
        if (sum==0)
            return true;
        // 所有元素使用完；
        if (used.size()==n)
            return false;
        // 回溯
        for (int i=0;i<n;i++){
            if (used.contains(arr[i]))
                continue;
            sum += arr[i];
            used.add(arr[i]);
            if (help(arr, n, used, sum))
                return true;
            sum -=arr[i];
            used.remove((Integer)arr[i]);
        }
        return false;
    }

}