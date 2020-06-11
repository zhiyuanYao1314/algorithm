package A5CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 1:06
 * 查找数组中没有出现的所有数字
 * 给定一个整数数组，其中1 ≤ a[i] ≤ n (n =数组的大小)，一些元素出现两次，其他元素出现一次。
 * 找到 [1,n] 中所有没有出现在此数组中的元素。
 *
 输入:
 [4,3,2,7,8,2,3,1]
 输出:
 [5,6]
 */
public class A1 {

    /**
     * time : n
     * space: n
     */
    public int[] findDisappearedNumbers(int[] arr){
        int len = arr.length;
        int[] ans = new int[len+1];
        for (int e: arr){
            ans[e] = 1;
        }
        int[] ret = new int[len];
        int l =0;
        for (int i=1;i<ans.length;i++){
            if (ans[i] ==0){
                ret[l++] = i;
            }
        }
        return Arrays.copyOf(ret, l);
    }

}
