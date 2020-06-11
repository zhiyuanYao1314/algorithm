package A1SlidingWindow;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/23 18:37
 * 找到给定和的最大子序列
 * Find subarray with given sum
 *Given an unsorted array of nonnegative integers,
 * find a continous subarray which adds to a given number.
 *
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 */
public class A2 {

    public static void main(String[] args) {
        A2 a2 = new A2();
        int i = a2.SubArrayOfSumK(new int[]{1, 4, 20, 3, 10, 5}, 33);
        System.out.println(i);
    }

    /**
     * 因为非负数，设置一个窗口，[] 求和，
     * 大于k，左界限右移
     * 小于k，右界限右移
     * 等于k， 记录长度；
     */
    public static int SubArrayOfSumK(int[] arr, int k){
        if (arr ==null || arr.length<1) return -1;
        int s =0;
        int e =1;
        int sum = arr[0]+arr[1];
        int min =arr.length+1;
        while (e<arr.length){
            if (sum >k){
                if (s+1==e){
                    if (++e<arr.length)
                        sum = arr[++s]+arr[e];
                }else sum -=arr[s++];
            }
            else if (sum <k) {
                if (++e<arr.length)
                    sum +=arr[e];
            }
            else {
                if ((e-s+1<min))
                    min = e-s+1;
                s++; e++;
            }
        }
        if (min==arr.length+1) return -1;
        return min;
    }
}
