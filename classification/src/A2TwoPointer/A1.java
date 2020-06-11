package A2TwoPointer;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 21:34
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */
public class A1 {
    public static void main(String[] args) {
        A1 a1 = new A1();
        int[] square = a1.square(new int[]{});
        System.out.println(Arrays.toString(square));
    }

    public static int[] square(int[] arr){
        int len = arr.length;
        int[] ans = new int[len];
        if (arr== null || arr.length==0) return ans;
        int newIndex = arr.length-1;
        int s =0, e = len-1;
        while (s<=e){
            int ss = arr[s]*arr[s];
            int es = arr[e]*arr[e];
            if (ss<es){
                e--;
                ans[newIndex--] = es;
            }else {
                s++;
                ans[newIndex--] = ss;
            }
        }
        return ans;
    }
}
